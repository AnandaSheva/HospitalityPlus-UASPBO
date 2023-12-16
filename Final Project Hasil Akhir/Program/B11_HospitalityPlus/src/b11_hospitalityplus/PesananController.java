package b11_hospitalityplus;

import db.DBHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PesananController implements Initializable{

    @FXML
    private Button btnOK;

    @FXML
    private Button btnconfirm;

    @FXML
    private TableColumn<Pemesanan, Date> colCheckin;

    @FXML
    private TableColumn<Pemesanan, Date> colCheckout;

    @FXML
    private TableColumn<Pemesanan, String> colEmail;

    @FXML
    private TableColumn<Pemesanan, String> colNama;
    
    @FXML
    private TableColumn<Pemesanan, Integer> colidpesan;

    @FXML
    private TableColumn<Pemesanan, Integer> colTamu;

    @FXML
    private TableColumn<Pemesanan, String> colTelepon;

    @FXML
    private DatePicker fieldCheckin;

    @FXML
    private DatePicker fieldCheckout;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldNama;

    @FXML
    private TextField fieldTamu;

    @FXML
    private TextField fieldTelepon;

    @FXML
    private TableView<Pemesanan> tblPemesanan;
    
    
    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnOK){
            insertRecord();
        }
    }
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
        showPemesanan();
    }
    
    @FXML
    void gotoPayment(ActionEvent event) throws IOException {
    int jumlahTamu = Integer.parseInt(fieldTamu.getText());

    Pemesanan pesan = new Pemesanan(
        fieldNama.getText(),
        fieldTelepon.getText(),
        fieldEmail.getText(),
        jumlahTamu,
        Date.valueOf(fieldCheckin.getValue()),
        Date.valueOf(fieldCheckout.getValue())
    );
    
    try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
    Parent root = loader.load(); 

    PaymentController paymentController = loader.getController();
    paymentController.showValue(pesan);
    
    Stage stage = (Stage) btnconfirm.getScene().getWindow();
    stage.setScene(new Scene(root));
    
    } catch (IOException ex) {
        }

    }
    
    public ObservableList<Pemesanan> getDataPemesanan(){
        ObservableList<Pemesanan> pesan = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM `pemesanan`";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Pemesanan temp;
            while(rs.next()){
                temp = new Pemesanan(
                       // rs.getInt("id_pemesanan"),
                        rs.getString("nama"),
                        rs.getString("no_telepon"),
                        rs.getString("email"),
                        rs.getInt("jumlah_tamu"),
                        rs.getDate("check_in"), 
                        rs.getDate("check_out")
                );
                pesan.add(temp);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return pesan;
    }
    
    public void showPemesanan(){
        ObservableList<Pemesanan> list = getDataPemesanan();
        colidpesan.setCellValueFactory(new PropertyValueFactory<>("id_pemesanan"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("no_telepon"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTamu.setCellValueFactory(new PropertyValueFactory<>("jumlah_tamu"));
        colCheckin.setCellValueFactory(new PropertyValueFactory<>("check_in"));
        colCheckout.setCellValueFactory(new PropertyValueFactory<>("check_out"));
        tblPemesanan.setItems(list);
    }
    
    private void update(String query){
        Connection conn = DBHelper.getConnection();
        Statement st;
        
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private Date convertToDate(LocalDate localDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = localDate.toString();

        try {
            return (Date) sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
private void insertRecord() {
    try (Connection connection = DBHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "INSERT INTO `pemesanan` (`nama`, `no_telepon`, `email`, `jumlah_tamu`, `check_in`, `check_out`) VALUES (?, ?, ?, ?, ?, ?)")) {

        preparedStatement.setString(1, fieldNama.getText());
        preparedStatement.setString(2, fieldTelepon.getText());
        preparedStatement.setString(3, fieldEmail.getText());
        preparedStatement.setInt(4, Integer.parseInt(fieldTamu.getText()));

        // Konversi LocalDate menjadi java.sql.Date
        LocalDate checkinDate = fieldCheckin.getValue();
        java.sql.Date sqlCheckinDate = java.sql.Date.valueOf(checkinDate);
        preparedStatement.setDate(5, sqlCheckinDate);

        // Konversi LocalDate menjadi java.sql.Date
        LocalDate checkoutDate = fieldCheckout.getValue();
        java.sql.Date sqlCheckoutDate = java.sql.Date.valueOf(checkoutDate);
        preparedStatement.setDate(6, sqlCheckoutDate);

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Data inserted successfully!");

        } else {
            System.out.println("Failed to insert data.");
        }

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
    }

}


    
}

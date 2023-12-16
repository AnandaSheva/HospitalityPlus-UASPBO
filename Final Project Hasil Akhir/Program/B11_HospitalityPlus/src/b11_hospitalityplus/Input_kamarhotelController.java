/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package b11_hospitalityplus;

import db.DBHelper;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Input_kamarhotelController implements Initializable{

    @FXML
    private Button btnDeletekamar;

    @FXML
    private Button btnInsertkamar;

    @FXML
    private Button btnUpdatekamar;

    @FXML
    private TableColumn<KamarHotel, Integer> colLuas;

    @FXML
    private TableColumn<KamarHotel, Integer> colNokamar;

    @FXML
    private TableColumn<KamarHotel, Integer> colNolantai;

    @FXML
    private TableColumn<KamarHotel, Integer> colid_jenis;

    @FXML
    private TableColumn<KamarHotel, Integer> colid_kamar;

    @FXML
    private TextField fieldIDjenis;

    @FXML
    private TextField fieldIDkamar;

    @FXML
    private TextField fieldLuaskamar;

    @FXML
    private TextField fieldNoKamar;

    @FXML
    private TextField fieldNoLantai;

    @FXML
    private TableView<?> tblKamarHotel;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsertkamar){
            insertRecord();
        }
        else if(event.getSource() == btnUpdatekamar){
            updateRecord();
        }else if(event.getSource() == btnDeletekamar){
            deleteRecord();
        }
    }
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
        showKamarHotel();
    }
    
//    public ObservableList<KamarHotel> getDataKamarHotel(){
//        ObservableList<KamarHotel> kamarhotel = FXCollections.observableArrayList();
//        Connection conn = DBHelper.getConnection();
//        String query = "SELECT * FROM `kamar_hotel`";
//        Statement st;
//        ResultSet rs;
//        
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery(query);
//            KamarHotel temp;
//            while(rs.next()){
//                temp = new KamarHotel(rs.getInt("id_jenis_kamar"), rs.getString("nama_jenis_kamar"), 
//                        rs.getInt("harga"), rs.getString("fitur_kamar"));
//                kamarhotel.add(temp);
//            }
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }
//        return kamarhotel;
//    }
//    
//    public void showKamarHotel(){
//        ObservableList<KamarHotel> list = getDataKamarHotel();
//        
//        colid_jenis.setCellValueFactory(new PropertyValueFactory<>("id_jenis_kamar"));
//        colnama_jenis.setCellValueFactory(new PropertyValueFactory<>("nama_jenis_kamar"));
//        colHargajenis.setCellValueFactory(new PropertyValueFactory<>("harga"));
//        colFitur.setCellValueFactory(new PropertyValueFactory<>("fitur_kamar"));
//        tblKamarHotel.setItems(list);
//    }
//    
//    private void update(String query){
//        Connection conn = DBHelper.getConnection();
//        Statement st;
//        
//        try{
//            st = conn.createStatement();
//            st.executeUpdate(query);
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }
//    }
//    
//    private void insertRecord() {
//        try (Connection connection = DBHelper.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO `kamar_hotel`(`id_jenis_kamar`, `nama_jenis_kamar`, `harga`, `fitur_kamar`) VALUES (?, ?, ?, ?)")) {
//
//            preparedStatement.setInt(1, Integer.parseInt (fieldIDjenis.getText()));
//            preparedStatement.setString(2, fieldNamaJenis.getText());
//            preparedStatement.setInt(3, Integer.parseInt (fieldHarga.getText()));
//            preparedStatement.setString(4, fieldFitur.getText());
//
//
//            int affectedRows = preparedStatement.executeUpdate();
//
//            if (affectedRows > 0) {
//                System.out.println("Data inserted successfully!");
//                showJenisKamar();
//                fieldIDjenis.clear();
//                fieldNamaJenis.clear();
//                fieldHarga.clear();
//                fieldFitur.clear();
//
//            } else {
//                System.out.println("Failed to insert data.");
//            }
//
//        } catch (SQLException | NumberFormatException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    
//    private void updateRecord() {
//    try (Connection connection = DBHelper.getConnection();
//         PreparedStatement preparedStatement = connection.prepareStatement(
//                 "UPDATE `jenis_kamar` SET `nama_jenis_kamar`=?, `harga`=?, `fitur_kamar`=? WHERE `id_jenis_kamar`=?")) {
//
//        preparedStatement.setString(1, fieldNamaJenis.getText());
//        preparedStatement.setInt(2, Integer.parseInt(fieldHarga.getText()));
//        preparedStatement.setString(3, fieldFitur.getText());
//        preparedStatement.setInt(4, Integer.parseInt(fieldIDjenis.getText()));
//
//        int affectedRows = preparedStatement.executeUpdate();
//
//        if (affectedRows > 0) {
//            System.out.println("Data updated successfully!");
//            showJenisKamar();
//                fieldIDjenis.clear();
//                fieldNamaJenis.clear();
//                fieldHarga.clear();
//                fieldFitur.clear();
//        } else {
//            System.out.println("Failed to update data.");
//        }
//
//    } catch (SQLException | NumberFormatException e) {
//        e.printStackTrace();
//    }
//}
//    
//    private void deleteRecord() {
//    try (Connection connection = DBHelper.getConnection();
//         PreparedStatement preparedStatement = connection.prepareStatement(
//                 "DELETE FROM `jenis_kamar` WHERE `id_jenis_kamar`=?")) {
//
//        preparedStatement.setInt(1, Integer.parseInt(fieldIDjenis.getText()));
//
//        int affectedRows = preparedStatement.executeUpdate();
//
//        if (affectedRows > 0) {
//            System.out.println("Data deleted successfully!");
//            showJenisKamar();
//                fieldIDjenis.clear();
//                fieldNamaJenis.clear();
//                fieldHarga.clear();
//                fieldFitur.clear();
//        } else {
//            System.out.println("Failed to delete data.");
//        }
//
//    } catch (SQLException | NumberFormatException e) {
//        e.printStackTrace();
//    }
//}
//    
//
}


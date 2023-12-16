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

public class Input_jeniskamarController implements Initializable{

    @FXML
    private Button btnDeletejenis;

    @FXML
    private Button btnInsertjenis;

    @FXML
    private Button btnUpdatejenis;

    @FXML
    private TableColumn<JenisKamar, String> colFitur;

    @FXML
    private TableColumn<JenisKamar, Integer> colHargajenis;

    @FXML
    private TableColumn<JenisKamar, Integer> colid_jenis;

    @FXML
    private TableColumn<JenisKamar, String> colnama_jenis;

    @FXML
    private TextField fieldFitur;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldIDjenis;

    @FXML
    private TextField fieldNamaJenis;

    @FXML
    private TableView<JenisKamar> tblJenisKamar;
    
    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsertjenis){
            insertRecord();
        }
        else if(event.getSource() == btnUpdatejenis){
            updateRecord();
        }else if(event.getSource() == btnDeletejenis){
            deleteRecord();
        }
    }
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
        showJenisKamar();
    }
    
    public ObservableList<JenisKamar> getDataJenisKamar(){
        ObservableList<JenisKamar> jeniskamar = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM `jenis_kamar`";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            JenisKamar temp;
            while(rs.next()){
                temp = new JenisKamar(rs.getInt("id_jenis_kamar"), rs.getString("nama_jenis_kamar"), 
                        rs.getInt("harga"), rs.getString("fitur_kamar"));
                jeniskamar.add(temp);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return jeniskamar;
    }
    
    public void showJenisKamar(){
        ObservableList<JenisKamar> list = getDataJenisKamar();
        
        colid_jenis.setCellValueFactory(new PropertyValueFactory<>("id_jenis_kamar"));
        colnama_jenis.setCellValueFactory(new PropertyValueFactory<>("nama_jenis_kamar"));
        colHargajenis.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colFitur.setCellValueFactory(new PropertyValueFactory<>("fitur_kamar"));
        tblJenisKamar.setItems(list);
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
    
    private void insertRecord() {
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO `jenis_kamar`(`id_jenis_kamar`, `nama_jenis_kamar`, `harga`, `fitur_kamar`) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setInt(1, Integer.parseInt (fieldIDjenis.getText()));
            preparedStatement.setString(2, fieldNamaJenis.getText());
            preparedStatement.setInt(3, Integer.parseInt (fieldHarga.getText()));
            preparedStatement.setString(4, fieldFitur.getText());


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Data inserted successfully!");
                showJenisKamar();
                fieldIDjenis.clear();
                fieldNamaJenis.clear();
                fieldHarga.clear();
                fieldFitur.clear();

            } else {
                System.out.println("Failed to insert data.");
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }


    }
    
    private void updateRecord() {
    try (Connection connection = DBHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE `jenis_kamar` SET `nama_jenis_kamar`=?, `harga`=?, `fitur_kamar`=? WHERE `id_jenis_kamar`=?")) {

        preparedStatement.setString(1, fieldNamaJenis.getText());
        preparedStatement.setInt(2, Integer.parseInt(fieldHarga.getText()));
        preparedStatement.setString(3, fieldFitur.getText());
        preparedStatement.setInt(4, Integer.parseInt(fieldIDjenis.getText()));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Data updated successfully!");
            showJenisKamar();
                fieldIDjenis.clear();
                fieldNamaJenis.clear();
                fieldHarga.clear();
                fieldFitur.clear();
        } else {
            System.out.println("Failed to update data.");
        }

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
    }
}
    
    private void deleteRecord() {
    try (Connection connection = DBHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "DELETE FROM `jenis_kamar` WHERE `id_jenis_kamar`=?")) {

        preparedStatement.setInt(1, Integer.parseInt(fieldIDjenis.getText()));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Data deleted successfully!");
            showJenisKamar();
                fieldIDjenis.clear();
                fieldNamaJenis.clear();
                fieldHarga.clear();
                fieldFitur.clear();
        } else {
            System.out.println("Failed to delete data.");
        }

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
    }
}



    
//    private void updateRecord(){
//        String query = "UPDATE `jenis_kamar` SET nama = '" + fieldNamaJenis.getText() + "', alamat = '" + tfAlamat.getText()
//                + "' WHERE id_jenis_kamar = '" + fieldIDjenis.getText() + "'";
//        update(query);
//        showMahasiswa();
//        
//        tfNpm.clear();
//        tfNama.clear();
//        tfAlamat.clear();
//    }
//    
//    private void deleteRecord(){
//        String query = "DELETE FROM `mahasiswa` WHERE npm = '" + tfNpm.getText() + "'";
//        update(query);
//        showMahasiswa();
//        
//        tfNpm.clear();
//    }
//
}

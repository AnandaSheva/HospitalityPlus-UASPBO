/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package b11_hospitalityplus;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FasilitasController {

    @FXML
    private Button btnfacilitie;

    @FXML
    private Button btninvoic;

    @FXML
    private Button btnmeet;

    @FXML
    private Button btnresto;

    @FXML
    private Button btnrooms;

    @FXML
    void gotoFasilitas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fasilitas.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnfacilitie.getScene().getWindow();
        stage.setScene(new Scene(root));    

    }

    @FXML
    void gotodetailFasilitas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailFasilitas.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnresto.getScene().getWindow();
        stage.setScene(new Scene(root));    
        
    }

    @FXML
    void gotomain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnrooms.getScene().getWindow();
        stage.setScene(new Scene(root));        

    }

    @FXML
    void gotoinvoice(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btninvoic.getScene().getWindow();
        stage.setScene(new Scene(root));        

    }


    @FXML
    void gotomeetroom(ActionEvent event) {
  

    }

}











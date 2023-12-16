package b11_hospitalityplus;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button btndetail;

    @FXML
    private Button btnfacilities;

    @FXML
    private Button btninvoice;

    @FXML
    private Button btnroom;

    @FXML
    void gotodetail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detail.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btndetail.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    void gotofacilities(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fasilitas.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnfacilities.getScene().getWindow();
        stage.setScene(new Scene(root));        

    }

    @FXML
    void gotoinvoice(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btninvoice.getScene().getWindow();
        stage.setScene(new Scene(root));        

    }

    @FXML
    void gotomain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnroom.getScene().getWindow();
        stage.setScene(new Scene(root));        

    }

}

package b11_hospitalityplus;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btnlogin;

    @FXML
    void gotopage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnlogin.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

}

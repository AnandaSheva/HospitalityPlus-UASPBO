package b11_hospitalityplus;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class PaymentController {

    @FXML
    private RadioButton btndebit;

    @FXML
    private RadioButton btnewallet;

    @FXML
    private RadioButton btnkredit;

    @FXML
    private Button btnpayment;

    @FXML
    private Label soutCheckin;

    @FXML
    private Label soutCheckout;

    @FXML
    private Label soutEmail;

    @FXML
    private Label soutNama;

    @FXML
    private Label soutTamu;

    @FXML
    private Label soutTelepon;
    
    @FXML
    void showValue(Pemesanan pesan) {
        int jumlahTamu = pesan.getJumlahTamu();
        soutTamu.setText(Integer.toString(jumlahTamu));

        soutNama.setText(pesan.getNama());
        soutTelepon.setText(pesan.getNoTelpon());
        soutEmail.setText(pesan.getEmail());
        soutTamu.setText(Integer.toString(pesan.getJumlahTamu()));
        soutCheckin.setText(String.format("%s", pesan.getTanggalCheckin().toString()));
        soutCheckout.setText(String.format("%s", pesan.getTanggalCheckout().toString()));
    }
    
    @FXML   
    void gotonotif(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("notif.fxml"));
        Parent root;
        try {
            root = loader.load();
            Stage stage = (Stage) btnpayment.getScene().getWindow();
            stage.setScene(new Scene(root));   
        } catch (IOException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);

        }        
    }

}

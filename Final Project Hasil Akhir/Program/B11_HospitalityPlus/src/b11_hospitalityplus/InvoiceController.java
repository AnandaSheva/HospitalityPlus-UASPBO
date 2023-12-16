/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package b11_hospitalityplus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InvoiceController {

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
    void showDataPayment(Pemesanan pesan) {
        int jumlahTamu = pesan.getJumlahTamu();
        soutTamu.setText(Integer.toString(jumlahTamu));
        soutNama.setText(pesan.getNama());
        soutTelepon.setText(pesan.getNoTelpon());
        soutEmail.setText(pesan.getEmail());
        soutTamu.setText(Integer.toString(pesan.getJumlahTamu()));
        soutCheckin.setText(String.format("%s", pesan.getTanggalCheckin().toString()));
        soutCheckout.setText(String.format("%s", pesan.getTanggalCheckout().toString()));
    }

}

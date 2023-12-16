/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ACER
 */
public class Pemesanan {
    private int id_pemesanan;
    private String nama;
    private String noTelpon;
    private String email;
    private int jumlahTamu;
    private Date tanggalCheckin;
    private Date tanggalCheckout;

//    public Pemesanan(int id_pemesanan, String nama, String noTelpon, String email, int jumlahTamu, Date tanggalCheckin, Date tanggalCheckout) {
//        this.id_pemesanan = 0;
//        this.nama = nama;
//        this.noTelpon = noTelpon;
//        this.email = email;
//        this.jumlahTamu = jumlahTamu;
//        this.tanggalCheckin = tanggalCheckin;
//        this.tanggalCheckout = tanggalCheckout;
//    }
    
    public Pemesanan(String nama, String noTelpon, String email, int jumlahTamu, Date tanggalCheckin, Date tanggalCheckout) {
        this.nama = nama;
        this.noTelpon = noTelpon;
        this.email = email;
        this.jumlahTamu = jumlahTamu;
        this.tanggalCheckin = tanggalCheckin;
        this.tanggalCheckout = tanggalCheckout;
    }

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJumlahTamu(int jumlahTamu) {
        this.jumlahTamu = jumlahTamu;
    }

    public void setTanggalCheckin(Date tanggalCheckin) {
        this.tanggalCheckin = tanggalCheckin;
    }

    public void setTanggalCheckout(Date tanggalCheckout) {
        this.tanggalCheckout = tanggalCheckout;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    public String getEmail() {
        return email;
    }

    public int getJumlahTamu() {
        return jumlahTamu;
    }

    public Date getTanggalCheckin() {
        return tanggalCheckin;
    }

    public Date getTanggalCheckout() {
        return tanggalCheckout;
    }
    
  
}

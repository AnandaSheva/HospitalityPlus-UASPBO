/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

/**
 *
 * @author ACER
 */
public class JenisKamar {
    private int id_jenis_kamar;
    private String nama_jenis_kamar;
    private int harga;
    private String fitur_kamar;

    public JenisKamar(int id_jenis_kamar, String nama_jenis_kamar, int harga, String fitur_kamar) {
        this.id_jenis_kamar = id_jenis_kamar;
        this.nama_jenis_kamar = nama_jenis_kamar;
        this.harga = harga;
        this.fitur_kamar = fitur_kamar;
    }

    public int getId_jenis_kamar() {
        return id_jenis_kamar;
    }

    public void setId_jenis_kamar(int id_jenis_kamar) {
        this.id_jenis_kamar = id_jenis_kamar;
    }

    public String getNama_jenis_kamar() {
        return nama_jenis_kamar;
    }

    public void setNama_jenis_kamar(String nama_jenis_kamar) {
        this.nama_jenis_kamar = nama_jenis_kamar;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getFitur_kamar() {
        return fitur_kamar;
    }

    public void setFitur_kamar(String fitur_kamar) {
        this.fitur_kamar = fitur_kamar;
    }
    
    
}

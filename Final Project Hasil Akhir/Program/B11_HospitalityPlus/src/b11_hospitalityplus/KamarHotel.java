/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b11_hospitalityplus;

/**
 *
 * @author ACER
 */
public class KamarHotel {
    private int id_kamar;
    private int id_jenis_kamar;
    private int nomor_kamar;
    private int nomor_lantai;
    private int luas;

    public KamarHotel(int id_kamar, int id_jenis_kamar, int nomor_kamar, int nomor_lantai, int luas) {
        this.id_kamar = id_kamar;
        this.id_jenis_kamar = id_jenis_kamar;
        this.nomor_kamar = nomor_kamar;
        this.nomor_lantai = nomor_lantai;
        this.luas = luas;
    }

    public int getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(int id_kamar) {
        this.id_kamar = id_kamar;
    }

    public int getId_jenis_kamar() {
        return id_jenis_kamar;
    }

    public void setId_jenis_kamar(int id_jenis_kamar) {
        this.id_jenis_kamar = id_jenis_kamar;
    }

    public int getNomor_kamar() {
        return nomor_kamar;
    }

    public void setNomor_kamar(int nomor_kamar) {
        this.nomor_kamar = nomor_kamar;
    }

    public int getNomor_lantai() {
        return nomor_lantai;
    }

    public void setNomor_lantai(int nomor_lantai) {
        this.nomor_lantai = nomor_lantai;
    }

    public int getLuas() {
        return luas;
    }

    public void setLuas(int luas) {
        this.luas = luas;
    }

    
}

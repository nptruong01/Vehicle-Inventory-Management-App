package model;


import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Than
 */
public class Oto implements Serializable {

    private String id, maoto, tenoto, makho, mancc,mausac,date;
    private float donvitinh,tonkho;
//    private Date dob;// dd/mm/yyyy

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaoto() {
        return maoto;
    }

    public void setMaoto(String maoto) {
        this.maoto = maoto;
    }

    public String getTenoto() {
        return tenoto;
    }

    public void setTenoto(String tenoto) {
        this.tenoto = tenoto;
    }

    public String getMakho() {
        return makho;
    }

    public void setMakho(String makho) {
        this.makho = makho;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(float donvitinh) {
        this.donvitinh = donvitinh;
    }

    public float getTonkho() {
        return tonkho;
    }

    public void setTonkho(float tonkho) {
        this.tonkho = tonkho;
    }


}

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
public class Phieunhap implements Serializable {

    private String sophieunhap, maoto,mancc, ngaynhap;
    private float soluongnhap;
//    private Date dob;// dd/mm/yyyy

    public Phieunhap(String sophieunhap, String maoto, String mancc, String ngaynhap, float soluongnhap) {
        this.sophieunhap = sophieunhap;
        this.maoto = maoto;
        this.mancc = mancc;
        this.ngaynhap = ngaynhap;
        this.soluongnhap = soluongnhap;
    }

    public Phieunhap() {
    }

    public String getSophieunhap() {
        return sophieunhap;
    }

    public void setSophieunhap(String sophieunhap) {
        this.sophieunhap = sophieunhap;
    }

    public String getMaoto() {
        return maoto;
    }

    public void setMaoto(String maoto) {
        this.maoto = maoto;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public float getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(float soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    




}

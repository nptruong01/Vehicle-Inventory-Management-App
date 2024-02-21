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
public class Phieuxuat implements Serializable {

    private String sophieuxuat, maoto, ngayxuat;
    private float soluongxuat;
//    private Date dob;// dd/mm/yyyy

    public Phieuxuat(String sophieuxuat, String maoto, String ngayxuat, float soluongxuat) {
        this.sophieuxuat = sophieuxuat;
        this.maoto = maoto;
        this.ngayxuat = ngayxuat;
        this.soluongxuat = soluongxuat;
    }

    public Phieuxuat() {
    }

    public String getSophieuxuat() {
        return sophieuxuat;
    }

    public void setSophieuxuat(String sophieuxuat) {
        this.sophieuxuat = sophieuxuat;
    }

    public String getMaoto() {
        return maoto;
    }

    public void setMaoto(String maoto) {
        this.maoto = maoto;
    }

    public String getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(String ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public float getSoluongxuat() {
        return soluongxuat;
    }

    public void setSoluongxuat(float soluongxuat) {
        this.soluongxuat = soluongxuat;
    }




}

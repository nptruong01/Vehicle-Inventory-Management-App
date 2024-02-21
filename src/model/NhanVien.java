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
public class NhanVien implements Serializable {

    private String id , name, tendangnhap, matkhau;
   
//    private Date dob;// dd/mm/yyyy

    public NhanVien() {
    }

    public NhanVien(String id, String name, String tendangnhap, String matkhau) {
        this.id = id;
        this.name = name;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    




}

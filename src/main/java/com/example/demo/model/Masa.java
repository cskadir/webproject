package com.example.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cScientist on 8.07.2019.
 */
public class Masa implements IHesap {
    private List<Urun> masaUrunleri = new ArrayList<>();
    private int masaNo;
    private String name ;
    private Boolean isOpen=false;
    private double bill=0;

    public Masa(int masaNo, String name) {
        this.masaNo = masaNo;
        this.name = name;
        isOpen=false;
        bill=0;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(int masaNo) {
        this.masaNo = masaNo;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Urun> getMasaUrunleri() {
        return masaUrunleri;
    }

    public void setMasaUrunleri(ArrayList<Urun> masaUrunleri) {
        this.masaUrunleri = masaUrunleri;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public BigDecimal hesapAl() {


        BigDecimal toplam = BigDecimal.ZERO ;
        for (Urun o : masaUrunleri){
            toplam = toplam.add(o.hesapAl());
        }

        return null;
    }

    //

}

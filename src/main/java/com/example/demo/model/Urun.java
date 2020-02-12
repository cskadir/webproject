package com.example.demo.model;

import java.math.BigDecimal;

/**
 * Created by cScientist on 8.07.2019.
 */
public abstract class Urun implements IHesap {

    private String name;
    private int id;
    private double fiyat;
    private int indirim;
    private static int totalUrun=0;


    public Urun(String name, double fiyat, int indirim) {
        this.name = name;
        this.fiyat = fiyat;
        this.indirim = indirim;
        this.id=100+totalUrun;
        totalUrun++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    public int getIndirim() {
        return indirim;
    }
    public void setIndirim(int indirim) {
        this.indirim = indirim;
    }

    @Override
    public BigDecimal hesapAl() {

        return new BigDecimal(fiyat*indirim);
    }

    //

}

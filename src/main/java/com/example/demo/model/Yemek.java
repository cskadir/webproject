package com.example.demo.model;

/**
 * Created by cScientist on 10.07.2019.
 */
public class Yemek extends Urun
{
    String pisirmeSuresi;


    public Yemek(String pişirmeSuresi,String name, double fiyat, int indirim) {
        super(name, fiyat, indirim);
        this.pisirmeSuresi = pişirmeSuresi;
    }

    public String getPisirmeSuresi() {
        return pisirmeSuresi;
    }

    public void setPisirmeSuresi(String pisirmeSuresi) {
        this.pisirmeSuresi = pisirmeSuresi;
    }
}

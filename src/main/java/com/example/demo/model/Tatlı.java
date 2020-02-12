package com.example.demo.model;

/**
 * Created by cScientist on 10.07.2019.
 */
public class Tatlı extends Urun {

    String pisirmeSekli;

    public Tatlı(String name, double fiyat, int indirim, String pişirmeSekli) {
        super(name, fiyat, indirim);
        this.pisirmeSekli = pişirmeSekli;
    }

    public String getPisirmeSekli() {
        return pisirmeSekli;
    }
    public void setPisirmeSekli(String pisirmeSekli) {
        this.pisirmeSekli = pisirmeSekli;
    }


}

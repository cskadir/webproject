package com.example.demo.model;

/**
 * Created by cScientist on 10.07.2019.
 */
public class Icecek extends Urun {

    boolean asitliMi;
    boolean sıcakMi;



    public Icecek(String name, double fiyat, int indirim, boolean asitliMi, boolean sıcakMi) {
        super(name, fiyat, indirim);
        this.asitliMi = asitliMi;
        this.sıcakMi = sıcakMi;
    }

    public boolean isSıcakMi() {
        return sıcakMi;
    }

    public void setSıcakMi(boolean sıcakMi) {
        this.sıcakMi = sıcakMi;
    }

    public boolean isAsitliMi() {
        return asitliMi;
    }

    public void setAsitliMi(boolean asitliMi) {
        this.asitliMi = asitliMi;
    }
}

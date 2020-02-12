package com.example.demo.dao;

import com.example.demo.model.Masa;
import com.example.demo.model.Urun;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cScientist on 9.07.2019.
 */
@Component
public class DataBase {

    private List<Masa> masalar = DataBaseController.texttenMasalarıOku();
    private  List<Urun>urunler = DataBaseController.texttenUrunleriOku();;

    public static String kullaniniAdi="admin";
    public static  String sifre="sifre";

    public List<Masa> getMasalar() {
        return masalar;
    }

    public void setMasalar(List<Masa> masalar) {
        this.masalar = masalar;
    }

    public List<Urun> getUrunler() {
        return urunler;
    }

    public void setUrunler(List<Urun> urunler) {
        this.urunler = urunler;
    }


}

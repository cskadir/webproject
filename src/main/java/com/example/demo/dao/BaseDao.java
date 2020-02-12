package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cScientist on 9.07.2019.
 */
@Component
public class BaseDao implements IDao  {

    @Autowired
    DataBase database ;

    public List<Urun> getUrunler() {

        return database.getUrunler();
    }

    public List<Masa> getMasa() {
        return database.getMasalar();
    }

    public void kaydetMasa(Masa masa) {
        database.getMasalar().add(masa);
    }
    public void ekleYemek(Yemek yemek) {
        database.getUrunler().add(yemek);
    }

    public void ekleIcecek(Icecek ıcecek) {
        database.getUrunler().add(ıcecek);
    }

    public void ekleTatlı(Tatlı tatlı) {
        database.getUrunler().add(tatlı);
    }

    public void ekleMasa(Masa masa) {
        database.getMasalar().add(masa);
    }




}

package com.example.demo.Service;


import com.example.demo.dao.BaseDao;
import com.example.demo.dao.DataBase;
import com.example.demo.dao.IDao;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cScientist on 9.07.2019.
 */
@Component
@ComponentScan( basePackages = {"com.example.demo.dao"} )
public class OrderServis {
    @Autowired
    private BaseDao dao ;

    List<Masa> masalar  ;


    private List<Masa> siparisAlinanMasalar;

    public OrderServis() {
    }

    public List<Masa> showMasa() {
        if(masalar==null)
            masalar=dao.getMasa();
        return masalar ;
    }

    public List<Urun>getUrunler(){

        return dao.getUrunler();
    }

    public String clearList() {
        return null ;

    }

    public String masayaUrunSiparisiAl(Urun urun,int masaNo) {

        for (Masa masa : masalar) {
            if(masa.getMasaNo()==masaNo){

                masa.getMasaUrunleri().add(urun);
                masa.setBill(urun.getFiyat()+masa.getBill());
                masa.setOpen(true);
                return urun.getName()+" ISIMLI URUN " +masa.getMasaNo()+" NOLU MASAYA EKLENDİ" ;
            }
        }
        return "HATA" ;
    }

    private void tumMasalariGuncelle(){
        for (Masa masa : masalar) {
            masa.setBill(0);
            for (Urun urun : masa.getMasaUrunleri()) {
                masa.setBill(urun.getFiyat()+masa.getBill());
            }



        }
    }

    public Boolean adminKontrol(User user) {

        if(user.getName().equals(DataBase.kullaniniAdi) &&
                user.getPass().equals(DataBase.sifre))
            return true ;

        return false ;
    }

    public List<Urun> showUrun(int masaNo) {
        for (Masa masa : masalar) {
            if(masa.getMasaNo()==masaNo)
                return masa.getMasaUrunleri();
        }
        return null;
    }

    public String hesapAl(Integer masaNo) {
        double hesap=0;
        for (Masa masa : masalar) {
            if(masa.getMasaNo()==masaNo){
                hesap=masa.getBill();
                masa.setBill(0);
                masa.setOpen(false);
                masa.getMasaUrunleri().clear();
            }
        }
        return  Double.toString(hesap);




    }

    public Urun urunGetir(int id) {

        for (Urun urun : getUrunler()) {
            if(urun.getId()==id) {
                return urun;
            }
        }
        return null;
    }


    public void guncelleUrun(int id, String name, Double fiyat, int indirim, String pisirmeSuresi,
                                   String pisirmeSekli,boolean asitliMi,boolean sıcakMi) {
        if(id!=0){
            for (Urun urun : getUrunler()) {
                if(urun.getId()==id)
                {
                    urun.setIndirim(indirim);
                    urun.setName(name);
                    urun.setFiyat(fiyat);
                  if(urun instanceof Yemek){
                      ((Yemek)urun).setPisirmeSuresi(pisirmeSuresi);
                  }
                  else if(urun instanceof Icecek){
                      ((Icecek)urun).setAsitliMi(asitliMi);
                      ((Icecek)urun).setSıcakMi(sıcakMi);
                  }else if(urun instanceof Tatlı){
                      ((Tatlı)urun).setPisirmeSekli(pisirmeSekli);
                  }

                }
            }
            tumMasalariGuncelle();
        }


    }

    public void YemekEkle(Yemek yemek) {
        getUrunler().add(yemek);
    }

    public void tatlıEkle(Tatlı tatlı) {
        getUrunler().add(tatlı);
    }

    public void icecekEkle(Icecek ıcecek) {
        getUrunler().add(ıcecek);
    }
}

package com.example.demo.controller.orderServis;

import com.example.demo.Service.OrderServis;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cScientist on 9.07.2019.
 */
@RestController
public class OrderController {
    @Autowired
     OrderServis orderServis ;


    @RequestMapping("/getUrunler")
    public List<Urun> getUrunler(){
        return orderServis.getUrunler();
    }

    @RequestMapping("/urunDuzenlemeEkrani/edit/urunGuncelle")
    public String urunGetir(@RequestParam int id,@RequestParam String name,@RequestParam Double fiyat,@RequestParam int  indirim,
                                @RequestParam String  pisirmeSuresi,@RequestParam String  pisirmeSekli,
                                @RequestParam boolean  asitliMi,@RequestParam boolean  sicakMi){
         orderServis.guncelleUrun(id, name, fiyat, indirim, pisirmeSuresi, pisirmeSekli, asitliMi, sicakMi);
        return "Degisiklikler Kaydedildi.";
    }

    @RequestMapping("/urunDuzenlemeEkrani/edit")
    public Urun urunGetir( @RequestParam int id){

        return orderServis.urunGetir(id);
    }

    @RequestMapping("/YemekEkle")
    public String yemekEkle(@RequestParam String name, @RequestParam Double fiyat, @RequestParam int  indirim,
                          @RequestParam String  pisirmeSuresi){

         orderServis.YemekEkle( new Yemek(pisirmeSuresi,name,fiyat,indirim)  );
        return name + "eklendi";
    }

    @RequestMapping("/TatliEkle")
    public String  TatlıEkle(@RequestParam String name,@RequestParam Double fiyat,@RequestParam int  indirim,
                           @RequestParam String  pisirmeSekli){

        orderServis.tatlıEkle( new Tatlı(name,fiyat,indirim,pisirmeSekli)  );
        return name + "eklendi";
    }

    @RequestMapping("/IcecekEkle")
    public String  IcecekEkle(@RequestParam String name,@RequestParam Double fiyat,@RequestParam int  indirim,
                            @RequestParam boolean  asitliMi,@RequestParam boolean  sicakMi){

        orderServis.icecekEkle( new Icecek(name,fiyat,indirim,asitliMi,sicakMi)  );
        return name + "eklendi";
    }






    @RequestMapping("/siparisAl")
    public String  siparisAl(@RequestParam String masaNo, @RequestParam String name){
        return orderServis.masayaUrunSiparisiAl(getUrunByUrunNo(name),Integer.valueOf(masaNo));
    }

    @RequestMapping("/hesapAl")
    public String  hesapAl(@RequestParam String masaNo){
        return orderServis.hesapAl(Integer.valueOf(masaNo));
    }

    private Urun getUrunByUrunNo(String name) {
        for (Urun urun : orderServis.getUrunler()) {
            if(urun.getName().equals(name)){
                return urun ;
            }
        }
        return null;
    }



    @RequestMapping("/showmasa")
    public List<Masa> show(){
        return orderServis.showMasa();
    }

    @RequestMapping("/masaninUrunleri")
    public List<Urun> masaninUrunleri(int masaNo){
        return orderServis.showUrun(masaNo);
    }






    @RequestMapping ("/clear")
    public String clear(){

        return orderServis.clearList();

    }


    @RequestMapping(value = "/login")
    public Boolean adminKontrol(@RequestParam String name, @RequestParam String pass){

        return orderServis.adminKontrol(new User(name,pass));



    /*@RequestMapping ("/login")
    public Boolean adminKontrol(@RequestBody User user){

        return orderServis.adminKontrol(user);

    }*/

}

}

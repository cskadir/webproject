package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by cScientist on 9.07.2019.
 */
@Controller
public class PageController {

    @GetMapping("/menu")
    public String login() {
        return "menu";
    }

    @GetMapping("/siparisAlmaEkrani")
    public String siparisAl() {
        return "siparisAlmaEkrani";
    }

    @GetMapping("/urunDuzenlemeEkrani")
    public String urunDuzenleme() {
        return "urunDuzenlemeEkrani";
    }

    @GetMapping("/yeniUrun")
    public String UrunEKle() {
        return "YeniUrun";
    }

    @GetMapping("/urunDuzenlemeEkrani/edit")
    public String urunEdit() {
        return "urunEdit";
    }
/*
    @GetMapping("/showmasa")
    public String getMasa(){

        return "showBooks";
    }

    @GetMapping("/showurun")
    public String getUrun(){

        return "showBooks";
    }



    @GetMapping("/deneme")
    public String getHomePage() {
        return "deneme";
    }*/
}

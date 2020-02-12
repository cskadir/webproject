package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cScientist on 9.07.2019.
 */
public class DataBaseController {

    static String pathYEmek="yemek.txt";
    static String pathTatlı="tatlı.txt";
    static String pathIcecek="icecek.txt";

    public static List<Masa> texttenMasalarıOku(){

        List<Masa> masa=new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new ClassPathResource("masalar.txt").getFile()));
            String line = reader.readLine();
            do  {
                System.out.println(line);

                String []st=line.split(" ");
                masa.add(new Masa(Integer.valueOf(st[0]),st[1]));
                line = reader.readLine();
            }while(line != null);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masa ;
    }
    public static List<Masa> VerileriDosyayaAt(){

        return  null;
    }
    public static List<Urun>texttenUrunleriOku(){

        List<Urun>urunler=new ArrayList<>();
        BufferedReader reader;
        String [] st;
        try {
            reader = new BufferedReader(new FileReader(new ClassPathResource(pathYEmek).getFile()));
            String line=null;
            line = reader.readLine();
            do  {
                System.out.println(line);

                st=line.split(" ");
                urunler.add(new Yemek(st[0], st[1],Double.valueOf(st[2]),Integer.valueOf(st[3])));
                line = reader.readLine();
            }while(line != null);
            reader.close();

            reader = new BufferedReader(new FileReader(new ClassPathResource(pathTatlı).getFile()));
            line=null;
            line = reader.readLine();
            do  {
                System.out.println(line);

                st=line.split(" ");
                urunler.add(new Tatlı(st[0], Double.valueOf(st[1]),Integer.valueOf(st[2]),st[3]));
                line = reader.readLine();
            }while(line != null);
            reader.close();


            reader = new BufferedReader(new FileReader(new ClassPathResource(pathIcecek).getFile()));
            line=null;
            line = reader.readLine();
            do  {
                System.out.println(line);

                st=line.split(" ");
                urunler.add(new Icecek(st[0], Double.valueOf(st[1]),Integer.valueOf(st[2]),Boolean.valueOf(st[3]),Boolean.valueOf(st[4])));
                line = reader.readLine();
            }while(line != null);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return urunler ;


    }





}

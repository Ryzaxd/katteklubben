package com.example.demo;

public class Kat {

    private int id;
    private String kat_navn;
    private String kat_race;
    private String kat_køn;
    private String billedePath;


    public Kat(int id, String kat_navn, String kat_race, String kat_køn, String billedePath) {
        this.id = id;
        this.kat_navn = kat_navn;
        this.kat_race = kat_race;
        this.kat_køn = kat_køn;
        this.billedePath = billedePath;
    }

    public Kat() {

    }

    public String getKat_navn() {
        return kat_navn;
    }

    public void setKat_navn(String kat_navn) {
        this.kat_navn = kat_navn;
    }

    public String getKat_race() {
        return kat_race;
    }

    public void setKat_race(String kat_race) {
        this.kat_race = kat_race;
    }

    public String getKat_køn() {
        return kat_køn;
    }

    public void setKat_køn(String kat_køn) {
        this.kat_køn = kat_køn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBilledePath() {
        return billedePath;
    }

    public void setBilledePath(String billedePath) {
        this.billedePath = billedePath;
    }



}

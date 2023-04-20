package com.example.demo;

public class Medlem {

    private int medlem_id;
    private String navn;
    private String efternavn;
    private String medlem_email;

    public Medlem(int medlem_id, String navn, String efternavn, String medlem_email) {
        this.medlem_id = medlem_id;
        this.navn = navn;
        this.efternavn = efternavn;
        this.medlem_email = medlem_email;
    }

    public Medlem() {

    }

    public int getMedlem_id() {
        return medlem_id;
    }

    public void setMedlem_id(int medlem_id) {
        this.medlem_id = medlem_id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getMedlem_email() {
        return medlem_email;
    }

    public void setMedlem_email(String medlem_email) {
        this.medlem_email = medlem_email;
    }

}

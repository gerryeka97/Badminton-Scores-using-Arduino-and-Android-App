package com.example.gerryeka.aplikasiscoreboard1.Model;

/**
 * Created by gerry eka on 12/10/2019.
 */

public class Model_tourlist {
    String idtour,nametour;

    public Model_tourlist() {
    }

    public Model_tourlist(String idtour, String nametour) {
        this.idtour = idtour;
        this.nametour = nametour;
    }

    public String getIdtour() {
        return idtour;
    }

    public void setIdtour(String idtour) {
        this.idtour = idtour;
    }

    public String getNametour() {
        return nametour;
    }

    public void setNametour(String nametour) {
        this.nametour = nametour;
    }
}

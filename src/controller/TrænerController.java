package controller;

import model.Ansat;
import model.Træner;

import java.util.ArrayList;

public class TrænerController {

    private ArrayList<Ansat> ansatListe;
    private Træner enTræner;


    TrænerController(ArrayList<Ansat> ansatListe, Træner enTræner){
        this.ansatListe = ansatListe;
        this.enTræner = enTræner;

    }


    public void start(){
        System.out.println("Træneren: " + enTræner.getBrugerLogin() + " er logget ind.");
    }
}

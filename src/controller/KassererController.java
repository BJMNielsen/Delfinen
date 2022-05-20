package controller;

import model.Ansat;
import model.Kasserer;

import java.util.ArrayList;

public class KassererController {

    private ArrayList<Ansat> ansatListe;
    public Kasserer kassereren;

    KassererController(ArrayList<Ansat> ansatListe, Kasserer kassereren){
        this.ansatListe = ansatListe;
        this.kassereren = kassereren;
    }


    public void start(){
        System.out.println("Kasseren: " + kassereren.getBrugerLogin() + " er logget ind.");
    }

}

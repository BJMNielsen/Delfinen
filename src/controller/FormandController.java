package controller;

import model.Ansat;
import model.Formand;

import java.util.ArrayList;

public class FormandController {

    private ArrayList<Ansat> ansatListe;
    private Formand formanden;


    FormandController(ArrayList<Ansat> ansatListe, Formand formand) {
        this.ansatListe = ansatListe;
        this.formanden = formand;

    }


    public void start(){
        System.out.println("Formand: " + formanden.getBrugerLogin() + " er logget ind.");
    }
}

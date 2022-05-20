package controller;

import model.Ansat;
import model.KonkurrenceSvømmer;
import model.Medlem;
import model.Træner;
import view.UI;

import java.util.ArrayList;

public class TrænerController {

    private ArrayList<Ansat> ansatListe;
    private Træner enTræner;
    private UI ui;


    TrænerController(ArrayList<Ansat> ansatListe, Træner enTræner, UI ui){
        this.ansatListe = ansatListe;
        this.enTræner = enTræner;
        this.ui = ui;
    }


    public void start(){
        boolean isRunning = true;
        ui.ansatMenuWelcomeMessage(enTræner.getBrugerLogin());
        while (isRunning) {
//            Menu Træner
//
//            1) Vis medlemsliste
//            2) Vis konkurrence svømmer
//            3) Vis top 5 i en disciplin
//            0) Log ud
            ui.trænerMenu();
            isRunning = userChoice();
        }
    }

    public boolean userChoice() {
        ui.typeHere();
        int choice = ui.getIntInput();

        switch (choice) {
            case 1:
                visMedlemslisten();
                return true;

            case 2:
                visKonkurrenceSvømmere();
                return true;

            case 3:
                // visTop5();
                return true;

            case 0:

                return false;

            default:
                ui.inputIsInvalid(choice);
                return true;
        }

    }

    public void visMedlemslisten() {
        ArrayList<Medlem> medlemsliste = enTræner.getMedlemsListen();
        ui.printMedlemsliste(medlemsliste);
    }
    public void visKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = enTræner.skafKonkurrenceSvømmerer();
        ui.printKonkurrenceSvømmer(konkurrenceSvømmerListe);
    }
    public void visTop5(){
       // ArrayList<KonkurrenceSvømmer> top5 = enTræner.top5KonkurrenceSvømmerer();
       // ui.printTop5(top5);
    }


}

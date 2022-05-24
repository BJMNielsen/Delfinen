package controller;

import model.Ansat;
import model.Kasserer;
import model.Medlem;
import view.UI;

import java.util.ArrayList;

public class KassererController {

    private ArrayList<Ansat> ansatListe;
    private Kasserer kassereren;
    private UI ui;

    KassererController(ArrayList<Ansat> ansatListe, Kasserer kassereren, UI ui){
        this.ansatListe = ansatListe;
        this.kassereren = kassereren;
        this.ui = ui;
    }


    public void start(){
        boolean isRunning = true;
        ui.ansatMenuWelcomeMessage(kassereren.getBrugerLogin());
        while (isRunning) {
            ui.kassererMenu();
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
                seRestanceMedlemmer();
                return true;
            case 3:
                visKontingentForAlleMedlemmer();
                return true;
            case 0:
                return false;

            default:
                ui.inputIsInvalid(choice);
                return true;
        }

    }

    public void visMedlemslisten() {
        ArrayList<Medlem> medlemsliste = kassereren.getMedlemsListen();
        ui.printMedlemsliste(medlemsliste);
    }

    public void seRestanceMedlemmer(){
        kassereren.seRestanceMedlemmer();
    }
    public void visKontingentForAlleMedlemmer(){
        double result = kassereren.beregnKontingentForAlleMedlemmer();
        System.out.println(result + ".kr");

    }

}

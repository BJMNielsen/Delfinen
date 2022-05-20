package controller;

import model.Ansat;
import model.Formand;
import model.Medlem;
import view.UI;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FormandController {

    private ArrayList<Ansat> ansatListe;
    private Formand formanden;
    private UI ui;


    FormandController(ArrayList<Ansat> ansatListe, Formand formand, UI ui) {
        this.ansatListe = ansatListe;
        this.formanden = formand;
        this.ui = ui;
    }


    public void start() {
        boolean isRunning = true;
        ui.ansatMenuWelcomeMessage(formanden.getBrugerLogin());
        while (isRunning) {
//
//                Menu Formand
//
//                1) Vis medlemsliste
//                2) Opret medlem
//                3) Fjern medlem
//                4) Opgrader medlem til konkurrencesvømmer TODO lav metode metode
//                0) Log ud
//
//
            ui.formandMenu();
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
                opretMedlem();
                return true;

            case 3:
                fjernMedlem();
                return true;

            case 4:
                opgraderMedlem();
                return true;

            case 0:

                return false;

            default:
                ui.inputIsInvalid(choice);
                return true;
        }

    }

    public void visMedlemslisten() {
        ArrayList<Medlem> medlemsliste = formanden.getMedlemsListen();
        ui.printMedlemsliste(medlemsliste);
    }

    public void opretMedlem() {

    }

    public void fjernMedlem() {

    }

    public void opgraderMedlem() {

    }
}

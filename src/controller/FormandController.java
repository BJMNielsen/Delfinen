package controller;

import model.Ansat;
import model.Formand;
import model.KonkurrenceSvømmer;
import model.Medlem;
import view.UI;

import java.util.ArrayList;

public class FormandController {

    private ArrayList<Ansat> ansatListe;
    private Formand formanden;
    private UI ui;
    private Medlem etMedlem;
    private KonkurrenceSvømmer enKonkurrenceSvømmer;
    ArrayList<Medlem> medlemsliste = formanden.getMedlemsListen();


    FormandController(ArrayList<Ansat> ansatListe, Formand formand, UI ui) {
        this.ansatListe = ansatListe;
        this.formanden = formand;
        this.ui = ui;
    }


    public void start() {
        boolean isRunning = true;
        ui.ansatMenuWelcomeMessage(formanden.getBrugerLogin());
        while (isRunning) {
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
                indmeldMedlem();
                return true;

            case 3:
                fjernMedlem();
                return true;

            case 4:
                opgraderTilKonkurrenceSvømmer();
                return true;

            case 0:

                return false;

            default:
                ui.inputIsInvalid(choice);
                return true;
        }

    }

    public void visMedlemslisten() {
        ui.printMedlemsliste(medlemsliste);
    }

    public void indmeldMedlem() {
        formanden.indmeldMedlem(etMedlem.getNavn(),etMedlem.getFødselsdato(),etMedlem.getErAktiv(),etMedlem.isErKonkurrencesvømmer(), (int) etMedlem.getKontingentBalance());
        ui.printMedlemsliste(medlemsliste);
    }

    public void fjernMedlem() {
        formanden.fjernMedlem(etMedlem.getMedlemsnummer());
        ui.printMedlemsliste(medlemsliste);

    }

    public void opgraderTilKonkurrenceSvømmer() {
        formanden.opgraderTilKonkurrencesvømmer(enKonkurrenceSvømmer.getMedlemsnummer(),enKonkurrenceSvømmer.getTrænerID(),enKonkurrenceSvømmer.getSvømmedisciplin());
        ui.printMedlemsliste(medlemsliste);
    }
}

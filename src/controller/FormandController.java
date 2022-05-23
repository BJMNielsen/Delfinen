package controller;

import model.Ansat;
import model.Formand;
import model.KonkurrenceSvømmer;
import model.Medlem;
import view.UI;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class FormandController {

    private ArrayList<Ansat> ansatListe;
    private Formand formanden;
    private UI ui;
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
        ui.askForMedlemInfo("navn");
        String navn = ui.getStringInput();
        ui.askForMedlemInfo("Fødselsdato");
        LocalDate fødselsdato = createDateFromIntInput();
        ui.askForMedlemInfo("aktivitetsstatus");
        boolean status = ui.askUserYesOrNo();
        ui.askForMedlemInfo("konkurrencestatus");
        boolean statusKonkurrence = ui.askUserYesOrNo();
        ui.askForMedlemInfo("kontingentbalance");
        int kontingent = ui.getIntInput();

        Medlem etMedlem = formanden.indmeldMedlem(navn,fødselsdato,status,statusKonkurrence,kontingent);
        if(etMedlem != null){
            indmeldKonkurrenceSvømmer(etMedlem);
        }
        ui.printMedlemsliste(medlemsliste);
    }

    public void indmeldKonkurrenceSvømmer(Medlem etMedlem){


    }

    private LocalDate createDateFromIntInput() {
        int år = inputFødselsÅr();

        int måned = inputFødselsMåned(år);

        int dag = inputFødselsDag(år, måned);

        return LocalDate.of(år,måned,dag);
    }

    private int inputFødselsÅr() {
        boolean isRunning = true;
        int fødeÅr = -1;
        int nuværrendeÅr = LocalDate.now().getYear();
        while (isRunning) {
            ui.askForMedlemInfo("fødselsår");
            ui.typeHere();
            fødeÅr = ui.getIntInput();
            if (fødeÅr <= nuværrendeÅr && fødeÅr > 1900) {
                isRunning = false;
            }
        }
        return fødeÅr;
    }

    private int inputFødselsMåned(int fødeÅr) {
        boolean isRunning = true;
        int fødeMåned = -1;
        int nuværrendeÅr = LocalDate.now().getYear();
        int nuværrendeMåned = LocalDate.now().getMonthValue();
        while (isRunning) {
            ui.askForMedlemInfo("fødselsmåned");
            ui.typeHere();
            fødeMåned = ui.getIntInput();
            if (fødeÅr == nuværrendeÅr) {
                if (fødeMåned >= 1 && fødeMåned <= nuværrendeMåned) {
                    isRunning = false;
                }
            } else if (fødeMåned >= 1 && fødeMåned <= 12) {
                isRunning = false;
            }
        }
        return fødeMåned;
    }

    private int inputFødselsDag(int fødeÅr, int fødeMåned) {
        boolean isRunning = true;
        int fødeDag = 1;
        int dageIFødselsMåned = LocalDate.of(fødeÅr, fødeMåned, fødeDag).lengthOfMonth();
        int nuværrendeÅr = LocalDate.now().getYear();
        int nuværrendeMåned = LocalDate.now().getMonthValue();
        int nuværrendeDagImåneden = LocalDate.now().getDayOfMonth();
        while (isRunning) {
            ui.askForMedlemInfo("dag i måneden de blev født");
            ui.typeHere();
            fødeDag = ui.getIntInput();
            if (fødeÅr == nuværrendeÅr && fødeMåned == nuværrendeMåned) {
                if (fødeDag >= 1 && fødeDag <= nuværrendeDagImåneden) {
                    isRunning = false;
                }
            } else if (fødeDag >= 1 && fødeDag <= dageIFødselsMåned) {
                isRunning = false;
            }
        }
        return fødeDag;
    }






    public void fjernMedlem() {
        //formanden.fjernMedlem(medlemsliste);
        ui.printMedlemsliste(medlemsliste);

    }

    public void opgraderTilKonkurrenceSvømmer() {
        //formanden.opgraderTilKonkurrencesvømmer();
        ui.printMedlemsliste(medlemsliste);
    }
}

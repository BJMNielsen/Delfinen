package controller;

import enums.Disciplin;
import model.*;
import view.UI;

import java.time.LocalDate;
import java.util.ArrayList;

public class FormandController {

    private ArrayList<Ansat> ansatListe;
    private Formand formanden;
    private UI ui;
    ArrayList<Medlem> medlemsliste;


    FormandController(ArrayList<Ansat> ansatListe, Formand formand, UI ui) {
        this.ansatListe = ansatListe;
        this.formanden = formand;
        this.ui = ui;
        medlemsliste = formanden.getMedlemsListen();
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
        LocalDate fødselsdato = createDateFromIntInput("fødselsår", "fødselsmåned", "dag de blev født i måneden");
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
    }

    public void indmeldKonkurrenceSvømmer(Medlem etMedlem){
        int trænerNummer = indtastTrænerNummer();
        Svømmedisciplin butterfly = indtastSvømmedisciplin(Disciplin.BUTTERFLY);
        Svømmedisciplin crawl = indtastSvømmedisciplin(Disciplin.CRAWL);
        Svømmedisciplin rygcrawl = indtastSvømmedisciplin(Disciplin.RYGCRAWL);
        Svømmedisciplin brystsvømning = indtastSvømmedisciplin(Disciplin.BRYSTSVØMNING);
        formanden.indmeldKonkurrencesvømmer(etMedlem, trænerNummer, butterfly, crawl, rygcrawl, brystsvømning);
    }

    public int indtastTrænerNummer() {
        ui.askForMedlemInfo("tilknyttede træners ID");
        int trænerNummer = 0;
        boolean isRunning = true;
        while (isRunning) {
            ui.typeHere();
            int ønsketTrænerNummer = ui.getIntInput();
            for (Ansat enAnsat : ansatListe) {
                if (enAnsat instanceof Træner) {
                    int aktueltTrænerNummer = ((Træner) enAnsat).getTrænerID();
                    if (ønsketTrænerNummer == aktueltTrænerNummer) {
                        trænerNummer = ønsketTrænerNummer;
                        isRunning = false;
                    }
                }
            }
            if (isRunning) {
                ui.detVarForketInput("trænere med nummeret " + ønsketTrænerNummer);
            }
        }
        return trænerNummer;
    }

    public Svømmedisciplin indtastSvømmedisciplin(Disciplin disciplin) {
        ui.askForMedlemInfo("aktivitetsstatus i " + disciplin);
        boolean disciplinStatus = ui.askUserYesOrNo();
        System.out.println("Har medlemmet en bedste tid?");
        boolean harEnBedsteTid = ui.askUserYesOrNo();
        if (harEnBedsteTid) {
            ui.askForMedlemInfo("bedste tid i sekunder");
            double bedsteTidInput = ui.getDoubleInput();
            while (bedsteTidInput <= 0) {
                ui.askForMedlemInfo("bedste tid i sekunder");
                bedsteTidInput = ui.getDoubleInput();
            }
            ui.askForMedlemInfo("dato for deres bedste tid");
            LocalDate datoForBedsteTid = createDateFromIntInput("år for den bedste tid", "måned for den bedste tid", "dag for den bedste tid");
            return new Svømmedisciplin(disciplinStatus, disciplin, bedsteTidInput, datoForBedsteTid);
        }
        return new Svømmedisciplin(disciplinStatus, disciplin);
    }

    private LocalDate createDateFromIntInput(String typeÅr, String typeMåned, String typeDag) {
        int år = inputÅr(typeÅr);

        int måned = inputFødselsMåned(typeMåned, år);

        int dag = inputFødselsDag(typeDag, år, måned);

        return LocalDate.of(år,måned,dag);
    }

    private int inputÅr(String typeÅr) {
        boolean isRunning = true;
        int fødeÅr = -1;
        int nuværrendeÅr = LocalDate.now().getYear();
        while (isRunning) {
            ui.askForMedlemInfo(typeÅr);
            ui.typeHere();
            fødeÅr = ui.getIntInput();
            if (fødeÅr <= nuværrendeÅr && fødeÅr > 1900) {
                isRunning = false;
            }
        }
        return fødeÅr;
    }

    private int inputFødselsMåned(String typeMåned, int fødeÅr) {
        boolean isRunning = true;
        int fødeMåned = -1;
        int nuværrendeÅr = LocalDate.now().getYear();
        int nuværrendeMåned = LocalDate.now().getMonthValue();
        while (isRunning) {
            ui.askForMedlemInfo(typeMåned);
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

    private int inputFødselsDag(String typeDag, int fødeÅr, int fødeMåned) {
        boolean isRunning = true;
        int fødeDag = 1;
        int dageIFødselsMåned = LocalDate.of(fødeÅr, fødeMåned, fødeDag).lengthOfMonth();
        int nuværrendeÅr = LocalDate.now().getYear();
        int nuværrendeMåned = LocalDate.now().getMonthValue();
        int nuværrendeDagImåneden = LocalDate.now().getDayOfMonth();
        while (isRunning) {
            ui.askForMedlemInfo(typeDag);
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
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Indtast medlemsnummer på det medlem der skal fjernes:");
            int input = ui.getIntInput();
            boolean medlemBlevFjernet = formanden.fjernMedlem(input);

            if(medlemBlevFjernet){
                System.out.println("Medlemmet blev fjernet.");
                isRunning = false;
            }else{
                System.out.println("Medlemmet findes ikke.");
            }
        }
    }

    public void opgraderTilKonkurrenceSvømmer() {
        boolean isRunning = true;
        int medlemsnummer = 0;
        Medlem etMedlem = null;
        while(isRunning){
            System.out.println("Hvad er medlemmets nummer?");
            medlemsnummer = ui.getIntInput();
            etMedlem = formanden.getEtMedlem(medlemsnummer);
            if(etMedlem != null){
                isRunning = false;
            } else {
                System.out.println("Medlem nr. " + medlemsnummer + " findes ikke.");
            }
        }
        int træner = indtastTrænerNummer();
        Svømmedisciplin butterfly = indtastSvømmedisciplin(Disciplin.BUTTERFLY);
        Svømmedisciplin crawl = indtastSvømmedisciplin(Disciplin.CRAWL);
        Svømmedisciplin rygcrawl = indtastSvømmedisciplin(Disciplin.RYGCRAWL);
        Svømmedisciplin brystsvømning = indtastSvømmedisciplin(Disciplin.BRYSTSVØMNING);
        boolean erOpgraderet = formanden.opgraderTilKonkurrencesvømmer(medlemsnummer,træner,butterfly,crawl,rygcrawl,brystsvømning);
        if(erOpgraderet){
            System.out.println("Medlem opgraderet.");
        }
    }
}

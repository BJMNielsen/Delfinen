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
        LocalDate fødselsdato = createDateFromIntInput("fødselsår", "fødselsmåned", "dag de blev født i måneden");
        ui.askForMedlemInfo("aktivitetsstatus");
        boolean status = ui.askUserActiveOrInactive();
        ui.askForMedlemInfo("kontingentbalance");
        int kontingent = ui.getIntInput();
        ui.askForMedlemInfo("konkurrencestatus");
        boolean statusKonkurrence = ui.askUserActiveOrInactive();

        Medlem etMedlem = formanden.indmeldMedlem(navn,fødselsdato,status,statusKonkurrence,kontingent);
        if(etMedlem != null){
            indmeldKonkurrenceSvømmer(etMedlem);
        }
        ui.detVarEnSuccess("oprette et medlem");
    }

    public void indmeldKonkurrenceSvømmer(Medlem etMedlem){
        int trænerNummer = indtastTrænerNummer();
        Svømmedisciplin butterfly = indtastSvømmedisciplin(Disciplin.BUTTERFLY);
        Svømmedisciplin crawl = indtastSvømmedisciplin(Disciplin.CRAWL);
        Svømmedisciplin rygcrawl = indtastSvømmedisciplin(Disciplin.RYGCRAWL);
        Svømmedisciplin brystsvømning = indtastSvømmedisciplin(Disciplin.BRYSTSVØMNING);
        Konkurrence enKonkurrence = indtastKonkurrence();
        if (enKonkurrence == null) {
            formanden.indmeldKonkurrencesvømmer(etMedlem, trænerNummer, butterfly, crawl, rygcrawl, brystsvømning);
        } else {
            formanden.indmeldKonkurrencesvømmer(etMedlem, trænerNummer, butterfly, crawl, rygcrawl, brystsvømning, enKonkurrence);
        }

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
        boolean disciplinStatus = ui.askUserActiveOrInactive();
        System.out.println("Har medlemmet en bedste tid?");
        boolean harEnBedsteTid = ui.askUserYesOrNo();
        if (harEnBedsteTid) {
            ui.askForMedlemInfo("bedste tid i sekunder");
            ui.typeHere();
            double bedsteTidInput = ui.getDoubleInput();
            while (bedsteTidInput <= 0) {
                ui.askForMedlemInfo("bedste tid i sekunder");
                ui.typeHere();
                bedsteTidInput = ui.getDoubleInput();
            }
            LocalDate datoForBedsteTid = createDateFromIntInput("år for deres bedste tid", "måned for deres bedste tid", "dag for deres bedste tid");
            return new Svømmedisciplin(disciplinStatus, disciplin, bedsteTidInput, datoForBedsteTid);
        }
        return new Svømmedisciplin(disciplinStatus, disciplin);
    }

    public Konkurrence indtastKonkurrence() {
        ui.erSvømmerTilkyttetEnKonkurrence();
        boolean harKonkurrence = ui.askUserYesOrNo();
        if (harKonkurrence) {
            ui.indtastStævneNavn();
            ui.typeHere();
            String stævneNavn = ui.getStringInput();
            ui.indtastPlacering();
            ui.typeHere();
            int placering = ui.getIntInput();
            while (placering <= 0) {
                ui.inputIsInvalid(placering);
                ui.typeHere();
                placering = ui.getIntInput();
            }
            ui.indtastTidenForStævnet();
            ui.typeHere();
            double tid = ui.getDoubleInput();
            while (tid <= 0) {
                ui.inputIsInvalid(tid);
                ui.typeHere();
                tid = ui.getDoubleInput();
            }
            return new Konkurrence(stævneNavn, placering, tid);
        }
        return null;
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
            System.out.println("Medlem opgraderet.\n");
        }
    }
}

package controller;

import model.Ansat;
import model.KonkurrenceSvømmer;
import model.Træner;
import view.UI;

import java.util.ArrayList;

public class TrænerController {

    private ArrayList<Ansat> ansatListe;
    private ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere;
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
                visTop5();
                return true;
            case 0:
                ui.exitProgramMessage();
                return false;
            default:
                ui.inputIsInvalid(choice);
                return true;
        }
    }



    public void visTop5() {
        ArrayList<KonkurrenceSvømmer> juniorHoldet = enTræner.skafJuniorHold();
        ArrayList<KonkurrenceSvømmer> seniorHoldet = enTræner.skafSeniorHold();
        String disciplin = "";
        boolean isRunning = true;
        while (isRunning) {
            ui.vælgDisciplinMenu();

            int userInput = ui.getIntInput();
            switch (userInput) {
                case 1:
                    juniorHoldet = enTræner.butterflyOpdeling(juniorHoldet);
                    seniorHoldet = enTræner.butterflyOpdeling(seniorHoldet);
                    disciplin = "butterfly";
                    isRunning = false;
                    break;
                case 2:
                    juniorHoldet = enTræner.crawlOpdeling(juniorHoldet);
                    seniorHoldet = enTræner.crawlOpdeling(seniorHoldet);
                    disciplin = "crawl";
                    isRunning = false;
                    break;
                case 3:
                    juniorHoldet = enTræner.rygCrawlOpdeling(juniorHoldet);
                    seniorHoldet = enTræner.rygCrawlOpdeling(seniorHoldet);
                    disciplin = "rygcrawl";
                    isRunning = false;
                    break;
                case 4:
                    juniorHoldet = enTræner.brystSvømningOpdeling(juniorHoldet);
                    seniorHoldet = enTræner.brystSvømningOpdeling(seniorHoldet);
                    disciplin = "brystsvømning";
                    isRunning = false;
                    break;
                default:
                    ui.inputIsInvalid(userInput);
            }
        }
        ui.printTop5Listen(juniorHoldet, "juniorholdet", disciplin);
        ui.printTop5Listen(seniorHoldet, "seniorholdet", disciplin);
    }




    public void visMedlemslisten() {
        ArrayList<KonkurrenceSvømmer> medlemsliste = enTræner.skafKonkurrenceSvømmerer();
        ui.printKonkurrenceSvømmerListe(medlemsliste);
    }
    public void visKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = enTræner.skafKonkurrenceSvømmerer();
        ui.printKonkurrenceSvømmer(konkurrenceSvømmerListe);
    }

}

package controller;

import model.Ansat;
import model.KonkurrenceSvømmer;
import model.Medlem;
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
                visJuniorHold();
                return true;
            case 4:
                visSeniorHold();
                return true;
            case 5:
                visCrawlOpdeling();
                return true;
            case 6:
                visRygCrawlOpdeling();
                return true;
            case 7:
                visBrystSvømningOpdeling();
                return true;
            case 8:
                visButterflyOpdeling();
                return true;
            case 9:
                visTop5KonkurrenceSvømmerer();
                return true;
            case 0:
                ui.exitProgramMessage();
                return false;
            default:
                ui.inputIsInvalid(choice);
                return true;
        }
    }


    public void visMedlemslisten() {
        ArrayList<KonkurrenceSvømmer> medlemsliste = enTræner.skafKonkurrenceSvømmerer();
        ui.printKonkurrenceSvømmerListe(medlemsliste);
    }
    public void visKonkurrenceSvømmere() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe = enTræner.skafKonkurrenceSvømmerer();
        ui.printKonkurrenceSvømmer(konkurrenceSvømmerListe);
    }
    public void visJuniorHold(){
       ArrayList<KonkurrenceSvømmer> juniourHold = enTræner.skafJuniorHold();
       ui.printJuniorHold(juniourHold);
    }
    public void visSeniorHold(){
        ArrayList<KonkurrenceSvømmer> seniorHold = enTræner.skafSeniorHold();
        ui.printSeniorHold(seniorHold);
    }
    public void visCrawlOpdeling(){
        ArrayList<KonkurrenceSvømmer> crawlOpdeling = enTræner.crawlOpdeling(konkurrenceSvømmere);
        ui.printCrawlOpdeling(crawlOpdeling);
    }
    public void visRygCrawlOpdeling(){
        ArrayList<KonkurrenceSvømmer> rygCrawlOpdeling = enTræner.rygCrawlOpdeling(konkurrenceSvømmere);
        ui.printRygCrawlOpdeling(rygCrawlOpdeling);
    }
    public void visBrystSvømningOpdeling(){
        ArrayList<KonkurrenceSvømmer> brystSvømningOpdeling = enTræner.brystSvømningOpdeling(konkurrenceSvømmere);
        ui.printBrystSwømningOpdeling(brystSvømningOpdeling);
    }
    public void visButterflyOpdeling(){
        ArrayList<KonkurrenceSvømmer> butterFlyOpdeling = enTræner.butterflyOpdeling(konkurrenceSvømmere);
        ui.printBytterflyOpdeling(butterFlyOpdeling);
    }
    public void visTop5KonkurrenceSvømmerer(){
        ArrayList<KonkurrenceSvømmer> top5 = enTræner.top5KonkurrenceSvømmerer(konkurrenceSvømmere);
        ui.printTop5(top5);
    }
}

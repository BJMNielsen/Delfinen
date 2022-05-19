package controller;

import model.Ansat;
import model.Filhåndtering;
import view.UI;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SystemController {
    private UI ui;
    private Filhåndtering filhåndtering;
    private ArrayList<Ansat> ansatListe;

    public SystemController() throws FileNotFoundException {
        ui = new UI();
        filhåndtering = new Filhåndtering();
        ansatListe = filhåndtering.loadAnsatLoginListe();



    }


    public void start() {
        // load filer
        // ui.welcomeMessage
        // indtast logininfo
    }


    public void indtastLoginInfo() {
        //ui.indtastNoget("brugernavn");
       // String brugerNavn = ui.userIput();
    }
}

package controller;

import model.*;
import view.UI;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SystemController {
  private UI ui;
  private Filhåndtering filhåndtering;
  private ArrayList<Ansat> ansatListe;
  private ArrayList<Medlem> medlemListe;

  public SystemController() throws FileNotFoundException {
    ui = new UI();
    filhåndtering = new Filhåndtering();
    ansatListe = filhåndtering.loadAnsatLoginListe();
    medlemListe = filhåndtering.loadMedlemsliste();
    giveAllSameList(medlemListe, ansatListe);
  }

  public void giveAllSameList(ArrayList<Medlem> medlemListe, ArrayList<Ansat> ansatListe) {
    for (Ansat enAnsat : ansatListe) {
      enAnsat.setMedlemsListe(medlemListe);
    }
  }


  public void start() throws FileNotFoundException {
    boolean isRunning = true;
    while (isRunning) {
      ui.welcomeMessage();
      isRunning = userChoice();

    }

  }

  public boolean userChoice() throws FileNotFoundException {
    ui.typeHere();
    int choice = ui.getIntInput();

    switch (choice) {
      case 1:
        indtastLoginInfo();
        return true;

      case 0:
        ui.exitProgramMessage();
        closeProgramAndSaveFile();
        return false;

      default:
        ui.inputIsInvalid(choice);
        return true;
    }

  }


  public void closeProgramAndSaveFile() throws FileNotFoundException {
    filhåndtering.saveAnsatLoginListe(ansatListe);
    filhåndtering.saveMedlemsliste(medlemListe);
    ui.filesWereSavedSuccesfully();
  }


  public void indtastLoginInfo() {
    boolean forkertLogin = true;
    while (forkertLogin) {
      ui.indtastBrugernavn();
      String brugerNavnInput = ui.getStringInput();
      Ansat enAnsat = søgAnsatViaBrugerNavn(brugerNavnInput);
      if (enAnsat != null) {
        ui.indtastPassword();
        String passwordInput = ui.getStringInput();
        if(erPasswordKorrekt(enAnsat, passwordInput)){
          forkertLogin = false;
          loginSom(enAnsat);
        }

      }

    }

  }

  public Ansat søgAnsatViaBrugerNavn(String brugerInputNavn) {
    for (Ansat enAnsat : ansatListe) {
      if (enAnsat.getBrugerLogin().equals(brugerInputNavn)) {
        ui.korrektBrugerNavn();
        return enAnsat;
      }
    }
    ui.forkertBrugerNavn();
    return null;
  }


  public boolean erPasswordKorrekt(Ansat enAnsat, String inputPassword) {
    String KorrektPassword = enAnsat.getPassword();
    if (inputPassword.equals(KorrektPassword)) {
      ui.korrektPassword();
      return true;
    }
    ui.forkertPassword();
    return false;
  }

  public void loginSom(Ansat enAnsat) {
    if(enAnsat instanceof Formand){
      Formand formand = (Formand)enAnsat;
      FormandController formanden = new FormandController(ansatListe, formand, ui);
      formanden.start();
    }

    if(enAnsat instanceof Kasserer){
      Kasserer kasserer = (Kasserer)enAnsat;
      KassererController kassereren = new KassererController(ansatListe, kasserer, ui);
      kassereren.start();
    }

    if(enAnsat instanceof Træner){
      Træner træner = (Træner)enAnsat;
      TrænerController enTræner = new TrænerController(ansatListe, træner, ui);
      enTræner.start();
    }
  }
}
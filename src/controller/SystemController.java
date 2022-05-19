package controller;

import model.Ansat;
import model.Filhåndtering;
import model.Medlem;
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
    giveAllSameList(medlemListe,ansatListe);
  }

  public void giveAllSameList(ArrayList<Medlem> medlemListe, ArrayList<Ansat> ansatListe) {
    for (Ansat enAnsat : ansatListe) {
      enAnsat.setMedlemsListe(medlemListe);
    }
  }


  public void start() throws FileNotFoundException {
    boolean isRunning = true;
    ui.welcomeMessage();
    while(isRunning){
      isRunning = userChoice();

    }

  }

  public boolean userChoice() throws FileNotFoundException {
    ui.typeHere();
    int choice = ui.getIntInput();

    switch(choice) {
      case 1:

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
    //ui.indtastNoget("brugernavn");
    // String brugerNavn = ui.userIput();
  }
}

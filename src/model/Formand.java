package model;

import view.UI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Formand extends Ansat{


  public Formand() {
    super("Formand", "Password");
  }

  public Formand(String brugerNavn, String password) {
    super(brugerNavn, password);
  }

  public Medlem indmeldMedlem(String ID, String navn, LocalDate fødselsdato, boolean erAktiv, boolean erKonkurrencesvømmer) {
    Medlem etMedlem = new Medlem(ID, navn, fødselsdato, erAktiv);

    if(erKonkurrencesvømmer){
      return etMedlem;

    } else {
      Ansat.addMedlem(etMedlem);
      return null;
    }
  }


  public boolean erUnikID(String ID) {
    ArrayList<Medlem> medlemsListe = Ansat.getMedlemsListen();
    for (Medlem etMedlem : medlemsListe) {
      String medlemID = etMedlem.getID();
      if (ID.equals(medlemID)) {
        return false;
      }
    }
    return true;
  }



  public void indmeldKonkurrencesvømmer(Medlem etMedlem, String trænerLogin) {
    KonkurrenceSvømmer enKonkurrencesvømmer = new KonkurrenceSvømmer(etMedlem, trænerLogin);
    Ansat.addKonkurrencesvømmer(enKonkurrencesvømmer);
  }

  public boolean upgradeMedlem(String ID, String trænerNavn) {
    ArrayList<Medlem> medlemsListe = Ansat.getMedlemsListen();
    for (Medlem etMedlem : medlemsListe) {
     String medlemID = etMedlem.getID();
     if (ID.equals(medlemID)) {
       Ansat.removeMember(etMedlem);
       KonkurrenceSvømmer enKonkurrenceSvømmer = new KonkurrenceSvømmer(etMedlem, trænerNavn);
       Ansat.addKonkurrencesvømmer(enKonkurrenceSvømmer);
       return true;
     }
    }
    return false;
  }

  public boolean fjernMedlem(String ID) {
    ArrayList<Medlem> medlemsListe = Ansat.getMedlemsListen();
    for (Medlem etMedlem:medlemsListe) {
      String medlemID = etMedlem.getID();
      if (ID.equals(medlemID)) { // hvis ID der kom ind er lig med et Medlem ID og det var muligt at fjerne medlem
        Ansat.removeMember(etMedlem);
        return true;
      }
    }
    return false; // Går igennem hele listen og ingen af dem var lig med ID der kom ind og det var ikke muligt at fjerne medlem
  }

  public void lavTræner(String navn){

  }


}


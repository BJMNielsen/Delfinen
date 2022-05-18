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

  public Medlem indmeldMedlem(String navn, LocalDate fødselsdato, boolean erAktiv, boolean erKonkurrencesvømmer, int kontingentBalance) {
    Medlem etMedlem = new Medlem(navn, fødselsdato, erAktiv, kontingentBalance);

    if(erKonkurrencesvømmer){
      return etMedlem;

    } else {
      addMedlem(etMedlem);
      return null;
    }
  }


  public boolean erUnikID(int medlemsnummer) {
    ArrayList<Medlem> medlemsListe = getMedlemsListen();
    for (Medlem etMedlem : medlemsListe) {
      int aktuelleMedlemsnummer = etMedlem.getMedlemsnummer();
      if (aktuelleMedlemsnummer == medlemsnummer) {
        return false;
      }
    }
    return true;
  }



  public void indmeldKonkurrencesvømmer(Medlem etMedlem, int trænerID, ArrayList<Svømmedisciplin> discipliner) {
    KonkurrenceSvømmer enKonkurrencesvømmer = new KonkurrenceSvømmer(etMedlem, trænerID, discipliner);
    addKonkurrencesvømmer(enKonkurrencesvømmer);
  }

  public boolean upgradeTilKonkurrencesvømmer(int medlemsnummer, int trænerID, ArrayList<Svømmedisciplin> discipliner) {
    ArrayList<Medlem> medlemsListe = getMedlemsListen();
    for (Medlem etMedlem : medlemsListe) {
     int aktuelleMedlemsnummer = etMedlem.getMedlemsnummer();
     if (medlemsnummer == aktuelleMedlemsnummer) {
       removeMember(etMedlem);
       KonkurrenceSvømmer enKonkurrenceSvømmer = new KonkurrenceSvømmer(etMedlem, trænerID, discipliner);
       addKonkurrencesvømmer(enKonkurrenceSvømmer);
       return true;
     }
    }
    return false;
  }

  public boolean fjernMedlem(int medlemsnummer) {
    ArrayList<Medlem> medlemsListe = getMedlemsListen();
    for (Medlem etMedlem:medlemsListe) {
      int aktuelleMedlemsnummer = etMedlem.getMedlemsnummer();
      if (medlemsnummer == aktuelleMedlemsnummer) { // hvis ID der kom ind er lig med et Medlem ID og det var muligt at fjerne medlem
        removeMember(etMedlem);
        return true;
      }
    }
    return false; // Går igennem hele listen og ingen af dem var lig med ID der kom ind og det var ikke muligt at fjerne medlem
  }

  public void lavTræner(String navn){

  }

}


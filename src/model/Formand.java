package model;


import java.time.LocalDate;
import java.util.ArrayList;

public class Formand extends Ansat{


  public Formand() {
    super.setBrugerLogin("Formand");
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





  public void indmeldKonkurrencesvømmer(Medlem etMedlem, int trænerID, Svømmedisciplin butterfly, Svømmedisciplin crawl, Svømmedisciplin rygcrawl, Svømmedisciplin brystsvømning) {
    KonkurrenceSvømmer enKonkurrencesvømmer = new KonkurrenceSvømmer(etMedlem, trænerID, butterfly, crawl, rygcrawl, brystsvømning);
    addKonkurrencesvømmer(enKonkurrencesvømmer);
  }

  public boolean opgraderTilKonkurrencesvømmer(int medlemsnummer, int trænerID, Svømmedisciplin butterfly, Svømmedisciplin crawl, Svømmedisciplin rygcrawl, Svømmedisciplin brystsvømning) {
    ArrayList<Medlem> medlemsListe = getMedlemsListen();
    for (Medlem etMedlem : medlemsListe) {
     int aktuelleMedlemsnummer = etMedlem.getMedlemsnummer();
     if (medlemsnummer == aktuelleMedlemsnummer) {
       removeMember(etMedlem);
       KonkurrenceSvømmer enKonkurrenceSvømmer = new KonkurrenceSvømmer(etMedlem, trænerID, butterfly, crawl, rygcrawl, brystsvømning);
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


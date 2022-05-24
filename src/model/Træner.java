package model;

import enums.Disciplin;

import java.util.ArrayList;
import java.util.Collections;

public class Træner extends Ansat{

  private static int staticTrænerID;
  private int trænerID;


  public Træner(String brugerNavn, String password) {
    super(brugerNavn, password);
    staticTrænerID++;
    trænerID = staticTrænerID;
  }
//Dette er til når vi loader en træner ud fra en fil og laver ham
  public Træner(String brugerNavn, String password,int trænerID) {
    super(brugerNavn, password);
    this.trænerID=trænerID;
  }
  public Træner(){
    staticTrænerID++;
    trænerID = staticTrænerID;
    super.setBrugerLogin("Træner" + trænerID);
  }


  public ArrayList<KonkurrenceSvømmer> skafKonkurrenceSvømmerer() {
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerer = new ArrayList<>();
    for (int i = 0; i < getMedlemsListen().size(); i++){
      if (getMedlemsListen().get(i) instanceof KonkurrenceSvømmer){
        konkurrenceSvømmerer.add((KonkurrenceSvømmer) getMedlemsListen().get(i));
      }
    }
    return konkurrenceSvømmerer;
  }

  public ArrayList<KonkurrenceSvømmer> skafJuniorHold () {
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmererListen = skafKonkurrenceSvømmerer();
    ArrayList<KonkurrenceSvømmer> juniorKonkurrenceSvømmere = new ArrayList<>();
    for(KonkurrenceSvømmer enSvømmer : konkurrenceSvømmererListen) {
      if (enSvømmer.udregnAlder() < 18) {
        juniorKonkurrenceSvømmere.add(enSvømmer);
      }
    }
    return juniorKonkurrenceSvømmere;
  }

  public ArrayList<KonkurrenceSvømmer> skafSeniorHold () {
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmererListen = skafKonkurrenceSvømmerer();
    ArrayList<KonkurrenceSvømmer> seniorKonkurrenceSvømmere = new ArrayList<>();

    for(KonkurrenceSvømmer enSvømmer : konkurrenceSvømmererListen) {
      if (enSvømmer.udregnAlder() >= 18) {
        seniorKonkurrenceSvømmere.add(enSvømmer);
      }
    }
    return seniorKonkurrenceSvømmere;
  }

  public ArrayList<KonkurrenceSvømmer> crawlOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    SorterKonkurrenceSvømmer sorterListe = new SorterKonkurrenceSvømmer();
    Disciplin crawl = Disciplin.CRAWL;
    arrayTilSortering = fjerneKonkurrencesvømmerMedManglendeTider(arrayTilSortering, crawl);
    return sorterListe.efterDisciplin(arrayTilSortering, crawl);
  }

  public ArrayList<KonkurrenceSvømmer> rygCrawlOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    SorterKonkurrenceSvømmer sorterListe = new SorterKonkurrenceSvømmer();
    Disciplin rygcrawl = Disciplin.RYGCRAWL;
    arrayTilSortering = fjerneKonkurrencesvømmerMedManglendeTider(arrayTilSortering, rygcrawl);
    return sorterListe.efterDisciplin(arrayTilSortering, rygcrawl);
  }

  public ArrayList<KonkurrenceSvømmer> brystSvømningOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    SorterKonkurrenceSvømmer sorterListe = new SorterKonkurrenceSvømmer();
    Disciplin brystsvømning = Disciplin.BRYSTSVØMNING;
    arrayTilSortering = fjerneKonkurrencesvømmerMedManglendeTider(arrayTilSortering, brystsvømning);
    return sorterListe.efterDisciplin(arrayTilSortering, brystsvømning);
  }

  public ArrayList<KonkurrenceSvømmer> butterflyOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    SorterKonkurrenceSvømmer sorterListe = new SorterKonkurrenceSvømmer();
    Disciplin butterfly = Disciplin.BUTTERFLY;
    arrayTilSortering = fjerneKonkurrencesvømmerMedManglendeTider(arrayTilSortering, butterfly);
    return sorterListe.efterDisciplin(arrayTilSortering, butterfly);
  }


  public ArrayList<KonkurrenceSvømmer> fjerneKonkurrencesvømmerMedManglendeTider(ArrayList<KonkurrenceSvømmer> listeDerSorteres, Disciplin disciplin) {
   for(KonkurrenceSvømmer enKonkurrenceSvømmer : listeDerSorteres){
     double bedsteTidISek = 0;
     if (enKonkurrenceSvømmer.getButterfly().getDisciplin() == disciplin) {
       bedsteTidISek = enKonkurrenceSvømmer.getButterfly().getBedsteTræningsTidISek();
     }
     if (enKonkurrenceSvømmer.getCrawl().getDisciplin() == disciplin) {
       bedsteTidISek = enKonkurrenceSvømmer.getCrawl().getBedsteTræningsTidISek();
     }
     if (enKonkurrenceSvømmer.getRygcrawl().getDisciplin() == disciplin) {
       bedsteTidISek = enKonkurrenceSvømmer.getRygcrawl().getBedsteTræningsTidISek();
     }
     if (enKonkurrenceSvømmer.getBrystsvømning().getDisciplin() == disciplin) {
       bedsteTidISek = enKonkurrenceSvømmer.getBrystsvømning().getBedsteTræningsTidISek();
     }
     if (bedsteTidISek == 0) {
       listeDerSorteres.remove(enKonkurrenceSvømmer);
     }
   }
    return listeDerSorteres;
  }


  public ArrayList<KonkurrenceSvømmer> top5KonkurrenceSvømmerer(ArrayList<KonkurrenceSvømmer> disciplinListe){

    ArrayList<KonkurrenceSvømmer> top5 = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      top5.add(disciplinListe.get(i));
    } return top5;
  }

  public void registrerKonkurrence() {
    // For de svømmere, der har deltaget i konkurrencer, registreres stævne, placering og tid.
  }

  public int getTrænerID() {
    return trænerID;
  }

  public static void setStaticTrænerID(int staticTrænerID) {
    Træner.staticTrænerID = staticTrænerID;
  }

  public static int getStaticTrænerID() {
    return staticTrænerID;
  }

  @Override
  public String toString() {
    return getBrugerLogin() + ";" + getPassword() + ";" + trænerID;
  }

}

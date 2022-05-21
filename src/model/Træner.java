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
    super.setBrugerLogin("Træner" + trænerID);
    staticTrænerID++;
    trænerID = staticTrænerID;
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

  public ArrayList<KonkurrenceSvømmer> skafJuniorHold (ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere) {
    ArrayList<KonkurrenceSvømmer> juniorKonkurrenceSvømmere = new ArrayList<>();
    for (int i = 0; i < konkurrenceSvømmere.size(); i++) {
      if (java.time.LocalDate.now().getYear() - konkurrenceSvømmere.get(i).getFødselsdato().getYear() < 18) {
        juniorKonkurrenceSvømmere.add(konkurrenceSvømmere.get(i));
      }
    }
    return juniorKonkurrenceSvømmere;
  }

  public ArrayList<KonkurrenceSvømmer> skafSeniorHold (ArrayList<KonkurrenceSvømmer> konkurrenceSvømmers) {
    ArrayList<KonkurrenceSvømmer> seniorKonkurrenceSvømmere = new ArrayList<>();
    for (int i = 0; i < konkurrenceSvømmers.size(); i++) {
      if(java.time.LocalDate.now().getYear() - konkurrenceSvømmers.get(i).getFødselsdato().getYear() > 18 && java.time.LocalDate.now().getYear()  - konkurrenceSvømmers.get(i).getFødselsdato().getYear() < 60){
        seniorKonkurrenceSvømmere.add(konkurrenceSvømmers.get(i));
      }
    }
    return seniorKonkurrenceSvømmere;
  }

  public ArrayList<KonkurrenceSvømmer> crawlOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    ArrayList<KonkurrenceSvømmer> disciplinOpdeltListeCrawl = new ArrayList<>();
    for (KonkurrenceSvømmer konkurrencesvømmer : arrayTilSortering) {
      Svømmedisciplin svømmedisciplin = konkurrencesvømmer.getSvømmedisciplin();
      if (svømmedisciplin.isErAktiv())
        if (svømmedisciplin.getDisciplin() == Disciplin.CRAWL) {
          disciplinOpdeltListeCrawl.add(konkurrencesvømmer);
        }
    }
    return disciplinOpdeltListeCrawl;
  }

  public ArrayList<KonkurrenceSvømmer> rygCrawlOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    ArrayList<KonkurrenceSvømmer> disciplinOpdeltListeRygCrawl = new ArrayList<>();
    for (KonkurrenceSvømmer konkurrencesvømmer : arrayTilSortering) {
      Svømmedisciplin svømmedisciplin = konkurrencesvømmer.getSvømmedisciplin();
      if (svømmedisciplin.isErAktiv())
        if (svømmedisciplin.getDisciplin() == Disciplin.RYGCRAWL) {
          disciplinOpdeltListeRygCrawl.add(konkurrencesvømmer);
        }
    } return disciplinOpdeltListeRygCrawl;
  }

  public ArrayList<KonkurrenceSvømmer> brystSvømningOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    ArrayList<KonkurrenceSvømmer> disciplinOpdeltListeBrystSvømning = new ArrayList<>();
    for (KonkurrenceSvømmer konkurrencesvømmer : arrayTilSortering) {
      Svømmedisciplin svømmedisciplin = konkurrencesvømmer.getSvømmedisciplin();
      if (svømmedisciplin.isErAktiv())
        if (svømmedisciplin.getDisciplin() == Disciplin.BRYSTSVØMNING) {
          disciplinOpdeltListeBrystSvømning.add(konkurrencesvømmer);
        }
    } return disciplinOpdeltListeBrystSvømning;
  }

  public ArrayList<KonkurrenceSvømmer> butterflyOpdeling(ArrayList<KonkurrenceSvømmer> arrayTilSortering) {
    ArrayList<KonkurrenceSvømmer> disciplinOpdeltListeButterfly = new ArrayList<>();
    for (KonkurrenceSvømmer konkurrencesvømmer : arrayTilSortering) {
      Svømmedisciplin svømmedisciplin = konkurrencesvømmer.getSvømmedisciplin();
      if (svømmedisciplin.isErAktiv())
        if (svømmedisciplin.getDisciplin() == Disciplin.BUTTERFLY) {
          disciplinOpdeltListeButterfly.add(konkurrencesvømmer);
        }
    } return disciplinOpdeltListeButterfly;
  }

  public ArrayList<KonkurrenceSvømmer> top5KonkurrenceSvømmerer(ArrayList<KonkurrenceSvømmer> disciplinListe){
    Collections.sort(disciplinListe);
    ArrayList<KonkurrenceSvømmer> top5 = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      top5.add(disciplinListe.get(i));
    } return top5;
  }

  public void registrerKonkurrence() {
    // For de svømmere, der har deltaget i konkurrencer, registreres stævne, placering og tid.
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

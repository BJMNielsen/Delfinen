package model;

import java.util.ArrayList;

public class Træner extends Ansat{

  private static int staticTrænerID;
  private int trænerID;


  public Træner(String brugerNavn, String password) {
    super(brugerNavn, password);
    staticTrænerID++;
    trænerID=staticTrænerID;
  }
//Dette er til når vi loader en træner ud fra en fil og laver ham
  public Træner(String brugerNavn, String password,int trænerID) {
    super(brugerNavn, password);
    this.trænerID=trænerID;
  }


  public ArrayList<KonkurrenceSvømmer> skafKonkurrenceSvømmerer() {
    // kald medlemslisten og sorter den efter hvem der er aktiv som konkurrencesvømmere og læg dem derefter i konkurrenceSvømmere arraylisten.
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerer = new ArrayList<>();
    return konkurrenceSvømmerer;
  }

  public void visTop5Svømmerer() {
    // Træneren ønsker derfor en oversigt,
    // der kan vise klubbens top 5 svømmere inden for hver svømmedisciplin
    // (butterfly, crawl, rygcrawl og brystsvømning), fordelt på henholdsvis junior og seniorsvømmere.
    // Vi skal lave en metode der spørger træneren først: Hvilken svømmedisciplin vil du se top 5 over?
      // 1) Brystsvømning
      // 2) Crawl... osv osv
    // Så vælger han en svømmedisciplin og så vises der en top over både Junior or seniorsvømmere.
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

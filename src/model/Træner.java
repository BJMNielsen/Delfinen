package model;

import java.util.ArrayList;

public class Træner extends Ansat{


  public Træner(String brugerNavn, String password) {
    super(brugerNavn, password);
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
}

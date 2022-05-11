package model;

import java.util.ArrayList;

public class Træner extends Ansat{


  public Træner(String brugerNavn) {
    super(brugerNavn);
  }


  public ArrayList<KonkurrenceSvømmer> skafKonkurrenceSvømmerer() {
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerer = new ArrayList<>();
    return konkurrenceSvømmerer;
  }
}

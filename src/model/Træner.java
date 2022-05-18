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

package model;

import java.util.ArrayList;

public abstract class Ansat {
  private static ArrayList<Medlem> medlemsListen;
  private String brugerLogin;
  private String password;



  public Ansat(String brugerLogin, String password) {
    this.brugerLogin = brugerLogin;
    this.password = password;
  }

  public Ansat (String brugerLogin){
    this.brugerLogin = brugerLogin;
    this.password = brugerLogin +1;
  }

  public static void addMedlem(Medlem medlem){
    medlemsListen.add(medlem);
  }

  public static void removeMember(Medlem etMedlem) {
    medlemsListen.remove(etMedlem);
  }

  public static void addKonkurrencesvømmer(KonkurrenceSvømmer konkurrenceSvømmer){
    medlemsListen.add(konkurrenceSvømmer);
  }

  public static void setMedlemsListe(ArrayList<Medlem> medlemsListe) {
    medlemsListen = medlemsListe;
  }

  public static ArrayList<Medlem> getMedlemsListen() {
    return medlemsListen;
  }

  public void seMedlemsListe() {

  }

  public void logout() {
    // lav en logout metode der sender Formand, kasserer, eller træner tilbage til den første hovedmenu
  }
}

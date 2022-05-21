package model;

import java.util.ArrayList;

public abstract class Ansat {
  private ArrayList<Medlem> medlemsListen;
  private String brugerLogin;
  private String password;

  public Ansat(String brugerLogin, String password) {
    this.brugerLogin = brugerLogin;
    this.password = password;

  }

  public Ansat(String brugerLogin) {
    this.brugerLogin = brugerLogin;
    this.password = brugerLogin + 1;
  }

  public Ansat(){
    this.password = "Password";
  }

  public void addMedlem(Medlem medlem) {
    medlemsListen.add(medlem);
  }

  public void removeMember(Medlem etMedlem) {
    medlemsListen.remove(etMedlem);
  }

  public void addKonkurrencesvømmer(KonkurrenceSvømmer konkurrenceSvømmer) {
    medlemsListen.add(konkurrenceSvømmer);
  }

  public void logout() {
    // lav en logout metode der sender Formand, kasserer, eller træner tilbage til den første hovedmenu
  }


  // getters og setters
  public String getBrugerLogin() {
    return brugerLogin;
  }
  public void setBrugerLogin(String brugerLogin) {
    this.brugerLogin = brugerLogin;
  }

  public void setMedlemsListe(ArrayList<Medlem> medlemsListe) {
    medlemsListen = medlemsListe;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ArrayList<Medlem> getMedlemsListen() {
    return medlemsListen;
  }

  public void seMedlemsListe() {

  }

  @Override
  public String toString() {
    return brugerLogin + ";" + password;
  }
}



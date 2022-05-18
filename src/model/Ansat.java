package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Ansat {
  private ArrayList<Medlem> medlemsListen;
  private String brugerLogin;
  private String password;

  public Ansat(String brugerLogin, String password) {
    this.brugerLogin = brugerLogin;
    this.password = password;
    medlemsListen = new ArrayList<>();
  }

  public Ansat(String brugerLogin) {
    this.brugerLogin = brugerLogin;
    this.password = brugerLogin + 1;
  }

  public Ansat(){
    this.password = "Password";
  }

  public void indsætTestData() {
    Medlem m1 = new Medlem("Børge", LocalDate.parse("1993-10-01"), true, 1600);
    Medlem m2 = new Medlem("Knud", LocalDate.parse("1990-03-10"), false, 500);
    Medlem m3 = new Medlem("Louise", LocalDate.parse("2000-04-12"), true, 1600);
    Medlem m4 = new Medlem("Hans", LocalDate.parse("2008-05-15"), true, 1000);
    Medlem m5 = new Medlem("Line", LocalDate.parse("1999-07-03"), true, 1600);
    Medlem m6 = new Medlem("Godzilla", LocalDate.parse("2010-09-04"), true, 1000);
    Medlem m7 = new Medlem("Frederik", LocalDate.parse("1950-01-01"), true, 1200);
    Medlem m8 = new Medlem("Lars", LocalDate.parse("1949-12-12"), false, 500);
    Medlem m9 = new Medlem("Berit", LocalDate.parse("1960-10-04"), true, 1200);
    Medlem m10 = new Medlem("Grete", LocalDate.parse("1992-04-10"), false, 500);

    medlemsListen.add(m1);
    medlemsListen.add(m2);
    medlemsListen.add(m3);
    medlemsListen.add(m4);
    medlemsListen.add(m5);
    medlemsListen.add(m6);
    medlemsListen.add(m7);
    medlemsListen.add(m8);
    medlemsListen.add(m9);
    medlemsListen.add(m10);

    //Det fulde kontingent for alle medlemmer skulle meget gerne give = 10700
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



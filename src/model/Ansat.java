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

  public Ansat (String brugerLogin){
    this.brugerLogin = brugerLogin;
    this.password = brugerLogin +1;
  }

  public void indsætTestData() {
    Medlem m1 = new Medlem(1, "Børge", LocalDate.parse("1993-10-01"), true);
    medlemsListen.add(m1);
  }

  public void addMedlem(Medlem medlem){
    medlemsListen.add(medlem);
  }

  public void removeMember(Medlem etMedlem) {
    medlemsListen.remove(etMedlem);
  }

  public void addKonkurrencesvømmer(KonkurrenceSvømmer konkurrenceSvømmer){
    medlemsListen.add(konkurrenceSvømmer);
  }

  public void setMedlemsListe(ArrayList<Medlem> medlemsListe) {
    medlemsListen = medlemsListe;
  }



  public void logout() {
    // lav en logout metode der sender Formand, kasserer, eller træner tilbage til den første hovedmenu
  }
// getters og setters
  public String getBrugerLogin() {
    return brugerLogin;
  }

  public String getPassword() {
    return password;
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

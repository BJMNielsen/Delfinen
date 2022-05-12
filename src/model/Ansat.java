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

  public void seMedlemsListe() {

  }

  public void logout() {
    // lav en logout metode der sender Formand, kasserer, eller træner tilbage til den første hovedmenu
  }
}

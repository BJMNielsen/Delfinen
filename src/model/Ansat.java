package model;

import java.util.ArrayList;

public abstract class Ansat {
  private static ArrayList<Medlem> medlemsListen;
  private String brugerLogin;


  public Ansat(String brugerLogin) {
    this.brugerLogin = brugerLogin;
  }
}

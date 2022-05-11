package model;

import java.time.LocalDate;

public class Svømmedisciplin {
  private boolean erAktiv;
  private Disciplin svømmedisciplin;
  private double bedsteTræningsTidISek;
  private LocalDate datoForBedsteTid;


  public Svømmedisciplin(boolean erAktiv, Disciplin svømmedisciplin) {
    this.erAktiv = erAktiv;
    this.svømmedisciplin = svømmedisciplin;
  }
  public Svømmedisciplin(Disciplin svømmedisciplin){
    this.erAktiv = false;
    this.svømmedisciplin = svømmedisciplin;
  }
}

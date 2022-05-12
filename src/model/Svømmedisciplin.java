package model;

import enums.Disciplin;

import java.time.LocalDate;

public class Svømmedisciplin {
  private boolean erAktiv;
  private Disciplin svømmedisciplin;
  private double bedsteTræningsTidISek;
  private LocalDate datoForBedsteTid;


  public Svømmedisciplin(Disciplin svømmedisciplin, boolean erAktiv) {
    this.erAktiv = erAktiv;
    this.svømmedisciplin = svømmedisciplin;
  }
  public Svømmedisciplin(Disciplin svømmedisciplin){
    this.erAktiv = false;
    this.svømmedisciplin = svømmedisciplin;
  }
}

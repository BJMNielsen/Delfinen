package model;

import enums.Disciplin;

import java.time.LocalDate;

public class Svømmedisciplin {
  private boolean erAktiv;
  private Disciplin disciplin;
  private double bedsteTræningsTidISek;
  private LocalDate datoForBedsteTid;


  public Svømmedisciplin(boolean erAktiv, Disciplin disciplin, double bedsteTræningsTidISek, LocalDate datoForBedsteTid) {
    this.erAktiv = erAktiv;
    this.disciplin = disciplin;
    this.bedsteTræningsTidISek = bedsteTræningsTidISek;
    this.datoForBedsteTid = datoForBedsteTid;
  }


  @Override
  public String toString() {
    return  "" + erAktiv + ';' + disciplin + ';' + bedsteTræningsTidISek + ';'
        + datoForBedsteTid.getYear() + ';' + datoForBedsteTid.getMonthValue() + ';'
        + datoForBedsteTid.getDayOfMonth();
  }
}

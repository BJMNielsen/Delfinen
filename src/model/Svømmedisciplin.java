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

  public Svømmedisciplin(boolean erAktiv, Disciplin disciplin) {
    this.erAktiv = erAktiv;
    this.disciplin = disciplin;
    bedsteTræningsTidISek = 0;
    datoForBedsteTid = null;
  }

  public double getBedsteTræningsTidISek() {
    return bedsteTræningsTidISek;
  }

  public Disciplin getDisciplin() {
    return disciplin;
  }

  public boolean isErAktiv() {
    return erAktiv;
  }

  @Override
  public String toString() {
    String bedsteTidDato;
    if(datoForBedsteTid == null)
      return "" + erAktiv + ';' + disciplin + ';' + bedsteTræningsTidISek;
    else
    return "" + erAktiv + ';' + disciplin + ';' + bedsteTræningsTidISek + ';'
        + datoForBedsteTid.getYear() + ';' + datoForBedsteTid.getMonthValue() + ';'
        + datoForBedsteTid.getDayOfMonth();

  }
}

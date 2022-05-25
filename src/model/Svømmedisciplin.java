package model;

import enums.Disciplin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

  public String getErAktivSomTekst() {
    if (erAktiv) {
      return "aktiv";
    }
    return "inaktiv";
  }

  public String getDatoForBedsteTidFormateret() {
    DateTimeFormatter danishDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return datoForBedsteTid.format(danishDateFormat);
  }

  public String printSvømmedisciplinTilKonkurrenceSvømmer(){
    String disciplin = String.valueOf(getDisciplin());
    String erAktiv = getErAktivSomTekst();
    String bedsteTidEtEllerAndet;
    String datoForBedsteTid;
    if(getBedsteTræningsTidISek() > 0){
      bedsteTidEtEllerAndet = "Bedste tid: " + getBedsteTræningsTidISek() + " sek,";
      datoForBedsteTid = "Dato: " + getDatoForBedsteTidFormateret();
    } else {
      bedsteTidEtEllerAndet = "Ingen Bedste tid,";
      datoForBedsteTid = "Ingen dato.";
    }
    return disciplin + ": " + erAktiv + ", " + bedsteTidEtEllerAndet + " " + datoForBedsteTid;
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

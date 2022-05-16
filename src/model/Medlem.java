package model;

import java.time.LocalDate;

// et medlem er en motionssvømmer
public class Medlem {
  private String ID;
  private String navn;
  private LocalDate fødselsdato; // skal måske bare være en årstals Int som fx 1993. Ellers bliver det svært at regne?
  private boolean erAktiv;
  private double konto;

  public Medlem(String ID, String navn, LocalDate fødselsdato, boolean erAktiv, double konto) {
    this.ID = ID;
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
    this.konto = konto;

  }
  public Medlem(String ID, String navn, LocalDate fødselsdato, boolean erAktiv){
    this.ID = ID;
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
  }

  // Getters & Setters

  public String getID() {
    return ID;
  }

  public String getNavn() {
    return navn;
  }
  public LocalDate getFødselsdato() {
    return fødselsdato;
  }
  public boolean getErAktiv() {
    return erAktiv;
  }

  public double getKonto() {
    return konto;
  }
}

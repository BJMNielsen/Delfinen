package model;

import java.time.LocalDate;

public abstract class Medlem {
  private String navn;
  private LocalDate fødselsdato;
  private boolean erAktiv;

  public Medlem(String navn, LocalDate fødselsdato, boolean erAktiv) {
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
  }



  // Getters & Setters
  public String getNavn() {
    return navn;
  }
  public LocalDate getFødselsdato() {
    return fødselsdato;
  }
  public boolean getErAktiv() {
    return erAktiv;
  }
}

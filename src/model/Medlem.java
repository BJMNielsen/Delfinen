package model;

import java.time.LocalDate;

// et medlem er en motionssvømmer
public class Medlem {
  private String navn;
  private LocalDate fødselsdato; // skal måske bare være en årstals Int som fx 1993. Ellers bliver det svært at regne?
  private boolean erAktiv;
  private boolean iRestance;

  public Medlem(String navn, LocalDate fødselsdato, boolean erAktiv, boolean iRestance) {
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
    this.iRestance = iRestance;

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

  public boolean isiRestance() {
    return iRestance;
  }
}

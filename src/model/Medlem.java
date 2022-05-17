package model;

import java.time.LocalDate;

// et medlem er en motionssvømmer
public class Medlem {
  private static int medlemsnummer; // lav om til at være autogenereret fra 1. OG INT
  private String navn;
  private LocalDate fødselsdato; // skal måske bare være en årstals Int som fx 1993. Ellers bliver det svært at regne?
  private boolean erAktiv;
  private double konto;

  public Medlem(int medlemsnummer, String navn, LocalDate fødselsdato, boolean erAktiv, double konto) {
    this.medlemsnummer = medlemsnummer;
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
    this.konto = konto;

  }
  public Medlem(int medlemsnummer, String navn, LocalDate fødselsdato, boolean erAktiv){
    this.medlemsnummer = medlemsnummer;
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
  }

  @Override
  public String toString() {
    return medlemsnummer + ';' + navn + ';' + fødselsdato.getYear() + ';' + fødselsdato.getMonthValue() + ';'
        + fødselsdato.getDayOfMonth() + ';' + erAktiv + ';' + konto;
  }

  // Getters & Setters

  public int getMedlemsnummer() {
    return medlemsnummer;
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

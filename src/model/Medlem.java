package model;

import java.time.LocalDate;

// et medlem er en motionssvømmer
public class Medlem {
  private static int staticMedlemsnummer; // lav om til at være autogenereret fra 1. OG INT
  private int medlemsnummer;
  private String navn;
  private LocalDate fødselsdato; // skal måske bare være en årstals Int som fx 1993. Ellers bliver det svært at regne?
  private boolean erAktiv;
  private double kontingentBalance;

  // kontruktor til at lave medlemmer
  public Medlem(String navn, LocalDate fødselsdato, boolean erAktiv, double konto) {
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
    this.kontingentBalance = konto;
    staticMedlemsnummer++;
    medlemsnummer = staticMedlemsnummer;
  }
  // konstruktor til at lave medlemmer som bliver loadet ind fra en fil-liste med medlemsnummer.
  public Medlem(String navn, LocalDate fødselsdato, boolean erAktiv, double konto, int medlemsnummer){
    this.navn = navn;
    this.fødselsdato = fødselsdato;
    this.erAktiv = erAktiv;
    this.kontingentBalance = konto;
    this.medlemsnummer = medlemsnummer;
  }

  @Override
  public String toString() {
    return navn + ';' + fødselsdato.getYear() + ';' + fødselsdato.getMonthValue() + ';'
        + fødselsdato.getDayOfMonth() + ';' + erAktiv + ';' + kontingentBalance + ';' + medlemsnummer;
  }

  // Getters & Setters

  public int getMedlemsnummer() {
    return staticMedlemsnummer;
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

  public double getKontingentBalance() {
    return kontingentBalance;
  }

  public static int getStaticMedlemsnummer() {
    return staticMedlemsnummer;
  }

  public static void setStaticMedlemsnummer(int staticMedlemsnummer) {
    Medlem.staticMedlemsnummer = staticMedlemsnummer;
  }
}

package model;

import view.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Formand extends Ansat{


  public Formand() {
    super("Formand", "Password");
  }
  public Formand(String brugerNavn, String password) {
    super(brugerNavn, password);
  }

  public void indmeldMedlem() {
    Scanner input = new Scanner(System.in);
    UI ui = new UI();
    ui.indtastNoget("brugernavn");
    String navn = input.nextLine();
    ui.indtastNoget("fødselsdato");
    LocalDate fødselsdato = LocalDate.parse(input.nextLine());
    ui.indtastNoget("fødselsdato");
    boolean erAktiv = input.nextBoolean();
    boolean iRestance = input.nextBoolean();
    Medlem etMedlem = new Medlem(navn, fødselsdato, erAktiv, iRestance);

    ArrayList<Medlem> medlemsListen = Ansat.getMedlemsListen();
    medlemsListen.add(etMedlem);
    Ansat.setMedlemsListe(medlemsListen);
    // Først skal der laves et medlem (skal ikke ligges ind på medlemslisten)
    // Derefter skal formanden spørges: SKal dette medlem også være konkurrencesvømmer? Hvis nej, så stopper metoden og de addes til medlemslisten.
    // Hvis ja, så skal vi køre en metode der sender medlemmet over til opretKonkurrenceSvømmer metode eller hvad den kommer til at hedde.

  }

  public void fjernMedlem() {

  }

}


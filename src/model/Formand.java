package model;

public class Formand extends Ansat{


  public Formand(String brugerNavn, String password) {
    super(brugerNavn, password);
  }

  public void indmeldMedlem() {

    // Først skal der laves et medlem (skal ikke ligges ind på medlemslisten)
    // Derefter skal formanden spørges: SKal dette medlem også være konkurrencesvømmer? Hvis nej, så stopper metoden og de addes til medlemslisten.
    // Hvis ja, så skal vi køre en metode der sender medlemmet over til opretKonkurrenceSvømmer metode eller hvad den kommer til at hedde.

  }

  public void fjernMedlem() {

  }

}


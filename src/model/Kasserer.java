package model;

import java.util.ArrayList;

public class Kasserer extends Ansat{

  public Kasserer(String brugerLogin, String password) {
    super(brugerLogin, password);
  }

  public double beregnKontingentForEtMedlem (Medlem etMedlem) {
    if (etMedlem.getErAktiv()) {
      // de betale noget ud efter deres alder
    } else {
      // de betaler 500 kroner om året
    }
    // den her metode skal vise den forventede samlede kontingent indbetaling for alle medlemmer.
    return 1;
  }

  public double beregnKontingentForAlleMedlemmer() {
    for (int i = 0; i < getMedlemsListen().size(); i++) {
    }
    return 1600;
  }


  public String seRestanceMedlemmer() {
    return "";
  }
}

package model;

public class Kasserer extends Ansat{



  public Kasserer(String brugerLogin, String password) {
    super(brugerLogin, password);
  }

  public int visKontingent () {
    // den her metode skal vise den forventede samlede kontingent indbetaling for alle medlemmer.
    return 1;
  }


  public String seRestanceMedlemmer() {
    return "";
  }
}

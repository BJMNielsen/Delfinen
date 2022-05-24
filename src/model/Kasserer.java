package model;

public class Kasserer extends Ansat{
  double result;
  double kontingent;


  public Kasserer(String brugerLogin, String password) {
    super(brugerLogin, password);
  }

  public Kasserer(){
    super.setBrugerLogin("Kasserer");
  }

  public double beregnKontingentForEtMedlem (Medlem etMedlem) {
    if (etMedlem.getErAktiv()) {
      if(etMedlem.udregnAlder() < 18){
        kontingent = 1000;
      }
      else if(java.time.LocalDate.now().getYear() - etMedlem.getFødselsdato().getYear() >= 18 && java.time.LocalDate.now().getYear()  - etMedlem.getFødselsdato().getYear() < 60){
        kontingent = 1600;
      } else {
        kontingent = 1200;
      }

    } else {
        kontingent = 500;
    }
    return kontingent;
  }

  public double beregnKontingentForAlleMedlemmer() {
    for (int i = 0; i < getMedlemsListen().size(); i++) {
      result += beregnKontingentForEtMedlem(getMedlemsListen().get(i));
    }
    return result;
  }

  public void seRestanceMedlemmer() {
    for (int i = 0; i < getMedlemsListen().size(); i++) {
      if(getMedlemsListen().get(i).getKontingentBalance() < 0){
        System.out.println(getMedlemsListen().get(i));
      }
    }
  }
}

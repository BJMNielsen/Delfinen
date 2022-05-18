package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kasserer extends Ansat{
  double result;
  double kontingent;
  ArrayList<Medlem> medlemsListen = new ArrayList<>();


  public Kasserer(String brugerLogin, String password) {
    super(brugerLogin, password);
  }

  public Kasserer(){
    super.setBrugerLogin("Kasserer");
  }

  public double beregnKontingentForEtMedlem (Medlem etMedlem) {

    if (etMedlem.getErAktiv()) {
      if(java.time.LocalDate.now().getYear() - etMedlem.getFødselsdato().getYear() < 18){
        kontingent = 1000;
      }
      else if(java.time.LocalDate.now().getYear() - etMedlem.getFødselsdato().getYear() > 18 && java.time.LocalDate.now().getYear()  - etMedlem.getFødselsdato().getYear() < 60){
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
    for (int i = 0; i < medlemsListen.size(); i++) {
      result = result + medlemsListen.get(i).getKontingentBalance();
    }
    return result;
  }

  public void seRestanceMedlemmer() {
    for (int i = 0; i < medlemsListen.size(); i++) {
      if(medlemsListen.get(i).getKontingentBalance() < 0){
        System.out.println(medlemsListen.get(i));
      }
    }
  }
}

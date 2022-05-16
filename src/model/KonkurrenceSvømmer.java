package model;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem{
  private String træner;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;



  public KonkurrenceSvømmer(Medlem etMedlem, String træner, ArrayList<Svømmedisciplin> discipliner) {
    super(etMedlem.getID(), etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKonto());
    this.træner = træner;
    butterfly = discipliner.get(0);
    crawl = discipliner.get(1);
    rygcrawl = discipliner.get(2);
    brystsvømning = discipliner.get(3);
  }

  @Override
  public String toString() {
    return getID() + ';' + getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKonto() + ';' + træner + ';' + butterfly + ';' + crawl + ';'
        + rygcrawl + ';' + brystsvømning;
  }
}

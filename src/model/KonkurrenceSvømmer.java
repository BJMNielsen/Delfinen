package model;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem{
  private int trænerID;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;



  public KonkurrenceSvømmer(Medlem etMedlem, int trænerID, ArrayList<Svømmedisciplin> discipliner) {
    super(etMedlem.getMedlemsnummer(), etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKonto());
    this.trænerID = trænerID;
    butterfly = discipliner.get(0);
    crawl = discipliner.get(1);
    rygcrawl = discipliner.get(2);
    brystsvømning = discipliner.get(3);
  }

  @Override
  public String toString() {
    return getMedlemsnummer() + ';' + getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKonto() + ';' + trænerID + ';' + butterfly + ';' + crawl + ';'
        + rygcrawl + ';' + brystsvømning;
  }
}

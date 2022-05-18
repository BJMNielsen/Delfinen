package model;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem implements Comparable{
  private int trænerID;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;



  public KonkurrenceSvømmer(Medlem etMedlem, int trænerID, ArrayList<Svømmedisciplin> discipliner) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKontingentBalance(), etMedlem.getMedlemsnummer());
    this.trænerID = trænerID;
    butterfly = discipliner.get(0);
    crawl = discipliner.get(1);
    rygcrawl = discipliner.get(2);
    brystsvømning = discipliner.get(3);
  }

  public Svømmedisciplin getBrystsvømning() {
    return brystsvømning;
  }

  public Svømmedisciplin getButterfly() {
    return butterfly;
  }

  public Svømmedisciplin getCrawl() {
    return crawl;
  }

  public Svømmedisciplin getRygcrawl() {
    return rygcrawl;
  }

  @Override
  public String toString() {
    return "" + getMedlemsnummer() + ';' + getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKontingentBalance() + ';' + trænerID + ';' + butterfly + ';' + crawl + ';'
        + rygcrawl + ';' + brystsvømning;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}

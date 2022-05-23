package model;


public class KonkurrenceSvømmer extends Medlem {
  private int trænerID;
  private Svømmedisciplin butterfly,crawl,rygcrawl,brystsvømning;


  public KonkurrenceSvømmer(Medlem etMedlem, int trænerID, Svømmedisciplin butterfly, Svømmedisciplin crawl, Svømmedisciplin rygcrawl, Svømmedisciplin brystsvømning) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKontingentBalance(), etMedlem.getMedlemsnummer());
    this.trænerID = trænerID;
    this.butterfly = butterfly;
    this.crawl = crawl;
    this.rygcrawl = rygcrawl;
    this.brystsvømning = brystsvømning;
  }


  public Svømmedisciplin getRygcrawl() {
    return rygcrawl;
  }

  public Svømmedisciplin getCrawl() {
    return crawl;
  }

  public Svømmedisciplin getButterfly() {
    return butterfly;
  }

  public Svømmedisciplin getBrystsvømning() {
    return brystsvømning;
  }

  @Override
  public String toString() {
    return getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKontingentBalance() + ';' + getMedlemsnummer() + ';' +
        trænerID + ';' + butterfly + ";" + crawl + ";" + rygcrawl + ";" + brystsvømning;
  }

  public int getTrænerID() {
    return trænerID;
  }

  /*
  @Override
  public int compareTo(KonkurrenceSvømmer svømmer) {
    return Double.compare(this.svømmedisciplin.getBedsteTræningsTidISek(), svømmer.svømmedisciplin.getBedsteTræningsTidISek());
  }

   */

}

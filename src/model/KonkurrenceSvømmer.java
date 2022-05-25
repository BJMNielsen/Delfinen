package model;


import enums.Disciplin;

public class KonkurrenceSvømmer extends Medlem {
  private int trænerID;
  private Svømmedisciplin butterfly,crawl,rygcrawl,brystsvømning;
  private Konkurrence konkurrence;


  public KonkurrenceSvømmer(Medlem etMedlem, int trænerID, Svømmedisciplin butterfly, Svømmedisciplin crawl, Svømmedisciplin rygcrawl, Svømmedisciplin brystsvømning) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKontingentBalance(), etMedlem.getMedlemsnummer());
    this.trænerID = trænerID;
    this.butterfly = butterfly;
    this.crawl = crawl;
    this.rygcrawl = rygcrawl;
    this.brystsvømning = brystsvømning;
    this.konkurrence = null;
  }
  public KonkurrenceSvømmer(Medlem etMedlem, int trænerID, Svømmedisciplin butterfly, Svømmedisciplin crawl, Svømmedisciplin rygcrawl, Svømmedisciplin brystsvømning, Konkurrence konkurrence) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKontingentBalance(), etMedlem.getMedlemsnummer());
    this.trænerID = trænerID;
    this.butterfly = butterfly;
    this.crawl = crawl;
    this.rygcrawl = rygcrawl;
    this.brystsvømning = brystsvømning;
    this.konkurrence = konkurrence;
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
  public Svømmedisciplin getSvømmedisciplin(Disciplin disciplin) {
    if(disciplin == Disciplin.BUTTERFLY){
      return butterfly;
    }
    if(disciplin == Disciplin.CRAWL){
      return crawl;
    }
    if(disciplin == Disciplin.BRYSTSVØMNING){
      return brystsvømning;
    }
    if(disciplin == Disciplin.RYGCRAWL){
      return rygcrawl;
    }
    else return null;
  }
  @Override
  public String toString() {
    String enKonkurrence = "";
    if (konkurrence != null) {
      enKonkurrence = ";" + konkurrence;
    }
    return getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKontingentBalance() + ';' + getMedlemsnummer() + ';' +
        trænerID + ';' + butterfly + ";" + crawl + ";" + rygcrawl + ";" + brystsvømning + enKonkurrence;
  }

  public int getTrænerID() {
    return trænerID;
  }

  public Konkurrence getKonkurrence() {
    return konkurrence;
  }

  public void setKonkurrence(Konkurrence konkurrence) {
    this.konkurrence = konkurrence;
  }
}

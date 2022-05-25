package model;


import enums.Disciplin;

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
    return getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKontingentBalance() + ';' + getMedlemsnummer() + ';' +
        trænerID + ';' + butterfly + ";" + crawl + ";" + rygcrawl + ";" + brystsvømning;
  }

  public int getTrænerID() {
    return trænerID;
  }

}

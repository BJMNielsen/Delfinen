package model;

public class KonkurrenceSvømmer extends Medlem{
  private Træner enTræner;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;


  public KonkurrenceSvømmer(Medlem etMedlem) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.isiRestance());
    enTræner = null;
  }
  public KonkurrenceSvømmer(Medlem etMedlem, Træner enTræner) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.isiRestance());
    this.enTræner = enTræner;
  }
}

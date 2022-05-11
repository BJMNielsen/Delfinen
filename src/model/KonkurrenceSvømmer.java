package model;

public class KonkurrenceSvømmer extends Medlem{
  private Træner enTræner;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;


  public KonkurrenceSvømmer(MotionistSvømmer etMedlem) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv());
    enTræner = null;
  }
  public KonkurrenceSvømmer(MotionistSvømmer etMedlem, Træner enTræner) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv());
    this.enTræner = enTræner;
  }
}

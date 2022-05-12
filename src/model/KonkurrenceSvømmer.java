package model;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem{
  private Træner enTræner;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;
  private ArrayList<String> konkurrence = new ArrayList<>();



  public KonkurrenceSvømmer(Medlem etMedlem, Træner enTræner) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.isiRestance());
    this.enTræner = enTræner;
  }
}

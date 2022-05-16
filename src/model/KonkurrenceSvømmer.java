package model;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem{
  private Træner enTræner;
  private String træner;
  private Svømmedisciplin butterfly, crawl, rygcrawl, brystsvømning;
  private ArrayList<String> konkurrence = new ArrayList<>();



  public KonkurrenceSvømmer(Medlem etMedlem, String træner) {
    super(etMedlem.getID(), etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKonto());
    this.træner = træner;
  }
}

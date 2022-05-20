package model;


public class KonkurrenceSvømmer extends Medlem implements Comparable<KonkurrenceSvømmer> {
  private int trænerID;
  private Svømmedisciplin svømmedisciplin;


  public KonkurrenceSvømmer(Medlem etMedlem, int trænerID, Svømmedisciplin discipliner) {
    super(etMedlem.getNavn(), etMedlem.getFødselsdato(), etMedlem.getErAktiv(), etMedlem.getKontingentBalance(), etMedlem.getMedlemsnummer());
    this.trænerID = trænerID;
    this.svømmedisciplin = discipliner;
  }

  public Svømmedisciplin getSvømmedisciplin() {
    return svømmedisciplin;
  }

  @Override
  public String toString() {
    return getNavn() + ';' + getFødselsdato().getYear() + ';' +
        getFødselsdato().getMonthValue() + ';' + getFødselsdato().getDayOfMonth() + ';' +
        getErAktiv() + ';' + getKontingentBalance() + ';' + getMedlemsnummer() + ';' +
        trænerID + ';' + svømmedisciplin;
  }

  public int getTrænerID() {
    return trænerID;
  }

  @Override
  public int compareTo(KonkurrenceSvømmer svømmer) {
    return Double.compare(this.svømmedisciplin.getBedsteTræningsTidISek(), svømmer.svømmedisciplin.getBedsteTræningsTidISek());
  }
}

package model;

import enums.Disciplin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SorterKonkurrenceSvømmer {

  public ArrayList<KonkurrenceSvømmer> efterDisciplin (ArrayList<KonkurrenceSvømmer> konkurrenceSvømmmerListe, Disciplin disciplin) {
    ArrayList<KonkurrenceSvømmer> sorteretListe = konkurrenceSvømmmerListe;
    if(disciplin == Disciplin.BUTTERFLY){
      Collections.sort(sorteretListe, new CompareButterfly());
    }
    if (disciplin == Disciplin.CRAWL){
      Collections.sort(sorteretListe, new CompareCrawl());
    }
    if (disciplin == Disciplin.RYGCRAWL){
      Collections.sort(sorteretListe, new CompareRygcrawl());
    }
    if (disciplin == Disciplin.BRYSTSVØMNING){
      Collections.sort(sorteretListe, new CompareBrystsvømning());
    }
    return sorteretListe;
  }


  public class CompareButterfly implements Comparator<KonkurrenceSvømmer>{


    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2){
      double svømmer1BedstetidISek = svømmer1.getButterfly().getBedsteTræningsTidISek();
      double svømmer2BedstetidISek = svømmer2.getButterfly().getBedsteTræningsTidISek();

      int bedsteTid1IMillisekunder = (int) svømmer1BedstetidISek * 1000;
      int bedsteTid2IMillisekunder = (int) svømmer2BedstetidISek * 1000;

      return bedsteTid1IMillisekunder - bedsteTid2IMillisekunder;
    }

  }

  public class CompareCrawl implements Comparator<KonkurrenceSvømmer>{
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2){
      double svømmer1BedstetidISek = svømmer1.getCrawl().getBedsteTræningsTidISek();
      double svømmer2BedstetidISek = svømmer2.getCrawl().getBedsteTræningsTidISek();

      int bedsteTid1IMillisekunder = (int) svømmer1BedstetidISek * 1000;
      int bedsteTid2IMillisekunder = (int) svømmer2BedstetidISek * 1000;

      return bedsteTid1IMillisekunder - bedsteTid2IMillisekunder;
    }
  }

  public class CompareRygcrawl implements Comparator<KonkurrenceSvømmer>{
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2){
      double svømmer1BedstetidISek = svømmer1.getRygcrawl().getBedsteTræningsTidISek();
      double svømmer2BedstetidISek = svømmer2.getRygcrawl().getBedsteTræningsTidISek();

      int bedsteTid1IMillisekunder = (int) svømmer1BedstetidISek * 1000;
      int bedsteTid2IMillisekunder = (int) svømmer2BedstetidISek * 1000;

      return bedsteTid1IMillisekunder - bedsteTid2IMillisekunder;
    }
  }

  public class CompareBrystsvømning implements Comparator<KonkurrenceSvømmer>{
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2){
      double svømmer1BedstetidISek = svømmer1.getBrystsvømning().getBedsteTræningsTidISek();
      double svømmer2BedstetidISek = svømmer2.getBrystsvømning().getBedsteTræningsTidISek();

      int bedsteTid1IMillisekunder = (int) svømmer1BedstetidISek * 1000;
      int bedsteTid2IMillisekunder = (int) svømmer2BedstetidISek * 1000;

      return bedsteTid1IMillisekunder - bedsteTid2IMillisekunder;
    }
  }

}

package model;

import java.time.LocalDate;

public class MotionistSvømmer extends Medlem {

  public MotionistSvømmer(String navn, LocalDate fødselsdato, boolean erAktiv) {
    super(navn, fødselsdato, erAktiv);
  }
}

package model;

import java.util.ArrayList;

public class Konkurrence {
  String stævneNavn;
  int placering;
  double tid;

  public Konkurrence(String stævneNavn, int placering, double tid) {
    this.stævneNavn = stævneNavn;
    this.placering = placering;
    this.tid = tid;
  }

  @Override
  public String toString() {
    return stævneNavn + ';' + placering + ';' + tid;
  }
}

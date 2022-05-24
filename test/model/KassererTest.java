package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KassererTest {

    @Test
    void beregnKontingentForEtMedlem() {
        //arrange
        Kasserer Lars = new Kasserer("Lars", "Lars");
        Medlem medlem1 = new Medlem("Børge",LocalDate.parse("2000-04-12"),true,1600);
        //act
        double actualValue = Lars.beregnKontingentForEtMedlem(medlem1);
        //assert
        assertEquals(1600, actualValue);

    }

    @Test
    void beregnKontingentForAlleMedlemmer() {
        //arrange
        Kasserer Lars = new Kasserer("Lars", "Lars");
        ArrayList<Medlem> medlems = new ArrayList<>();
        Medlem medlem1 = new Medlem("Børge",LocalDate.parse("2010-04-12"),true,1000);
        Medlem medlem2 = new Medlem("Hans",LocalDate.parse("1980-04-12"),true,1600);
        Medlem medlem3 = new Medlem("Line",LocalDate.parse("1940-04-12"),true,1200);
        Medlem medlem4 = new Medlem("Louise",LocalDate.parse("1990-04-12"),true,1600);
        Medlem medlem5 = new Medlem("Godzilla",LocalDate.parse("1945-04-12"),false,500);
        medlems.add(medlem1);
        medlems.add(medlem2);
        medlems.add(medlem3);
        medlems.add(medlem4);
        medlems.add(medlem5);
        Lars.setMedlemsListe(medlems);
        //act
        double actualValue = Lars.beregnKontingentForAlleMedlemmer();
        //assert
        assertEquals(5900, actualValue);

    }
}
package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KassererTest {

    @Test
    void beregnKontingentForEtMedlem() {
        //arrange
        Kasserer Lars = new Kasserer("Lars", "Lars");
        Medlem medlem1 = new Medlem("Børge",LocalDate.parse("2000-04-12"),true,1000);
        //act
        double actualValue = Lars.beregnKontingentForEtMedlem(medlem1);
        //assert
        assertEquals(1600, actualValue);

    }
}
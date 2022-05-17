package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KassererTest {

    @Test
    void beregnKontingentForAlleMedlemmer() {
        //arrange
        Kasserer Lars = new Kasserer("Lars", "Lars");
        //act
        double actualValue = Lars.beregnKontingentForAlleMedlemmer();
        //assert
        assertEquals(10700, actualValue);

    }
}
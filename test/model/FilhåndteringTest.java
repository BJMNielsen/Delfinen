package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FilhåndteringTest {

    ArrayList<Medlem> medlemsliste;

    @BeforeEach
    public void setup() {
        medlemsliste = new ArrayList<>();
        Medlem m1 = new Medlem("Hans", LocalDate.parse("2014-10-01"), true, 0);
        Medlem m2 = new Medlem( "Lars", LocalDate.parse("1995-09-09"), false, 0);
        Medlem m3 = new Medlem( "Norman", LocalDate.parse("2009-03-25"), false, 0);
        Medlem m4 = new Medlem( "Helle", LocalDate.parse("1993-04-15"), true, 0);
        medlemsliste.addAll(Arrays.asList(m1, m2, m3, m4));
    }

    @Test
    void saveMedlemsliste() throws FileNotFoundException {
        //Arrange
        Filhåndtering f1 = new Filhåndtering();

        //Act

        f1.saveMedlemsliste(medlemsliste);

        //Assert

    }

    @Test
    void loadMedlemsliste() {
    }

    @Test
    void saveAnsatLoginListe() {
    }

    @Test
    void loadAnsatLoginListe() {
    }
}
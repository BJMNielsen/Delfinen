import controller.SystemController;
import model.Ansat;
import model.Formand;
import model.Medlem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        new SystemController().start();
        /*
        LocalDate enDato = LocalDate.now();
        Medlem etMedlem = new Medlem("Hans", enDato, true, false);
        ArrayList<Medlem> medlemsListe = new ArrayList<>();
        medlemsListe.add(etMedlem);
        Ansat.setMedlemsListe(medlemsListe);
        Formand enFormand = new Formand();


         */
    }
}

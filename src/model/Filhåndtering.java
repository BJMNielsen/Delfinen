package model;

import enums.Disciplin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Filhåndtering {
    File medlemslisteFil;
    File ansatlisteFil;

    public Filhåndtering() {
        medlemslisteFil = new File("medlemslisteFil.csv");
        ansatlisteFil = new File("ansatlisteFil.csv");
    }

    public void saveMedlemsliste(ArrayList<Medlem> medlemsliste) throws FileNotFoundException {
        PrintStream saveFile = new PrintStream(medlemslisteFil);
        if (medlemsliste.size() > 0) {
            saveFile.println(Medlem.getStaticMedlemsnummer());
        }
        for (int i = 0; i < medlemsliste.size(); i++) {
            saveFile.println(medlemsliste.get(i));
        }
    }

    public ArrayList<Medlem> loadMedlemsliste() throws FileNotFoundException{
        ArrayList<Medlem> medlemsliste = new ArrayList<>();
        Scanner input = new Scanner(medlemslisteFil);
        boolean isFirstLine = true;
        while(input.hasNextLine()) {
            if (isFirstLine) {
                Scanner firstLine = scanIn(input.nextLine());
                int staticmedlemsNummer = firstLine.nextInt();
                Medlem.setStaticMedlemsnummer(staticmedlemsNummer);
                isFirstLine = false;
            }
            String nextLine = input.nextLine();
            Scanner input2 = scanIn(nextLine);
            Medlem etMedlem = createMedlem(input2);
            if(input2.hasNext()) {
                KonkurrenceSvømmer enKonkurrenceSvømmer = createKonkurrenceSvømmer(input2, etMedlem);
                medlemsliste.add(enKonkurrenceSvømmer);
            } else {
                medlemsliste.add(etMedlem);
            }
        }

         return medlemsliste;
    }

    public Medlem createMedlem(Scanner input2) {
        String name = input2.next();
        LocalDate birthdate = createDate(input2);
        boolean erAktiv = input2.nextBoolean();
        double kontingentBalance = input2.nextDouble();
        int medlemsnummer = input2.nextInt();
        return new Medlem(name, birthdate, erAktiv, kontingentBalance, medlemsnummer);
    }

    public Formand createFormand(Scanner input2){
        String brugerLogin = input2.next();
        String password = input2.next();
        return new Formand(brugerLogin,password);
    }
    public Kasserer createKassere(Scanner input2){
        String brugerLogin = input2.next();
        String password = input2.next();
        return new Kasserer(brugerLogin,password);
    }
    public Træner createTræner(Scanner input2){
        String brugerLogin = input2.next();
        String password = input2.next();
        int trænerID = input2.nextInt();
        return new Træner(brugerLogin,password,trænerID);
    }

    public LocalDate createDate(Scanner input2) {
        int year = input2.nextInt();
        int month = input2.nextInt();
        int day = input2.nextInt();
        return LocalDate.of(year, month, day);
    }

    public KonkurrenceSvømmer createKonkurrenceSvømmer(Scanner input2, Medlem medlem) {
        int trænerID = input2.nextInt();
        Svømmedisciplin butterfly = createSvømmedisciplin(input2);
        Svømmedisciplin crawl = createSvømmedisciplin(input2);
        Svømmedisciplin rygcrawl = createSvømmedisciplin(input2);
        Svømmedisciplin brystsvømning = createSvømmedisciplin(input2);
        return new KonkurrenceSvømmer(medlem, trænerID, butterfly, crawl, rygcrawl, brystsvømning);
    }

    public Svømmedisciplin createSvømmedisciplin(Scanner input2) {
        boolean erAktiv = input2.nextBoolean();
        Disciplin disciplin = Disciplin.valueOf(input2.next());
        double bedsteTræningstidISekunder = input2.nextDouble();
        if (bedsteTræningstidISekunder <= 0) {
            return new Svømmedisciplin(erAktiv, disciplin);
        }
        LocalDate datoForBedsteTid = createDate(input2);
        return new Svømmedisciplin(erAktiv, disciplin, bedsteTræningstidISekunder,datoForBedsteTid);
    }

    public void saveAnsatLoginListe(ArrayList<Ansat> ansatListe) throws FileNotFoundException{
        PrintStream saveFile = new PrintStream(ansatlisteFil);
        if (ansatListe.size() < 1) {
            ansatListe = createDefaultAnsatListe();
        }
        boolean erDenFørsteInstanceAfEnTræner = true;
        for (Ansat enAnsat: ansatListe) {
            if(enAnsat instanceof Træner && erDenFørsteInstanceAfEnTræner) {
                saveFile.println(Træner.getStaticTrænerID());
                erDenFørsteInstanceAfEnTræner = false;
            } saveFile.println(enAnsat);
        }
    }

    public ArrayList<Ansat> loadAnsatLoginListe() throws FileNotFoundException {
        ArrayList<Ansat> ansatListe = new ArrayList<>();
        Scanner input = new Scanner(ansatlisteFil);
        if (input.hasNextLine()) {
            String nextLine = input.nextLine();
            Scanner input2 = scanIn(nextLine);
            Formand enFormand = createFormand(input2);
            ansatListe.add(enFormand);
            nextLine = input.nextLine();
            input2 = scanIn(nextLine);
            Kasserer enKassere = createKassere(input2);
            ansatListe.add(enKassere);

            if (input.hasNextLine()) {
                nextLine = input.nextLine();
                input2 = scanIn(nextLine);
                int staticTrænerID = input2.nextInt();
                Træner.setStaticTrænerID(staticTrænerID);

                while(input.hasNextLine()) {
                    nextLine = input.nextLine();
                    input2 = scanIn(nextLine);
                    Træner enTræner = createTræner(input2);
                    ansatListe.add(enTræner);
                }
            }
        } else {
            ansatListe = createDefaultAnsatListe();
        }
        return ansatListe;
    }

    public ArrayList<Ansat> createDefaultAnsatListe() {
        ArrayList<Ansat> defaultAnsatListe = new ArrayList<>();
        defaultAnsatListe.add(new Formand());
        defaultAnsatListe.add(new Kasserer());
        defaultAnsatListe.add(new Træner());
        return defaultAnsatListe;
    }


    public Scanner scanIn(String nextLine) {
        return new Scanner(nextLine).useDelimiter(";").useLocale(Locale.ENGLISH);
    }

}

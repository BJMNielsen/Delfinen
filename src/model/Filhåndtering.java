package model;

import enums.Disciplin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Filhåndtering {
    File medlemslisteFil;
    File ansatlisteFil;

    Filhåndtering() {
        medlemslisteFil = new File("medlemslisteFil.csv");
        ansatlisteFil = new File("ansatlisteFil.csv");
    }

    public void saveMedlemsliste(ArrayList<Medlem> medlemsliste) throws FileNotFoundException {
        PrintStream saveFile = new PrintStream(medlemslisteFil);
        for (int i = 0; i < medlemsliste.size(); i++) {
            saveFile.println(medlemsliste.get(i));
        }
    }

    public ArrayList<Medlem> loadMedlemsliste() throws FileNotFoundException{
        ArrayList<Medlem> medlemsliste = new ArrayList<>();
        Scanner input = new Scanner(medlemslisteFil);
        while(input.hasNextLine()) {
            String medlemsinfo = input.nextLine();
            Scanner input2 = new Scanner(medlemsinfo).useDelimiter(";").useLocale(Locale.ENGLISH);
            Medlem etMedlem = createMedlem(input2);
            if(input2.hasNext()) {
                KonkurrenceSvømmer enKonkurrenceSvømmer = createKonkurrenceSvømmer(input2, etMedlem);
                medlemsliste.add(enKonkurrenceSvømmer);
            } else {
                medlemsliste.add(etMedlem);
            }
        } return medlemsliste;
    }

    public Medlem createMedlem(Scanner input2) {
        int medlemsnummer = input2.nextInt();
        String name = input2.next();
        LocalDate birthdate = createDate(input2);
        boolean erAktiv = input2.nextBoolean();
        double konto = input2.nextDouble();
        return new Medlem(medlemsnummer, name, birthdate, erAktiv, konto);
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
        int birthYear = input2.nextInt();
        int birthMonth = input2.nextInt();
        int birthDay = input2.nextInt();
        return LocalDate.of(birthYear, birthMonth, birthDay);
    }

    public KonkurrenceSvømmer createKonkurrenceSvømmer(Scanner input2, Medlem medlem) {
        int trænerID = input2.nextInt();
        Svømmedisciplin butterfly = createSvømmedisciplin(input2);
        Svømmedisciplin crawl = createSvømmedisciplin(input2);
        Svømmedisciplin rygcrawl = createSvømmedisciplin(input2);
        Svømmedisciplin brystsvømning = createSvømmedisciplin(input2);
        ArrayList<Svømmedisciplin> listeAfSvømmediscipliner = new ArrayList<>();
        listeAfSvømmediscipliner.addAll(Arrays.asList(butterfly,crawl,rygcrawl,brystsvømning));
        return new KonkurrenceSvømmer(medlem, trænerID, listeAfSvømmediscipliner);
    }

    public Svømmedisciplin createSvømmedisciplin(Scanner input2) {
        boolean erAktiv = input2.nextBoolean();
        Disciplin disciplin = Disciplin.valueOf(input2.next());
        double bedsteTræningstidISekunder = input2.nextDouble();
        LocalDate datoForBedsteTid = createDate(input2);
        return new Svømmedisciplin(erAktiv, disciplin, bedsteTræningstidISekunder,datoForBedsteTid);
    }

    public void saveAnsatLoginListe(ArrayList<Ansat> ansatListe) throws FileNotFoundException{
        PrintStream saveFile = new PrintStream(ansatlisteFil);
        for (int i = 0; i < ansatListe.size(); i++) {
            saveFile.println(ansatListe.get(i));
        }
    }

    public ArrayList<Ansat> loadAnsatLoginListe() throws FileNotFoundException {
        ArrayList<Ansat> ansatListe = new ArrayList<>();
        Scanner input = new Scanner(ansatlisteFil);
        if (input.hasNextLine()) {
            Scanner input2 = scanIn(input);
            Formand enFormand = createFormand(input2);
            ansatListe.add(enFormand);
            input2 = scanIn(input);
            Kasserer enKassere = createKassere(input2);
            ansatListe.add(enKassere);

            if (input.hasNextLine()) {
                input2 = scanIn(input);
                int staticTrænerID = input2.nextInt();
                Træner.setStaticTrænerID(staticTrænerID);

                while(input.hasNextLine()) {
                    input2 = scanIn(input);
                    Træner enTræner = createTræner(input2);
                    ansatListe.add(enTræner);
                }
            }
        }
        return ansatListe;
    }


    public Scanner scanIn(Scanner input) {
        String nextLine = input.nextLine();
        return new Scanner(nextLine).useDelimiter(";").useLocale(Locale.ENGLISH);
    }

}

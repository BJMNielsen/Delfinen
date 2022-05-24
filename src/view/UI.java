package view;

import model.KonkurrenceSvømmer;
import model.Medlem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UI {
    private final Scanner stringInput = new Scanner(System.in);
    private final Scanner intInput = new Scanner(System.in);
    private final Scanner doubleInput = new Scanner(System.in);
    private final Scanner booleanInput = new Scanner(System.in);


        //General UI
        public int getIntInput() {
            try{
                return intInput.nextInt();
            } catch (Exception e){
                System.out.println("Invalid input");
                intInput.nextLine();
                return getIntInput();
            }
        }

        public double getDoubleInput() {
            try {
                return doubleInput.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input");
                doubleInput.nextLine();
                return getDoubleInput();
            }
        }

        public String getStringInput() {
            return stringInput.nextLine();
        }
        public boolean getBooleanInput() {
            try{
                return booleanInput.nextBoolean();
            } catch (Exception e){
                System.out.println("Invalid input. Du skal skrive true eller false.");
                booleanInput.nextLine();
                return getBooleanInput();
            }
        }

    //General UI
    public void inputIsInvalid(int helTal){
        System.out.println("dit input '" + helTal + "' er invalid.");
    }


    public void inputIsInvalid(String tekst){
        System.out.println("dit input '" + tekst + "' er invalid.");
    }

    public void inputIsInvalid(double kommaTal){
        System.out.println("dit input '" + kommaTal + "' er invalid.");
    }

    public void detVarForketInput(String forkert) {
        System.out.println("Der var ingen " + forkert + '.');
    }


    public boolean askUserYesOrNo(){
           // boolean isRunning = true;
            while(true) {
                System.out.print("Indtast ja eller nej ");
                String userAnswer = getStringInput().toLowerCase(Locale.ROOT);
                switch (userAnswer){
                    case "ja":
                        return true;

                    case "nej":
                        return false;

                    default:
                        System.out.println("Du indtastede ikke et ja eller nej");
                }
            }
    }

    public void typeHere(){
        System.out.print("Indtast dit valg her: ");
    }

    public void ansatMenuWelcomeMessage(String brugerNavn) {
        System.out.println("Velkommen " + brugerNavn + ".\n");
    }

    //Bliver kun brugt i SystemController klassen
    public void welcomeMessage() {
        System.out.println("""
                
                Velkommen til Delfinprogrammet.
                
                Vil du logge ind eller lukke programmet ned?
                
                1) Login
                0) exit program
                """);
    }


    //Bliver kun brugt i SystemController klassen
    public void exitProgramMessage() {
        System.out.println("Programmet lukker nu");
    }


    //Bliver kun brugt i SystemController klassen
    public void filesWereSavedSuccesfully(){
        System.out.println("Programmet gemmer medlems- og ansatlisten i hver deres fil.");
        System.out.println("Tak fordi du benytter Delfin programmet.");
    }



    //Bliver kun brugt i SystemController klassen
    public void indtastBrugernavn() {
        System.out.print("Indtast dit brugernavn: ");
    }

    public void indtastPassword() {
        System.out.print("Indtast dit password: ");
    }

    public void korrektBrugerNavn(){
        System.out.println("Brugernavnet er korrekt.");
    }

    public void korrektPassword(){
        System.out.println("Password er korrekt.");
    }

    public void forkertBrugerNavn(){
        System.out.println("Du har indtastet et forkert brugernavn.");
    }

    public void forkertPassword(){
        System.out.println("Du har indtastet et forkert password.");
    }



    //Kasserer UI
    public void kassererMenu() {
        System.out.println("""
                Menu Kasserer
                
                1) Vis medlemsliste
                2) Vis medlemmer i restance
                3) Vis forventede kontingent indbetaling for året
                0) Log ud
                
                """);
    }

    //Formand UI
    public void formandMenu() {
        System.out.println("""
                Menu Formand
                
                1) Vis medlemsliste
                2) Opret medlem
                3) Fjern medlem
                4) Opgrader medlem til konkurrencesvømmer
                0) Log ud
                
                """);
    }

    public void printKonkurrenceSvømmerListe(ArrayList<KonkurrenceSvømmer> KonkurrencesvømmerListe) {
        System.out.println("Konkurrence:\n");
        for (KonkurrenceSvømmer enKonkurrenceSvømmer: KonkurrencesvømmerListe) {
            int medlemsnummer = enKonkurrenceSvømmer.getMedlemsnummer();
            String navn = enKonkurrenceSvømmer.getNavn();
            String fødselsdato = enKonkurrenceSvømmer.getFødselsdatoSomTekst();
            String aktivitet = enKonkurrenceSvømmer.getErAktivSomTekst();
            double kontingentBalance = enKonkurrenceSvømmer.getKontingentBalance();
            System.out.println("Nr. " + medlemsnummer + " " + navn + " " + fødselsdato + " " + aktivitet + ", balance: " + kontingentBalance + " kr.");
        }
        System.out.println('\n');
    }

    public void printMedlemsliste(ArrayList<Medlem> medlemsliste) {
        System.out.println("MEDLEMSLISTE:\n");
        for (Medlem etMedlem: medlemsliste) {
            int medlemsnummer = etMedlem.getMedlemsnummer();
            String navn = etMedlem.getNavn();
            String fødselsdato = etMedlem.getFødselsdatoSomTekst();
            String aktivitet = etMedlem.getErAktivSomTekst();
            double kontingentBalance = etMedlem.getKontingentBalance();
            System.out.println("Nr. " + medlemsnummer + " " + navn + " " + fødselsdato + " " + aktivitet + ", balance: " + kontingentBalance + " kr.");
        }
        System.out.println('\n');
    }

    public void askForMedlemInfo(String tekst){
        System.out.println("Hvad er medlemmmets " + tekst + "?");
    }


    //Træner UI
    public void trænerMenu() {
        System.out.println("""
                Menu Træner
                
                1) Vis medlemsliste
                2) Vis konkurrencesvømmerer
                3) Vis top 5 svømmerer i en disciplin
                0) Log ud
                
                """);
    }

    public void vælgDisciplinMenu() {
        System.out.println("""
            1) Sorter efter de 5 bedste i BUTTERFLY.
            2) Sorter efter de 5 bedste i CRAWL.
            3) Sorter efter de 5 bedste i RYGCRAWL.
            4) Sorter efter de 5 bedste i BRYSTSVØMNING.""");
    }



    public void printTop5Listen(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmererSorteretEfterDisciplin, String hold, String disciplin) {
        System.out.println("TOP 5 LISTEN - " + hold.toUpperCase() + " - " + disciplin.toUpperCase() + '\n');
        for (int i = 0; i < 4; i++) {
            System.out.println(konkurrenceSvømmererSorteretEfterDisciplin.get(i));
        }
        System.out.println();
    }


    public void printKonkurrenceSvømmer(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmerListe) {
        System.out.println("KONKURRENCESVØMMERLISTE:\n");
        for (KonkurrenceSvømmer enKonkurrenceSvømmer: konkurrenceSvømmerListe) {
            int medlemsnummer = enKonkurrenceSvømmer.getMedlemsnummer();
            String navn = enKonkurrenceSvømmer.getNavn();
            String fødselsdato = enKonkurrenceSvømmer.getFødselsdatoSomTekst();
            String aktivitet = enKonkurrenceSvømmer.getErAktivSomTekst();
            double kontingentBalance = enKonkurrenceSvømmer.getKontingentBalance();
            
            int trænerID = enKonkurrenceSvømmer.getTrænerID();
            String disciplinAktiv = enKonkurrenceSvømmer.getRygcrawl().getErAktivSomTekst();
            String disciplin = String.valueOf(enKonkurrenceSvømmer.getRygcrawl().getDisciplin());
            double bedsteTræningsTid = enKonkurrenceSvømmer.getRygcrawl().getBedsteTræningsTidISek();
            String datoForBedsteTid = enKonkurrenceSvømmer.getRygcrawl().getDatoForBedsteTidFormateret();
            
            
            System.out.println("Nr. " + medlemsnummer + " " + navn + " " + fødselsdato + " " + aktivitet + ", balance: " + kontingentBalance + " kr." 
                    + " " + trænerID + " " + disciplinAktiv + " " + disciplin + " " + bedsteTræningsTid + " " + datoForBedsteTid);
        }
        System.out.println('\n');
    }

}


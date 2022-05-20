package view;

import java.util.Scanner;

public class UI {
    private final Scanner stringInput = new Scanner(System.in);
    private final Scanner intInput = new Scanner(System.in);


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

        public String getStringInput() {
            return stringInput.nextLine();
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

    public void typeHere(){
        System.out.print("type here: ");
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
                4) Opgrader medlem til konkurrencesvømmer TODO lav metode metode
                0) Log ud
                
                """);
    }


    //Træner UI
    public void trænerMenu() {
        System.out.println("""
                Menu Træner
                
                1) Vis medlemsliste
                2) Vis top 5
                3) Tilføj konkurrence information
                0) Log ud
                
                """);
    }



}

package view;

import java.util.Scanner;

public class UI {
    private final Scanner stringInput = new Scanner(System.in);
    private final Scanner intInput = new Scanner(System.in);


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


    public void welcomeMessage() {
        System.out.println("Velkommen til Delfinprogrammet. Vil du logge ind eller lukke programmet ned?");
    }

    public void login() {
        // skal spørge om brugernavn i en linje
        // og password i næste linje
    }

    public void invalidLoginInformation() {
        // Hvis brugeren indtaster forkert info så skal den bede dem indtaste igen.
    }

    public void kassererMenu() {
        // Menu til kasserer. Skal indeholde
        // 1) Vis medlemsliste
        // 2) Vis medlemmer i restance
        // 3) Vis forventede kontingent indbetaling for året
        // 4) Log ud
    }

    public void formandMenu() {
        // Menu til formand. Skal indeholde
        // 1) Vis medlemsliste
        // 2) Opret medlem
        // 3) Fjern medlem
        // 4) Log ud
    }

    public void trænerMenu() {
        // Menu til formand. Skal indeholde
        // 1) Vis medlemsliste
        // 2) Vis top 5
        // 3) Tilføj konkurrence information
        // 3) Log ud
    }

    public void visSvømmeDiscipliner() {
        // 1) Brystsvømning
        // 2) Crawl... osv
        //Skal bruges i træner metoden.
    }

    public void indtastNoget(String noget) {
        System.out.print("Indtast " + noget + ": ");
    }

}

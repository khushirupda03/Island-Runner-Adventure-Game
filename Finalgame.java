import java.util.Scanner;
import java.util.Random;

public class Finalgame {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static int health;
    static int coins;
    static String name;

    public static void main(String[] args) throws InterruptedException {

        int playAgain = 1;

        while (playAgain == 1) {

            health = 100;
            coins = 0;

            startGame();
            level1();
            caveScene();
            ending();

            System.out.println("\nWanna suffer again? ");
            System.out.println("1 = Yes  | 0 = No ");
            playAgain = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("\nThanks for playing... or surviving... whatever ");
    }

    static void slowPrint(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(30);
        }
        System.out.println();
    }

    static void startGame() throws InterruptedException {
        slowPrint(" Welcome to Island Runner...");
        Thread.sleep(500);

        System.out.print("Enter your name: ");
        name = sc.nextLine();
    
        slowPrint("\nHey " + name + " ... you wake up on a mysterious island...");
        Thread.sleep(800);
        slowPrint("No WiFi. No food. Just bad decisions waiting to happen ");
    }

    static void level1() throws InterruptedException {

        System.out.println("\n---------------------------");
        System.out.println("Choose your path:");
        System.out.println("1. Jungle  (Risky)");
        System.out.println("2. River  (Balanced)");
        System.out.println("---------------------------");

        int choice = sc.nextInt();

        if (choice == 1) {
            junglePath();
        } else if (choice == 2) {
            riverPath();
        } else {
            slowPrint("Invalid choice... wow great start ");
        }
    }

    static void junglePath() throws InterruptedException {

        slowPrint("\nYou walk into the jungle...");
        Thread.sleep(700);
        slowPrint("The bushes start shaking...");
        Thread.sleep(700);
        slowPrint("Something is watching you ");

        System.out.println("\n1. Fight (Brave or stupid?)");
        System.out.println("2. Hide  (Coward but alive)");

        int choice = sc.nextInt();

        if (choice == 1) {
            int damage = rand.nextInt(30);
            health -= damage;
            slowPrint("You fought like a hero... or at least tried ");
            slowPrint("Lost " + damage + " health ");
            coins += 20;
            slowPrint("You found coins  (worth it? maybe)");
        } else {
            slowPrint("You hid behind a bush...");
            slowPrint("Congratulations, you survived by doing NOTHING ");
        }
    }

    static void riverPath() throws InterruptedException {

        slowPrint("\nYou reach a river...");
        Thread.sleep(700);
        slowPrint("Looks peaceful...");
        Thread.sleep(700);
        slowPrint("It's not ");

        System.out.println("\n1. Swim  (Bad idea)");
        System.out.println("2. Build raft  (Use brain for once)");

        int choice = sc.nextInt();

        if (choice == 1) {
            int damage = rand.nextInt(40);
            health -= damage;
            slowPrint("The current said 'NOPE' ");
            slowPrint("Lost " + damage + " health ");
        } else {
            slowPrint("You built a raft like a genius ");
            coins += 30;
            slowPrint("Earned coins ");
        }
    }

    static void caveScene() throws InterruptedException {

        slowPrint("\nAfter surviving somehow...");
        Thread.sleep(700);
        slowPrint("You find a creepy cave");

        System.out.println("\n1. Enter cave ");
        System.out.println("2. Stay outside ");

        int choice = sc.nextInt();

        if (choice == 1) {
            slowPrint("You enter the cave...");
            Thread.sleep(700);

            int event = rand.nextInt(2);

            if (event == 0) {
                slowPrint("OMG TREASURE ");
                coins += 50;
            } else {
                int damage = rand.nextInt(50);
                health -= damage; 
                slowPrint("It was a trap ");
                slowPrint("Lost " + damage + " health ");
                slowPrint("You really thought it was that easy? ");
            }

        } else {
            slowPrint("You stayed outside...");
            slowPrint("Nothing happened... how exciting ");
        }
    }

    static void ending() throws InterruptedException {

        slowPrint("\nYou finally see a rescue boat .");
        Thread.sleep(800);

        System.out.println("\n FINAL STATS:");
        System.out.println("Health : " + health);
        System.out.println("Coins : " + coins);

        if (health > 70) {
            slowPrint("\n You escaped like a legend!");
        } else if (health > 30) {
            slowPrint("\n You survived... barely.");
        } else {
            slowPrint("\n You collapsed before reaching the boat...");
            slowPrint("Better luck next life ");
        }
    }
}
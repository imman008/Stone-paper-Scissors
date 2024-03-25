import java.util.*;
public class Solution{
    public enum Choice {STONE, PAPER, SCISSORS}

    public static void Choices() {
        System.out.println("Choose your move:");
        System.out.println("1. Stone");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
    }

    public static Choice User_Choice(Scanner scanner) {
        int choice;
        System.out.print("Enter your choice (1/2/3): ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return Choice.STONE;
            case 2:
                return Choice.PAPER;
            case 3:
                return Choice.SCISSORS;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                return User_Choice(scanner);
        }
    }

    public static Choice Computer_Choice() {
        int choice = (int) (Math.random() * 3);
        switch (choice) {
            case 0:
                return Choice.STONE;
            case 1:
                return Choice.PAPER;
            default:
                return Choice.SCISSORS;
        }
    }

    public static void print_Choice(Choice choice) {
        switch (choice) {
            case STONE:
                System.out.println("Stone");
                break;
            case PAPER:
                System.out.println("Paper");
                break;
            case SCISSORS:
                System.out.println("Scissors");
                break;
        }
    }

    public static void Gameplay(Scanner scanner) {
        printChoices();
        Choice userChoice = getUserChoice(scanner);
        Choice computerChoice = getComputerChoice();

        System.out.print("You chose: ");
        printChoice(userChoice);

        System.out.print("Computer chose: ");
        printChoice(computerChoice);

        if (userChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if ((userChoice == Choice.STONE && computerChoice == Choice.SCISSORS) ||
                   (userChoice == Choice.PAPER && computerChoice == Choice.STONE) ||
                   (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;
        do {
            Gameplay(scanner);
            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');
        scanner.close();
    }
}

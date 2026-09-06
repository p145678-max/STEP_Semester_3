import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove(Random random) {
        int number = random.nextInt(3);

        if (number == 0) {
            return "Rock";
        } else if (number == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper or Scissors: ");
            playerMoves[i] = sc.next();

            computerMoves[i] = getComputerMove(random);
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Player: " + playerMoves[i]
                    + " | Computer: " + computerMoves[i]
                    + " | Result: " + results[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nFinal Summary");
        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " | " + playerMoves[i]
                    + " | " + computerMoves[i] + " | " + results[i]);
        }

        double winPercentage = (wins * 100.0) / 5;

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win % = " + winPercentage + "%");
    }
}

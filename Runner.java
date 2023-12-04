import java.util.Scanner;

public class Runner {
  private static String playerName;
  private static Scanner scan;

  public static void pvp() {
    System.out.println("Hello Player 1!");
    System.out.println("Enter your name:");
    playerName = scan.nextLine();
    Player player1 = new Player(playerName);

    System.out.println();
    System.out.println("Hello Player 2!");
    System.out.println("Enter your name:");
    playerName = scan.nextLine();
    Player player2 = new Player(playerName);

    // start nim game with 20 sticks
    NimGame nimGame = new NimGame(20);
    Player[] players = { player1, player2 };
    int currPlayerIdx = 0;

    System.out.println();
    System.out.println("You have twenty sticks.");
    boolean gameOver = false;
    while (!gameOver) {
      System.out.println();
      int sticksRemaining = nimGame.getSticks();
      System.out.println("Sticks remaining: " + sticksRemaining);
      System.out.println(players[currPlayerIdx].name + ", how many sticks would you like to remove?");
      int numSticks = scan.nextInt();
      if (numSticks > sticksRemaining / 2 && numSticks != 1) {
        System.out.println("Sorry, please enter a number lower than " + sticksRemaining / 2);
        continue;
      } else {
        nimGame.takeSticks(numSticks);
      }

      gameOver = nimGame.checkWin();
      currPlayerIdx = (currPlayerIdx + 1) % (players.length);
    }
    System.out.println("Game over!");
    System.out.println("Loser: " + players[currPlayerIdx].name);

  }

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    pvp();
  }

}

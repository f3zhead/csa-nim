import java.util.Scanner;

public class Runner {
  private static String playerName;
  private static Scanner scan;

  public static Player[] pvp(NimGame game) {
    System.out.println("Hello Player 1!");
    System.out.println("Enter your name:");
    playerName = scan.nextLine();
    Player player1 = new Player(game, playerName);

    System.out.println();
    System.out.println("Hello Player 2!");
    System.out.println("Enter your name:");
    playerName = scan.nextLine();
    Player player2 = new Player(game, playerName);
    Player[] players = { player1, player2 };
    return players;

  }

  public static Player[] ai(NimGame game) {
    System.out.println("Hello Player!");
    System.out.println("Enter your name:");
    playerName = scan.nextLine();
    Player player1 = new Player(game, playerName);

    Player player2 = new AIPlayer(game);
    Player[] players = { player1, player2 };
    return players;

  }

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    NimGame nimGame = new NimGame(20);
    Player[] players;
    System.out.println("Welcome to NIM!");
    System.out.println("Do you want to play against another player (type human) or against the AI? (type ai)");
    String response = scan.nextLine();
    if (response.equals("human")) {
      players = pvp(nimGame);
    } else {
      players = ai(nimGame);
    }

    // start nim game with 20 sticks
    int currPlayerIdx = 0;

    System.out.println();
    System.out.println("You have twenty sticks.");
    boolean gameOver = false;
    while (!gameOver) {
      System.out.println();
      int sticksRemaining = nimGame.getSticks();

      System.out.println("Current player: " + players[currPlayerIdx].name);

      players[currPlayerIdx].takeSticks();
      sticksRemaining = nimGame.getSticks();
      System.out.println("Sticks remaining: " + sticksRemaining);

      gameOver = nimGame.checkWin();
      currPlayerIdx = (currPlayerIdx + 1) % (players.length);
    }
    System.out.println("Game over!");
    System.out.println("Loser: " + players[currPlayerIdx].name);
  }

}

import java.util.Scanner;

public class Player {
  public final String name;
  private NimGame game;

  public Player(NimGame game, String name) {
    this.name = name;
    this.game = game;
  }

  public void takeSticks() {
    Scanner scan = new Scanner(System.in);
    int sticksRemaining = nimGame.getSticks();

    boolean successful = false;
    while (!successful) {
      System.out.println("Sticks remaining: " + sticksRemaining);
      System.out.println("Please enter a number lower than " + sticksRemaining / 2);
      System.out.println(name + ", how many sticks would you like to remove?");
      int numSticks = scan.nextInt();
      successful = nimGame.takeSticks(numSticks);
    }

  }

}

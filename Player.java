import java.util.Scanner;

public class Player {
  public final String name;
  protected NimGame game;

  public Player(NimGame game, String name) {
    this.name = name;
    this.game = game;
  }

  public void takeSticks() {
    Scanner scan = new Scanner(System.in);
    int sticksRemaining = game.getSticks();

    boolean successful = false;
    while (!successful) {
      System.out.println("Sticks remaining: " + sticksRemaining);
      int stickAllowed = sticksRemaining / 2 == 0 ? sticksRemaining / 2 : 1;
      System.out.println("Please enter a number less than or equal to" + sticksAllowed);
      System.out.println(name + ", how many sticks would you like to remove?");
      int numSticks = scan.nextInt();
      successful = game.takeSticks(numSticks);
    }

  }

}

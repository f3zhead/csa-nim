public class AIPlayer extends Player {
  public AIPlayer(NimGame game) {
    super(game, "AI Player");
  }

  static boolean hasWinningStrategy(int number) {
    int numba = number + 1;
    return !((numba & -numba) == numba);
  }

  public void takeSticks() {
    int sticksRemaining = nimGame.getSticks();

  }
}

public class AIPlayer extends Player {
  public AIPlayer(NimGame game) {
    super(game, "AI Player");
  }

  static boolean hasWinningStrategy(int number) {
    int numba = number + 1;
    return !((numba & -numba) == numba);
  }

  public void takeSticks() {
    int sticksToTake = 0;
    int sticksRemaining = this.game.getSticks();
    if (sticksRemaining == 1) {
      sticksToTake = 1;
    } else {
      boolean isAssured = false;
      for (int i = sticksRemaining / 2; i >= 1; i--) {
        if (hasWinningStrategy(sticksRemaining - i)) {
          continue;
        } else {
          sticksToTake = i;
          isAssured = true;
          break;
        }
      }
      if (!isAssured) {
        sticksToTake = 1;
      }
    }
    System.out.println("AI Player takes " + sticksToTake + " stick(s).");
    game.takeSticks(sticksToTake);
  }
}

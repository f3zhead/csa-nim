public class NimGame {
  private int sticks;

  public NimGame(int sticks) {
    this.sticks = sticks;
  }

  public int getSticks() {
    return sticks;
  }

  public boolean takeSticks(int numSticks) {
    if (numSticks <= sticks / 2 || numSticks == 1) {
      this.sticks -= numSticks;
      return true;
    }
    return false;
  }

  public boolean checkWin() {
    return this.sticks == 0;
  }
}

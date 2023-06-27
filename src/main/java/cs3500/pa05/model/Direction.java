package cs3500.pa05.model;

/**
 * represents directions for a GUI layout
 */
public enum Direction {
  HORIZONTAL("horizontal"),
  VERTICAL("vertical");

  private String dir;
  Direction(String dir) {
    this.dir = dir;
  }

  public static String flip(String d) {
    if (d.equals(HORIZONTAL.dir)) {
      return VERTICAL.dir;
    } else {
      return HORIZONTAL.dir;
    }
  }
}
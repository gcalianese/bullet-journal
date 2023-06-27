package cs3500.pa05.controller;

import cs3500.pa05.model.BujoReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static cs3500.pa05.model.Direction.flip;

/**
 * to handle switching bujo view layout
 */
public class LayoutButtonHandler implements EventHandler {
  private final Stage stage;
  private final BujoController controller;
  private static final String layoutMD = "src/main/resources/layout.md";

  /**
   * Creates a LayoutButtonHandler object
   *
   * @param stage to display information
   * @param controller to handle state changes
   */
  public LayoutButtonHandler(Stage stage, BujoController controller) {
    this.stage = stage;
    this.controller = controller;
  }

  /**
   * shows a choice box and sets the theme to the selection
   *
   * @param event the event which occurred
   */
  @Override
  public void handle(Event event) {
    try {
      BujoReader reader = new BujoReader();
      String layout = reader.read(new Scanner(new File(layoutMD)));
      FileWriter fw = new FileWriter(layoutMD);
      fw.write(flip(layout));
      fw.close();
      controller.start(stage);
      if (!controller.getCurrentFileName().equals("")) {
        controller.loadFromExisting(controller.getCurrentFileName());
      }
    } catch (IOException e) {
      throw new RuntimeException("couldn't write file");
    }
  }
}

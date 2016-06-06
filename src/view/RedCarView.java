package view;
import Player;
import javafx.scene.image.ImageView;

public class RedCarView extends ObjectView<Player> {
  ImageView frontPart;
  ImageView rearPart;

  public RedCarView() {
    frontPart = new ImageView("res/image/RedCarFrontPart.png");
    rearPart = new ImageView("res/image/RedCarRearPart.png");
  }

  public ImageView getRedCarFrontPart() {
    return frontPart;
  }

  public ImageView getRedCarRearPart() {
    return rearPart;
  }
}

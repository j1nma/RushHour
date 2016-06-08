package view;
import javafx.scene.image.ImageView;
import model.Player;

public class RedCarView extends ObjectView<Player> {
    ImageView frontPart;
    ImageView rearPart;

    //TODO: arreglar todo esto (No deberia ser un null, ustedes fijense como arreglarlo, me choca mucho el uso de generics en todo esto.)
    public RedCarView() {
        super(null);
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

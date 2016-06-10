package view;

//import javafx.pane.image.ImageView;
//import model.Block;
import model.Player;

public class RedCarView extends BlockView {
	// ImageView frontPart;
	// ImageView rearPart;

	// TODO: arreglar todo esto (No deberia ser un null, ustedes fijense como
	// arreglarlo, me choca mucho el uso de generics en todo esto.)
	public RedCarView(Player redCar, String front, String middle, String rear) {
		super(redCar, front, null, rear);
		
		// frontPart = new ImageView("res/image/RedCarFrontPart.png");
		// rearPart = new ImageView("res/image/RedCarRearPart.png");
	}

	// public ImageView getRedCarFrontPart() {
	// return frontPart;
	// }
	//
	// public ImageView getRedCarRearPart() {
	// return rearPart;
	// }

}

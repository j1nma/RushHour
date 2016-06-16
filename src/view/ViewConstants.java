package view;

import javafx.geometry.Insets;

public interface ViewConstants {
	int BACKGROUND_SIZE = 560;
	int BACKGROUND_GAUSSIAN_BLUR = 10;
	String BACKGROUND_PATH = "res/images/background.jpg";

	int FONT_SIZE_MENU = 30;
	int FONT_SIZE_EDITOR = 13;
	
	int INPUT_WIDTH = 75;
	int INPUT_HEIGHT = 10;
	
	int NODE_SEPARATION = 10;

	double BLOCKVIEW_HEIGHT = 60.0;
	double BLOCKVIEW_WIDTH = 60.0;
	
	Insets TOPBOX_PADDING = new Insets(15, 0, 15, 15);
	Insets BOTTOMBOX_PADDING = new Insets(0, 0, 5, 0);
	
	double BUTTON_OPACITY = 0.6;
	Insets BUTTON_PADDING = new Insets(10, 10, 10, 10);
	String BUTTON_STYLE_DEFAULT = "-fx-base: black;-fx-focus-color: transparent;";
	String BUTTON_STYLE_ENTERED = "-fx-base: white;-fx-focus-color: transparent;";
	
	String GAMEPANE_STYLE = "-fx-background-color: lightblue";

	int GRID_PADDING = 30;
	int GRID_SIZE = 560;
	int GRID_GAP = 0;
//	String GRID_STYLE = "-fx-background-repeat: no-repeat;";

	String PLAYER_FRONT_IMAGE_PATH = "res/images/PlayerFront.png";
	String PLAYER_MIDDLE_IMAGE_PATH = "res/images/PlayerMiddle.png";
	String PLAYER_REAR_IMAGE_PATH = "res/images/PlayerRear.png";

	int IMAGE_ROTATION = 90;

}

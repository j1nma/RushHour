package view;

public interface ViewConstants {
	int BACKGROUND_SIZE = 560;
	int BACKGROUND_GAUSSIAN_BLUR = 10;
	String BACKGROUND_PATH = "res/images/background.jpg";

	int FONT_SIZE = 30;
	int NODE_SEPARATION = 10;

	int BLOCKVIEW_HEIGHT = 70;
	int BLOCKVIEW_WIDTH = 85;

	double BUTTON_OPACITY = 0.6;
	String BUTTON_STYLE_DEFAULT = "-fx-base: black;-fx-focus-color: transparent;";
	String BUTTON_STYLE_ENTERED = "-fx-base: white;-fx-focus-color: transparent;";

	int GRID_PADDING = 30;
	int GRID_SIZE = 560;
	int GRID_GAP = -5;
	String GRID_STYLE = "-fx-background-image: url('res/images/boardBackground.png');"
			+ "-fx-background-repeat: no-repeat;"
			+ "-fx-background-size: 570 530;";

	String PLAYER_FRONT_IMAGE_PATH = "res/images/PlayerFront.png";
	String PLAYER_MIDDLE_IMAGE_PATH = "res/images/PlayerMiddle.png";
	String PLAYER_REAR_IMAGE_PATH = "res/images/PlayerRear.png";

	int IMAGE_ROTATION = 90;

}

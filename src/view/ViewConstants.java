package view;

import javafx.geometry.Insets;

public interface ViewConstants {
	int BACKGROUND_SIZE = 560;
	int BACKGROUND_GAUSSIAN_BLUR = 10;
	int LOGO_WIDTH = 500;
	String BACKGROUND_PATH = "res/images/background.jpg";
	String LOGO_PATH = "res/images/RushHourMenuLogo.png";
	
	int EDITOR_BOX_HEIGHT = 35;
	int EDITOR_TOP_BOX_WIDTH = 400;
	int EDITOR_BOTTOM_BOX_SHORT_WIDTH = 300;
	int EDITOR_BOTTOM_BOX_LARGE_WIDTH = 500;
	
	int GAME_BUTTON_HEIGHT = 35;
	int GAME_BUTTON_WIDTH = 120;
	
	int BORDER_MARGIN = 20;
	int DOUBLE_BORDER_MARGIN = BORDER_MARGIN * 2;

	int FONT_SIZE_MENU = 30;
	int FONT_SIZE_EDITOR = 13;
	int FONT_SIZE_GAME = 20;

	int INPUT_WIDTH = 75;
	int INPUT_HEIGHT = 10;

	int NODE_SEPARATION = 10;

	int EXITSIGN_TRANSLATE = 60;

	int BOARDSIZE_LIMIT = 8;

	double BLOCKVIEW_HEIGHT = 60.0;
	double BLOCKVIEW_WIDTH = 60.0;

	Insets TOPBOX_PADDING = new Insets(15, 15, 0, 15);
	Insets BOTTOMBOX_PADDING = new Insets(0, 0, 5, 0);

	double BUTTON_OPACITY = 0.6;
	Insets BUTTON_PADDING = new Insets(10, 10, 10, 10);
	String BUTTON_STYLE_DEFAULT = "-fx-base: black;-fx-focus-color: transparent; -fx-faint-focus-color: transparent;";
	String BUTTON_STYLE_ENTERED = "-fx-base: white;-fx-focus-color: transparent; -fx-faint-focus-color: transparent;";
	String PLAYER_BUTTON_STYLE = "-fx-color: -fx-base;-fx-focus-color: transparent; -fx-faint-focus-color: transparent;";

	String GAMEPANE_STYLE = "-fx-background-color: lightblue";

	int GRID_PADDING = 30;
	int GRID_GAP = 0;

	String PLAYER_FRONT_IMAGE_PATH = "res/images/PlayerFront.png";
	String PLAYER_MIDDLE_IMAGE_PATH = "res/images/PlayerMiddle.png";
	String PLAYER_REAR_IMAGE_PATH = "res/images/PlayerRear.png";
	String TRUCK_FRONT_IMAGE_PATH = "res/images/TruckFront.png";
	String TRUCK_MIDDLE_1_IMAGE_PATH = "res/images/TruckFirstMiddle.png";
	String TRUCK_MIDDLE_2_IMAGE_PATH = "res/images/TruckMiddleSecond.png";
	String TRUCK_REAR_IMAGE_PATH = "res/images/TruckRear.png";

	/* InstructionsMenuPane */
	int FONT_SIZE_INSTRUCTIONS = 24;
	int IMAGE_ROTATION = 90;
	int CANVAS_WIDTH = 500;
	int CANVAS_HEIGHT = 400;
	String INSTRUCTIONS = "\n\nYour quest is to take the red\n" + "car out of the board through the exit."
			+ "\n\nCars can only move forward and backward\n"
			+ "and in their lane. Have fun!\n"
			+ "\n\nFor more information go to:\n"
			+ "www.youtube.com/watch?v=HI0rlp7tiZ0\n";
	String INSTRUCTIONS_STYLE = "-fx-background-color: white;" +
            "-fx-effect: dropshadow(gaussian, grey, " + 5 + ", 0, 0, 0);" +
            "-fx-background-insets: " + 5 + ";";

}

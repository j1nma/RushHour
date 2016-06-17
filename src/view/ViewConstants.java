package view;

import javafx.geometry.Insets;

public interface ViewConstants {
	int BACKGROUND_SIZE = 560;
	int BACKGROUND_GAUSSIAN_BLUR = 10;
	String BACKGROUND_PATH = "res/images/background.jpg";

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
	
	Insets TOPBOX_PADDING = new Insets(15, 15,0,15);
	Insets BOTTOMBOX_PADDING = new Insets(0, 0, 5, 0);
	
	double BUTTON_OPACITY = 0.6;
	Insets BUTTON_PADDING = new Insets(10, 10, 10, 10);
	String BUTTON_STYLE_DEFAULT = "-fx-base: black;-fx-focus-color: transparent;";
	String BUTTON_STYLE_ENTERED = "-fx-base: white;-fx-focus-color: transparent;";
	
	String GAMEPANE_STYLE = "-fx-background-color: lightblue";
	
	int GAME_BUTTON_HEIGHT = 35;
	int GAME_BUTTON_WIDTH = 120;
	
	int BORDER_MARGIN = 20;
	int DOUBLE_BORDER_MARGIN = BORDER_MARGIN * 2;
	
	int GRID_PADDING = 30;
	int GRID_GAP = 0;

	String PLAYER_FRONT_IMAGE_PATH = "res/images/PlayerFront.png";
	String PLAYER_MIDDLE_IMAGE_PATH = "res/images/PlayerMiddle.png";
	String PLAYER_REAR_IMAGE_PATH = "res/images/PlayerRear.png";

	int IMAGE_ROTATION = 90;
	int FONT_SIZE_INSTRUCTIONS = 24;
	
	int CANVAS_WIDTH = 500;
	int CANVAS_HEIGHT = 400;
	String INSTRUCTIONS = "\n\nThe game consists of one red car and other\n"
			+ "of cars. Your quest is to take the red\n" + "car to the exit and set him free."
			+ "\n\nThe cars have an orientation which is in\n" + "the direction of its widest part. The cars can\n"
			+ "move forward and backward, and each time\n" + "you press and release it counts as a move.\n"
			+ "The difficulty of the game is up to you.\n" + "The greater the number of cars, the harder\n"
			+ "it gets.";
}

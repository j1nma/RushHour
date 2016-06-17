package view.panes;

import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.converter.IntegerStringConverter;
import model.Board;
import model.ModelConstants;
import view.BoardView;
import view.EditorInput;
import view.ViewConstants;

public class EditorPane extends BorderPane implements ModelConstants, ViewConstants {
	private int boardSize;
	private int boardExit;
	private int length;
	private int blockOrientation;
	private boolean boardWasBuilt;
	private boolean playerWasBuilt;

	private Point position;
	private Board board;
	private BoardView boardView;
	private BoardPane grid;

	private Button backButton;
	private Button submitButton;
	private Button addBlockButton;
	private Button saveButton;
	private ToggleButton horizontalToggle;
	private ToggleButton verticalToggle;
	private ToggleGroup orientationGroup;
	private EditorInput boardSizeInput;
	private EditorInput boardExitInput;
	private EditorInput blockXInput;
	private EditorInput blockYInput;
	private EditorInput blockLengthInput;
	private HBox hTopBox;
	private HBox hBottomBox;

	public EditorPane() {
		position = new Point();
		backButton = new Button("Back");
		submitButton = new Button("Submit");
		addBlockButton = new Button("Add");
		saveButton = new Button("Save");
		horizontalToggle = new ToggleButton("Horizontal");
		verticalToggle = new ToggleButton("Vertical");
		orientationGroup = new ToggleGroup();
		boardSizeInput = new EditorInput("size...");
		boardExitInput = new EditorInput("exit...");
		blockXInput = new EditorInput("x...");
		blockYInput = new EditorInput("y...");
		blockLengthInput = new EditorInput("length...");
		hTopBox = new HBox();
		hBottomBox = new HBox();

		backButton.setFont(Font.font(FONT_SIZE_EDITOR));
		backButton.setPadding(BUTTON_PADDING);

		submitButton.setFont(Font.font(FONT_SIZE_EDITOR));
		submitButton.setPadding(BUTTON_PADDING);

		addBlockButton.setFont(Font.font(FONT_SIZE_EDITOR));
		addBlockButton.setPadding(BUTTON_PADDING);

		saveButton.setFont(Font.font(FONT_SIZE_EDITOR));
		saveButton.setPadding(BUTTON_PADDING);

		horizontalToggle.setFont(Font.font(FONT_SIZE_EDITOR));
		horizontalToggle.setPadding(BUTTON_PADDING);
		horizontalToggle.setToggleGroup(orientationGroup);
		horizontalToggle.setUserData("HORIZONTAL");

		verticalToggle.setFont(Font.font(FONT_SIZE_EDITOR));
		verticalToggle.setPadding(BUTTON_PADDING);
		verticalToggle.setToggleGroup(orientationGroup);
		verticalToggle.setUserData("VERTICAL");

		hTopBox.setPadding(TOPBOX_PADDING);
		hTopBox.setSpacing(NODE_SEPARATION);
		hTopBox.setAlignment(Pos.CENTER);
		hTopBox.getChildren().addAll(backButton, boardSizeInput, boardExitInput, submitButton, saveButton);

		hBottomBox.setPadding(BOTTOMBOX_PADDING);
		hBottomBox.setSpacing(NODE_SEPARATION);
		hBottomBox.setAlignment(Pos.CENTER);

		this.setTop(hTopBox);
		this.setBottom(hBottomBox);

	}

	private boolean inputIsSet() {
		IntegerStringConverter isc = new IntegerStringConverter();

		if (boardSizeInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert a size.");
		} else if (boardExitInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert an exit.",
					"From 0 (first row) to " + (boardSize - 1) + ".");
		} else {
			boardSize = isc.fromString(boardSizeInput.getText());
			if (boardSize >= BOARDSIZE_LIMIT) {
				createAlert(AlertType.WARNING, "This board may not fit in your screen.");
			}
			boardExit = isc.fromString(boardExitInput.getText());
			return true;
		}
		return false;
	}

	public void buildBoard() {

		if (inputIsSet()) {
			try {
				board = new Board(boardSize, boardExit);
				boardWasBuilt = true;
			} catch (IllegalArgumentException e) {
				createAlert(AlertType.ERROR, "Invalid size and/or exit.", e.getMessage());
			}
		}

		if (boardWasBuilt) {
			boardView = new BoardView(board);
			grid = boardView.getGrid();
			grid.setAlignment(Pos.CENTER);// ojoooo
			grid.setMaxWidth(500);
			this.setCenter(grid);
			playerWasBuilt = false;
			blockXInput.clear();
			blockLengthInput.clear();
			hBottomBox.getChildren().clear();
			hBottomBox.getChildren().addAll(new Label("Insert player:"), blockXInput, blockLengthInput, addBlockButton);

		}
	}

	private boolean blockIsSet() {
		IntegerStringConverter isc = new IntegerStringConverter();

		if (blockXInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert x coordinate.", "From 0 to " + (boardSize - 1) + ".");
		} else if (blockYInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert y coordinate.", "From 0 to " + (boardSize - 1) + ".");
		} else if (blockLengthInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert length.", "From 1 to " + boardSize + ".");
		} else if (orientationGroup.getSelectedToggle() == null) {
			createAlert(AlertType.INFORMATION, "Please toggle orientation.");
		} else {
			position.x = isc.fromString(blockXInput.getText());
			position.y = isc.fromString(blockYInput.getText());
			length = isc.fromString(blockLengthInput.getText());

			if (orientationGroup.getSelectedToggle().getUserData().equals("HORIZONTAL")) {
				blockOrientation = HORIZONTAL;
			} else {
				blockOrientation = VERTICAL;
			}
			return true;
		}
		return false;
	}

	private boolean playerIsSet() {
		IntegerStringConverter isc = new IntegerStringConverter();

		if (blockXInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert x coordinate.", "From 0 to " + (boardSize - 1) + ".");
		} else if (blockLengthInput.getText().isEmpty()) {
			createAlert(AlertType.INFORMATION, "Please insert length.", "From 1 to " + boardSize + ".");
		} else {
			position.x = isc.fromString(blockXInput.getText());
			length = isc.fromString(blockLengthInput.getText());
			return true;
		}
		return false;
	}

	public void buildBlock() {

		if (blockIsSet()) {
			try {
				boardView.setBlockView(board.addBlock(position, length, blockOrientation));
				boardView.refresh();
				grid = boardView.getGrid();
			} catch (IllegalArgumentException e) {
				createAlert(AlertType.ERROR, "Invalid block.", e.getMessage());
			}
		}
	}

	public void buildBlocks() {

		if (playerWasBuilt) {
			buildBlock();
		} else {
			buildPlayer();
		}
	}

	public void buildPlayer() {

		if (playerIsSet()) {
			try {
				playerWasBuilt = true;
				boardView.setBlockView(board.addPlayer(position.x, length));
				boardView.refresh();
				grid = boardView.getGrid();
				blockXInput.clear();
				blockYInput.clear();
				blockLengthInput.clear();
				horizontalToggle.setSelected(false);
				verticalToggle.setSelected(false);
				hBottomBox.getChildren().clear();
				hBottomBox.getChildren().addAll(blockXInput, blockYInput, blockLengthInput, horizontalToggle,
						verticalToggle, addBlockButton);
			} catch (IllegalArgumentException e) {
				createAlert(AlertType.INFORMATION, "Invalid red car.");
			}
		}
	}

	public void save() {
		String fileName = "";
		TextInputDialog dialog = new TextInputDialog("RHgame");

		dialog.setTitle("RushHour");
		dialog.setHeaderText("Saving your board in games folder");
		dialog.setContentText("Save board as:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			fileName = "games/" + result.get() + ".ser";
		}

		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			out.writeObject(board);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createAlert(AlertType type, String header, String context) {
		Alert insertAlert = new Alert(type);
		insertAlert.setHeaderText(header);
		insertAlert.setContentText(context);
		insertAlert.showAndWait();
	}

	private void createAlert(AlertType type, String header) {
		Alert insertAlert = new Alert(type);
		insertAlert.setHeaderText(header);
		insertAlert.showAndWait();
	}

	public boolean isBackPressed() {
		return backButton.isPressed();
	}

	public boolean isSubmitPressed() {
		return submitButton.isPressed();
	}

	public boolean isAddBlockPressed() {
		return addBlockButton.isPressed();
	}

	public boolean isSavePressed() {
		return saveButton.isPressed();
	}

}

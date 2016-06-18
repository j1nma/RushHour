package view.panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Board;
import view.BoardView;
import view.ViewConstants;

/**
 * GamePane is a BorderPane that has a surrender button and the game's grid. It
 * constructs a board view from the board received and assigns its grid to the
 * local BoardPane grid. It sets the grid in the center and the surrender button
 * at the top.
 *
 */
public class GamePane extends BorderPane implements ViewConstants {
	private BoardView boardView;
	private Button surrenderButton;
	private BoardPane grid;
	private HBox hTopBox;

	public GamePane(Board board) {
		surrenderButton = new Button("Surrender");
		boardView = new BoardView(board);

		surrenderButton.setFont(Font.font(FONT_SIZE_GAME));

		grid = boardView.getGrid();

		hTopBox = new HBox(surrenderButton);
		hTopBox.setAlignment(Pos.TOP_CENTER);
		hTopBox.setMinHeight(GAME_BUTTON_HEIGHT);
		hTopBox.setSpacing(NODE_SEPARATION);

		this.setCenter(grid);
		this.setTop(hTopBox);
		BorderPane.setMargin(hTopBox, new Insets(BORDER_MARGIN, 0, 0, 0));
		BorderPane.setMargin(grid,
				new Insets(BORDER_MARGIN, DOUBLE_BORDER_MARGIN, BORDER_MARGIN, DOUBLE_BORDER_MARGIN));
		this.setStyle(GAMEPANE_STYLE);

		this.setHeight(grid.getHeight() + hTopBox.getMinHeight() + BORDER_MARGIN * 4);
        this.setWidth(grid.getWidth() + DOUBLE_BORDER_MARGIN * 2); 
	}
	
	public GamePane(Board board, String player) {
		this(board);
		Text playerLabel = new Text(player);
		playerLabel.setFont(Font.font(FONT_SIZE_GAME+10));
		hTopBox.getChildren().add(playerLabel);
	}

	public boolean isSurrenderPressed() {
		return surrenderButton.isPressed();
	}

	public boolean isMousePressedOnGrid() {
		return grid.isMousePressed();
	}

	public BoardPane getGrid() {
		return grid;
	}

	public void refresh() {
		boardView.refresh();
	}

	public Button getButton() {
		return surrenderButton;
	}
}

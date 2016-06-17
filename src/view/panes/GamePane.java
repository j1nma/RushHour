package view.panes;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import model.Board;
import view.BoardView;
import view.ViewConstants;

import java.util.HashSet;
import java.util.Set;

public class GamePane extends BorderPane implements ViewConstants {
	private BoardView boardView;
	private Button surrenderButton;
	private Set<String> input;
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
		
		this.setCenter(grid);
		this.setTop(hTopBox);
		BorderPane.setMargin(hTopBox, new Insets(BORDER_MARGIN, 0, 0, 0));
		BorderPane.setMargin(grid, new Insets(BORDER_MARGIN, DOUBLE_BORDER_MARGIN, BORDER_MARGIN, DOUBLE_BORDER_MARGIN));
        this.setStyle(GAMEPANE_STYLE);
        
        this.setHeight(grid.getHeight() + hTopBox.getMinHeight() + BORDER_MARGIN * 4);
        this.setWidth(grid.getWidth() + DOUBLE_BORDER_MARGIN * 2); 

		input = new HashSet<String>();
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.add(code);
			}
		});
		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.remove(code);
			}
		});
	}

	public boolean isSurrenderPressed() {
		return surrenderButton.isPressed();
	}

	public boolean isKeyPressed(String key) {
		return input.contains(key);
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

package view.panes;

import javafx.event.EventHandler;
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
		surrenderButton.setMinHeight(35.0);
		grid = boardView.getGrid();
		
		hTopBox = new HBox(surrenderButton);
		hTopBox.setAlignment(Pos.TOP_CENTER);
		hTopBox.setPadding(TOPBOX_PADDING);
		hTopBox.setSpacing(NODE_SEPARATION);
		
		this.setCenter(grid);
		this.setTop(hTopBox);
        this.setStyle(GAMEPANE_STYLE);
        
        this.setHeight(grid.getHeight() + 50.0 + 150*2.0);

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

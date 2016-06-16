package view.panes;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.Board;
import view.BoardView;
import view.MenuButton;
import view.ViewConstants;

import java.util.HashSet;
import java.util.Set;

public class GamePane extends BorderPane implements ViewConstants {
	private BoardView boardView;
	private MenuButton backButton;
	private Set<String> input;
	private BoardPane grid;

	public GamePane(Board board) {
		backButton = new MenuButton("Back");
		boardView = new BoardView(board);
		grid = boardView.getGrid();
		this.setCenter(grid);
		this.setTop(backButton);
        this.setStyle(GAMEPANE_STYLE);

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

	public boolean isBackPressed() {
		return backButton.isPressed();
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

	public MenuButton getButton() {
		return backButton;
	}
}

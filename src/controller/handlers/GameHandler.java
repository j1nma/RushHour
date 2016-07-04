package controller.handlers;

import controller.GameStateManager;
import controller.states.GameState;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Block;
import model.Board;
import model.ModelConstants;
import view.panes.BoardPane;
import view.panes.GamePane;

import java.awt.*;

/**
 * 
 * Handles GamePane from GameState.
 *
 */
public class GameHandler extends Handler<GamePane> implements ModelConstants {
	protected Board board;
	protected Block selectedBlock;
	protected Point startPosition;
	protected Point dragPosition;
	protected Point blockLastPosition;
	protected Point exitPoint;
	protected BoardPane grid;
	protected Integer moves;
	protected boolean mouseWasPressed;

	public GameHandler(GameStateManager gsm, GameState state) {
		super(gsm, state);
		this.board = state.getBoard();
		this.grid = pane.getGrid();
		this.exitPoint = new Point(board.getSize() - 1, board.getExit());
		this.moves = 0;
	}

	@Override
	public void handle(long now) {
		if (pane.isSurrenderPressed()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					createAlert(AlertType.INFORMATION, "YOU SURRENDER? BYE BYE", "NOOB");
				}
			});
			gsm.pop();
		}

		if (pane.isMousePressedOnGrid()) {
			processMouse();
		}

		if (!pane.isMousePressedOnGrid() && mouseWasPressed) {
			mouseWasPressed = false;
			if (hasMoved()) {
				moves += 1;
				checkWinCondition();
			}
		}

		pane.refresh();

	}

	/**
	 * Every time the mouse is pressed on the grid, this method is executed.
	 * Analyzes the grid block pressed and then sets the direction of movement.
	 */
	protected void processMouse() {
		Point currentMousePosition = grid.getMouseCurrentPosition();

		if (!mouseWasPressed) {
			startPosition = grid.getMouseStartingPosition();
			dragPosition = startPosition;
			selectedBlock = board.getGridBlock(startPosition);
			if (selectedBlock != null) {
				blockLastPosition = new Point(selectedBlock.getPosition());
			}
			mouseWasPressed = true;
		}
		if (selectedBlock != null) {
			int direction;
			if (selectedBlock.getOrientation() == HORIZONTAL) {
				if (dragPosition.x > currentMousePosition.x) {
					direction = BACKWARD;
				} else if (dragPosition.x < currentMousePosition.x) {
					direction = FORWARD;
				} else {
					direction = NO_MOVEMENT;
				}
			} else {
				if (dragPosition.y > currentMousePosition.y) {
					direction = BACKWARD;
				} else if (dragPosition.y < currentMousePosition.y) {
					direction = FORWARD;
				} else {
					direction = NO_MOVEMENT;
				}
			}
			if (direction != NO_MOVEMENT) {
				board.moveBlock(selectedBlock, direction);
				dragPosition = currentMousePosition;
			}

		}
	}

	protected boolean hasMoved() {
		if (selectedBlock != null && !selectedBlock.getPosition().equals(blockLastPosition)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player won the game comparing the red car's position to the
	 * exit one.
	 */
	protected void checkWinCondition() {
		if (board.getGridBlock(exitPoint) == board.getRedCar()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					createAlert(AlertType.INFORMATION, "CONGRATULATIONS! YOU WON!", "GG WP");
				}
			});
			gsm.pop();
		}
	}

	protected void createAlert(AlertType type, String header, String context) {
		Alert insertAlert = new Alert(type);
		insertAlert.setHeaderText(header);
		insertAlert.setContentText(context);
		insertAlert.showAndWait();
	}
}

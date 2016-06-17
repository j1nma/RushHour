package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import model.Block;
import model.Board;
import model.ModelConstants;
import view.panes.BoardPane;
import view.panes.GamePane;

import java.awt.*;

public class GameHandler extends Handler<GamePane> implements ModelConstants {
	private Board board;
	private Block selectedBlock;
	private Point startPos;
	private Point dragPos;
	private BoardPane grid;
	private boolean mouseWasPressed;

	public GameHandler(GameStateManager gsm, State state, Board board) {
		super(gsm, state);
		this.board = board;
		this.grid = pane.getGrid();
	}

	@Override
	public void handle(long now) {
		boolean hasMoved = false;

		if (pane.isSurrenderPressed()) {
			gsm.pop();
		}

		if (pane.isMousePressedOnGrid()) {
			Point currMousePos = grid.getMouseCurrentPosition();
			if (!mouseWasPressed) {
				startPos = grid.getMouseStartingPosition();
				dragPos = startPos;
				selectedBlock = board.getGridSquare(startPos);
				mouseWasPressed = true;
			}
			if (selectedBlock != null) {
				int direction;
				if (selectedBlock.getOrientation() == HORIZONTAL) {
					if (dragPos.x > currMousePos.x) {
						direction = BACKWARD;
					} else if (dragPos.x < currMousePos.x) {
						direction = FORWARD;
					} else {
						direction = NO_MOVEMENT;
					}
				} else {
					if (dragPos.y > currMousePos.y) {
						direction = BACKWARD;
					} else if (dragPos.y < currMousePos.y) {
						direction = FORWARD;
					} else {
						direction = NO_MOVEMENT;
					}
				}
				if (direction != NO_MOVEMENT) {
					hasMoved = board.moveBlock(selectedBlock, direction);
					dragPos = currMousePos;
				}

			}
		}

		if (!pane.isMousePressedOnGrid() && mouseWasPressed) {
			mouseWasPressed = false;
		}

		pane.refresh();
		if (hasMoved) {
			// gsm.push(new SecondPlayerState(gsm,));
		}

	}
}

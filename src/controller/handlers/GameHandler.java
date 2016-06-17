package controller.handlers;

import controller.GameStateManager;
import controller.states.GameState;
import model.Block;
import model.Board;
import model.ModelConstants;
import view.panes.BoardPane;
import view.panes.GamePane;

import java.awt.*;

public class GameHandler extends Handler<GamePane> implements ModelConstants {
	protected Board board;
	protected Block selectedBlock;
	protected Point startPos;
	protected Point dragPos;
	protected Point blockLastPos;
	protected Point exitPoint;
	protected BoardPane grid;
	protected Integer moves;
	protected boolean mouseWasPressed;

	public GameHandler(GameStateManager gsm, GameState state) {
		super(gsm, state);
		this.board = state.getBoard();
		this.grid = pane.getGrid();
		this.exitPoint = new Point(board.getSize()-1,board.getExit());
		this.moves = 0;
	}

	@Override
	public void handle(long now) {
		if (pane.isSurrenderPressed()) {
			gsm.pop();
		}

		if (pane.isMousePressedOnGrid()) {
			processMouse();
		}

		if (!pane.isMousePressedOnGrid() && mouseWasPressed) {
			mouseWasPressed = false;
			if(hasMoved()){
				moves+=1;
				checkWinCondition();
			}
		}

		pane.refresh();

	}

	protected void processMouse(){

		Point currMousePos = grid.getMouseCurrentPosition();
		if (!mouseWasPressed) {
			startPos = grid.getMouseStartingPosition();
			dragPos = startPos;
			selectedBlock = board.getGridSquare(startPos);
			if(selectedBlock != null){
				blockLastPos = new Point(selectedBlock.getPosition());
			}
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
				board.moveBlock(selectedBlock, direction);
				dragPos = currMousePos;
			}

		}
	}

	protected boolean hasMoved(){
		if(!selectedBlock.getPosition().equals(blockLastPos)){
			return true;
		}
		return false;
	}

	protected void checkWinCondition(){
		if(board.getGridSquare(exitPoint) == board.getRedCar()){
			gsm.pop();
		}
	}
}

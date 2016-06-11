package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import model.Board;
import model.ModelConstants;
import view.panes.GamePane;

/**
 * Created by Eduardo Fittipaldi on 11/06/2016.
 */
public class GameHandler extends Handler<GamePane> implements ModelConstants{

    private Board board;

    public GameHandler(GameStateManager gsm, State state, Board board) {
        super(gsm, state);
        this.board = board;
    }

    @Override
    public void handle(long now) {
        if(pane.isBackPressed()){
            gsm.pop();
        }

        if(pane.isKeyPressed("RIGHT")){
            board.moveBlock(board.getRedCar(), FORWARD);
        }

        if(pane.isKeyPressed("LEFT")){
            board.moveBlock(board.getRedCar(), BACKWARD);
        }

        pane.refresh();

    }
}

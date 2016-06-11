package controller.states;

import controller.GameStateManager;
import controller.handlers.GameHandler;
import model.Board;
import model.ModelConstants;
import view.panes.GamePane;

import java.awt.*;

public class GameState extends State implements ModelConstants{
    private Board board;

    // TODO: eventualmente va a recibir la board desde el Loader.
    public GameState(GameStateManager gsm) {
        super(gsm);
        board = new Board(6, 1);

        board.addBlock(new Point(0, 0), 2, HORIZONTAL);
        board.addBlock(new Point(0, 1), 2, HORIZONTAL);
        board.addBlock(new Point(0, 4), 3, HORIZONTAL);
        board.addBlock(new Point(0, 5), 4, HORIZONTAL);
        board.addBlock(new Point(3, 3), 1, HORIZONTAL);
        board.addBlock(new Point(5, 0), 3, VERTICAL);
        board.addPlayer(new Point(2, 2), 2, HORIZONTAL);
        pane = new GamePane(board);

        handler = new GameHandler(gsm, this, board);

    }
}

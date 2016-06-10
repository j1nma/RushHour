package view;

import java.awt.Point;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;
import model.Direction;

public class BoardViewTest extends Application implements Direction, ViewConstants {

	@Override
	public void start(Stage primaryStage) {

		Board board = new Board(6, 1);
		
		board.addBlock(new Point(0, 0), 2, HORIZONTAL);
		board.addBlock(new Point(0, 1), 2, HORIZONTAL);
		board.addBlock(new Point(0, 4), 3, HORIZONTAL);
		board.addBlock(new Point(0, 5), 4, HORIZONTAL);
		board.addBlock(new Point(5, 0), 3, VERTICAL);
//		board.addBlock(new Point(5, 0), 3, VERTICAL); 	// j1nma: agregue 'throw new IAE' en Board.
//		board.addBlock(new Point(0, 6), 3, HORIZONTAL); // j1nma: cambie Board
 		board.addPlayer(new Point(2, 2), 2, HORIZONTAL);

		BoardView boardview = new BoardView(board);

		boardview.refresh(board);

		primaryStage.setTitle("RushHour");
		primaryStage.setScene(new Scene(boardview.getGrid(), GRID_SIZE, GRID_SIZE));
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
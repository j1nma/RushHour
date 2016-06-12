package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Block;
import model.Board;
import model.ModelConstants;
import model.Player;
import view.panes.BoardPane;

public class BoardView extends ObjectView<Board> implements ModelConstants {
	private BoardPane grid;

	public BoardView(Board board) {
		super(board);
		grid = new BoardPane(board.getSize());
		refresh();

	}

	public void refresh() {

		BlockView blockview;

		grid.getChildren().clear();

		for (Block block : object.getBlocksSet()) {
			if (block == object.getRedCar()) {
				blockview = new RedCarView((Player) block);
			} else {
				blockview = new BlockView(block);
			}
			
			int x = block.getPosition().x;
			int y = block.getPosition().y;

			for (ImageView image : blockview.getBlockViewImages()) {
				image.setFitHeight(BLOCKVIEW_HEIGHT); // TODO: podria ir en BlockView??
				image.setFitWidth(BLOCKVIEW_WIDTH);

				grid.add(image, x, y);
				if (block.getOrientation() == HORIZONTAL) {
					x++;
				} else {
					y++;
				}
			}
		}

	}

	public BoardPane getGrid() {
		return this.grid;
	}

}

package view;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Block;
import model.Board;
import model.ModelConstants;
import model.Player;
import view.panes.BoardPane;

public class BoardView extends ObjectView<Board> implements ModelConstants {
	private BoardPane grid;
	private Map<Block, BlockView> blockviews;

	public BoardView(Board board) {
		super(board);

		grid = new BoardPane(board.getSize());
		blockviews = new HashMap<Block, BlockView>();
		setBlockViews();

	}

	public void refresh() {
		BlockView blockview;

		grid.getChildren().clear();
		addBorderRectangles(grid);

		for (Block block : object.getBlocksSet()) {
			int x = block.getPosition().x;
			int y = block.getPosition().y;

			blockview = blockviews.get(block);

			for (ImageView imageView : blockview.getBlockViewImages()) {
				grid.add(imageView, x, y);
				if (block.getOrientation() == HORIZONTAL) {
					x++;
				} else {
					y++;
				}
			}
		}

	}

	private void setBlockViews() {
		BlockView blockview;

		for (Block block : object.getBlocksSet()) {
			if (block == object.getRedCar()) {
				blockview = new RedCarView((Player) block);
			} else {
				blockview = new BlockView(block);
			}
			blockviews.put(block, blockview);
		}
	}

	public BoardPane getGrid() {
		return this.grid;
	}
	
	private void addBorderRectangles(BoardPane grid) {
		int size = grid.getSize();
		for(int x = 0; x < size; x++) {
			for(int y = 0; y < size; y++) {
				Rectangle rectangle = new Rectangle(BLOCKVIEW_WIDTH, BLOCKVIEW_HEIGHT);
				rectangle.setStroke(Color.BLACK);
				rectangle.setFill(Color.GREY);
				rectangle.setStrokeWidth(2.0);
				grid.add(rectangle, y, x);
			}
		}
	}
}

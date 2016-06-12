package view;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.ImageView;
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

}

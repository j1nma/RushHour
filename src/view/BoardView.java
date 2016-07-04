package view;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import model.Block;
import model.Board;
import model.Player;
import view.panes.BoardPane;

/**
 * Graphical representation of Board class.
 *
 */
public class BoardView extends ObjectView<Board> {
	private BoardPane grid;
	private Map<Block, BlockView> blockviews;
	private ArrayList<Node> background;

	public BoardView(Board board) {
		super(board);

		grid = new BoardPane(board.getSize());
		blockviews = new HashMap<Block, BlockView>();

		setBlockViews();
		addBackground(board.getExit());
	}

	/**
	 * Iterates over the set of blocks from board, gets its block views from the
	 * map and adds them to the grid regarding the block's orientation.
	 */
	public void refresh() {
		BlockView blockview;

		grid.getChildren().retainAll(background);

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

	public void setBlockViews() {

		for (Block block : object.getBlocksSet()) {
			setBlockView(block);
		}
	}

	/**
	 * Creates a view for the blocks and puts it to the map of Block to
	 * BlockView (blockviews).
	 * 
	 * @param block
	 *            the block to be given a view
	 */
	public void setBlockView(Block block) {
		BlockView blockview;

		if (block.equals(object.getRedCar())) {
			blockview = new PlayerView((Player) block);
		} else {
			blockview = new BlockView(block);
		}
		blockviews.put(block, blockview);
	}

	public BoardPane getGrid() {
		return this.grid;
	}

	private void addBackground(int exit) {
		background = new ArrayList<Node>();
		int size = grid.getSize();
		Text exitText = new Text("EXIT");

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				ImageView backBox = new ImageView(new Image("res/images/backBox.png"));
				backBox.setFitWidth(BLOCKVIEW_WIDTH);
				backBox.setFitHeight(BLOCKVIEW_HEIGHT);

				grid.add(backBox, x, y);
				background.add(backBox);
			}
		}

		exitText.setRotate(90);
		exitText.setTranslateX(EXITSIGN_TRANSLATE);
		exitText.setFill(Color.RED);

		grid.add(exitText, grid.getSize() - 1, exit);
		background.add(exitText);
	}

}

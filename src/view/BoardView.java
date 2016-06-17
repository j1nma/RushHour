package view;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Block;
import model.Board;
import model.Player;
import view.panes.BoardPane;

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

	private void addBackground(int exit) {
		background = new ArrayList<Node>();
		int size = grid.getSize();
		Text exitText = new Text("EXIT");

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Rectangle rectangle = new Rectangle(BLOCKVIEW_WIDTH, BLOCKVIEW_HEIGHT);
				rectangle.setStroke(Color.BLACK);
				rectangle.setFill(Color.GREY);
				rectangle.setStrokeWidth(1.0);
				grid.add(rectangle, x, y);
				background.add(rectangle);
			}
		}

		exitText.setRotate(90);
		exitText.setTranslateX(EXITSIGN_TRANSLATE);
		exitText.setFill(Color.RED);

		grid.add(exitText, grid.getSize() - 1, exit);
		background.add(exitText);
	}

}

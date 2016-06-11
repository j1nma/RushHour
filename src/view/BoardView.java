package view;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.Block;
import model.Board;
import model.ModelConstants;
import model.Player;

public class BoardView extends ObjectView<Board> implements ModelConstants {
	private GridPane grid;

	public BoardView(Board board) {
		super(board);

		grid = new GridPane();
		grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(GRID_PADDING));
		grid.setStyle(GRID_STYLE);

		int size = board.getSize();

		for (int i = 0; i < size; i++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0 / size);
			grid.getColumnConstraints().add(colConst);

			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / size);
			grid.getRowConstraints().add(rowConst);
		}

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

	public GridPane getGrid() {
		return this.grid;
	}

}

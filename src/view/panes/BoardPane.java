package view.panes;

import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import view.ViewConstants;

import java.awt.*;

public class BoardPane extends GridPane implements ViewConstants {

	private int size;
	private boolean mouseIsPressed;
	private Point startingPosition;
	private Point endingPosition;
	private Point currentPosition;

	public BoardPane(int size) {

		this.size = size;
		this.setGridLinesVisible(true);
		this.setPadding(new Insets(GRID_PADDING));
//		this.setStyle(GRID_STYLE);
//		this.setHgap(GRID_GAP);
//		this.setVgap(GRID_GAP);

		for (int i = 0; i < size; i++) {
            ColumnConstraints colConst = new ColumnConstraints(BLOCKVIEW_WIDTH);
			this.getColumnConstraints().add(colConst);
			
            RowConstraints rowConst = new RowConstraints(BLOCKVIEW_HEIGHT);
			this.getRowConstraints().add(rowConst);
		}

		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mouseIsPressed = true;
				startingPosition = convertMouseToGridSquare(e);
				currentPosition = startingPosition;
			}
		});

		this.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mouseIsPressed = false;
				endingPosition = convertMouseToGridSquare(e);
			}
		});

		this.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				currentPosition = convertMouseToGridSquare(e);
			}
		});
	}

	private Point convertMouseToGridSquare(MouseEvent e) {
		Double gridSquareSizeX = BLOCKVIEW_WIDTH;
		Double gridSquareSizeY = BLOCKVIEW_HEIGHT;

		Double unprocessedX = (e.getX() - GRID_PADDING) / gridSquareSizeX;
		Double unprocessedY = (e.getY() - GRID_PADDING) / gridSquareSizeY;

		Integer gridPosX = unprocessedX.intValue();
		Integer gridPosY = unprocessedY.intValue();

		return new Point(gridPosX, gridPosY);
	}

	public Point getMouseCurrentPosition() {
		return currentPosition;
	}

	public Point getMouseStartingPosition() {
		return startingPosition;
	}

	public Point getMouseEndingPosition() {
		return endingPosition;
	}

	public boolean isMousePressed() {
		return mouseIsPressed;
	}
	
	public int getSize() {
		return size;
	}


}

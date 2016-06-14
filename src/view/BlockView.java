package view;

import java.util.ArrayList;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Block;
import model.ModelConstants;
import model.Player;

public class BlockView extends ObjectView<Block> implements ModelConstants {
	private ArrayList<ImageView> images;
	private Color color;

	public BlockView(Block block) {
		super(block);
		color = Color.getRandomColor();
		setImages(block, PLAYER_REAR_IMAGE_PATH, PLAYER_MIDDLE_IMAGE_PATH, PLAYER_FRONT_IMAGE_PATH);

	}

	public BlockView(Player redCar) {
		super(redCar);
		color = Color.RED;
		setImages(redCar, PLAYER_REAR_IMAGE_PATH, PLAYER_MIDDLE_IMAGE_PATH, PLAYER_FRONT_IMAGE_PATH);

	}

	private void setImages(Block block, String frontPath, String middlePath, String rearPath) {
		int length = block.getLength();
		int orientation = block.getOrientation();

		images = new ArrayList<ImageView>(length);

		if (length >= 2) {
			images.add(new ImageView(new Image(frontPath)));

			if (length > 2) {
				for (int i = 1; i < length - 1; i++) {
					images.add(new ImageView(new Image(middlePath)));
				}
			}

		}

		images.add(new ImageView(new Image(rearPath)));

		if (orientation == VERTICAL) {
			for (ImageView imageView : images)
				imageView.setRotate(IMAGE_ROTATION);
		}

		ColorAdjust colorAdjust = new ColorAdjust();

		for (ImageView imageView : images) {
			colorAdjust.setHue(color.getColor());
			imageView.setEffect(colorAdjust);
			imageView.setFitHeight(BLOCKVIEW_HEIGHT);
			imageView.setFitWidth(BLOCKVIEW_WIDTH);
		}

	}

	public ArrayList<ImageView> getBlockViewImages() {
		return this.images;
	}
}

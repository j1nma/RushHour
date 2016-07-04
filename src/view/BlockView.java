package view;

import java.util.ArrayList;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Block;
import model.Player;

/**
 * Graphical representation of Block class.
 *
 */
public class BlockView extends ObjectView<Block> {
	private ArrayList<ImageView> images;
	private Color color;

	public BlockView(Block block) {
		super(block);
		color = Color.getRandomColor();
		images = new ArrayList<ImageView>(block.getLength());

		/* Trucks' length is greater or equal than 3 */
		if (block.getLength() >= 3) {
			setTruckImages(block, TRUCK_FRONT_IMAGE_PATH, TRUCK_MIDDLE_1_IMAGE_PATH, TRUCK_MIDDLE_2_IMAGE_PATH,
					TRUCK_REAR_IMAGE_PATH);
		} else {
			setImages(block, PLAYER_FRONT_IMAGE_PATH, PLAYER_REAR_IMAGE_PATH);
		}

	}

	public BlockView(Player redCar) {
		super(redCar);
		color = Color.RED;
		images = new ArrayList<ImageView>(redCar.getLength());
		setPlayerImages(redCar, PLAYER_FRONT_IMAGE_PATH, PLAYER_MIDDLE_IMAGE_PATH, PLAYER_REAR_IMAGE_PATH);

	}

	/**
	 * Sets images for a block regarding its length in an ArrayList. Blocks of
	 * length one will be assigned the front image by default. If length equals
	 * 2, the rear image will be added.
	 * 
	 * @param block
	 *            images will be set for this block
	 * @param frontPath
	 *            block's front image file path
	 * @param middlePath
	 *            block's middle image file path
	 * @param rearPath
	 *            block's rear image file path
	 */
	private void setImages(Block block, String frontPath, String rearPath) {
		int length = block.getLength();

		if (length == 2) {
			images.add(new ImageView(new Image(rearPath)));
		}

		images.add(new ImageView(new Image(frontPath)));

		if (block.getOrientation() == VERTICAL) {
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

	/**
	 * Any block with length greater than 2 will have middle images.
	 * 
	 * @see setTruckImages
	 */
	private void setPlayerImages(Block block, String frontPath, String middlePath, String rearPath) {
		int length = block.getLength();

		if (length != 1) {
			images.add(new ImageView(new Image(rearPath)));
			while (--length > 1) {
				images.add(new ImageView(new Image(middlePath)));
			}
		}

		images.add(new ImageView(new Image(frontPath)));

		if (block.getOrientation() == VERTICAL) {
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

	private void setTruckImages(Block block, String frontPath, String firstMiddlePath, String secondMiddlePath,
			String rearPath) {
		int length = block.getLength();

		images.add(new ImageView(new Image(rearPath)));

		if (length-- >= 4) {
			images.add(new ImageView(new Image(secondMiddlePath)));
		}

		images.add(new ImageView(new Image(firstMiddlePath)));
		images.add(new ImageView(new Image(frontPath)));

		if (block.getOrientation() == VERTICAL) {
			for (ImageView imageView : images)
				imageView.setRotate(IMAGE_ROTATION);
		}

		ColorAdjust colorAdjust = new ColorAdjust();

		for (ImageView imageView : images) {
			colorAdjust.setHue(color.getColor() >= 0 ? (color.getColor() % 0.4) : (color.getColor() * (-1) % 0.4));
			imageView.setEffect(colorAdjust);
			imageView.setFitHeight(BLOCKVIEW_HEIGHT);
			imageView.setFitWidth(BLOCKVIEW_WIDTH);
		}
	}

	public ArrayList<ImageView> getBlockViewImages() {
		return this.images;
	}
}

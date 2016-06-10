package view;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Block;
import model.Player;

public class BlockView extends ObjectView<Block> {
	ArrayList<ImageView> images;

	public BlockView(Block block) {
		super(block);

		images = new ArrayList<ImageView>(block.getLength());

		setImages(block, CAR_REAR_IMAGE_PATH, CAR_MIDDLE_IMAGE_PATH, CAR_FRONT_IMAGE_PATH);

	}

	public BlockView(Player redCar) {
		super(redCar);

		images = new ArrayList<ImageView>(redCar.getLength());

		setImages(redCar, PLAYER_REAR_IMAGE_PATH, PLAYER_MIDDLE_IMAGE_PATH, PLAYER_FRONT_IMAGE_PATH);

	}

	private void setImages(Block block, String frontPath, String middlePath, String rearPath) {
		int length = block.getLength();
		int orientation = block.getOrientation();

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
	}

	public ArrayList<ImageView> getBlockViewImages() {
		return this.images;
	}
	
	//set on action

}

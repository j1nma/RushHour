package view;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import model.Block;

// Falta hacer la imagen de los bloques
public class BlockView extends ObjectView<Block> {
	ArrayList<ImageView> view;

	// ImageView, ImageView,ImageView,
	public BlockView(Block block, String front, String middle, String rear) {
        //super(null);
    	super(block);
        
        int length = block.getLength();
        //int length = this.objectView.getLength();

        view.add(new ImageView(front)); // Imagen del frente del auto

        // El for agrega la cantidad de partes del medio necesarias
        for(int i = 1; i < length - 1; i++) {
        	view.add(new ImageView(middle));
        }
        
        view.add(new ImageView(rear));
    }

	public ArrayList<ImageView> getBlockView() {
		return this.view;
	}
}

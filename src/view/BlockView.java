package view;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

// Falta hacer la imagen de los bloques
public class BlockView extends ObjectView<Block> {
  ArrayList<ImageView> view;

  public BlockView() {
    int length = this.getLength();

    view.add(new ImageView("")); // Imagen del frente del auto
    // El for agrega la cantidad de partes del medio necesarias
    for(int i = 1; i < length - 1; i++) {
      view.add(new ImageView(""));
    }
    view.add(new ImageView(""));
  }

  public ArrayList<Block> getBlockView() {
    return this.view;
  }
}

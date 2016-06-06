package view;

import RushHour.src.Block

public abstract class ObjectView <T extends Block> {
  protected T objectView;

  public ObjectView(T objectView) {
    this.objectView = objectView;
  }
}

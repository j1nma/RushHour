import java.awt.Point;
import java.util.Vector;

public class Block implements Direction {
	private int orientation;
	private int length;
	private Point position;

	public Block(Point position, int length, int orientation) {
		if (orientation != VERTICAL && orientation != HORIZONTAL) {
			throw new IllegalArgumentException();
		}
		if (length < 1) {
			throw new IllegalArgumentException();
		}
		this.orientation = orientation;
		this.length = length;
		setPosition(position);
	}

	public void setPosition(Point position) {
		this.position.setLocation(position);
	}

	public Point getPosition() {
		return position;
	}

	public int getOrientation() {
		return orientation;
	}

	public int getLength() {
		return length;
	}
}

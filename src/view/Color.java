package view;

import java.util.Random;

public enum Color {
	RED(0.0), LIGHTBLUE(-1.0), BLUE(-0.8), PURPLE(-0.4), PINK(-0.2), ORANGE(0.1), YELLOW(0.2), GREEN(0.5);
	private double value;
	private static final Color[] colors = values();
	private static final int size = colors.length;
	private static final Random generator = new Random();

	private Color(double value) {
		this.value = value;
	}

	public static Color getRandomColor() {
		Color randomColor = colors[generator.nextInt(size)];
		
		while (randomColor == Color.RED)
			randomColor = colors[generator.nextInt(size)];
		
		return randomColor;
	}

	public double getColor() {
		return value;
	}
}

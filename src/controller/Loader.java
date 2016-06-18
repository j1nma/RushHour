package controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Board;

/**
 * Loader is in charge of loading a board from a file.
 *
 */
public class Loader {

	public Board loadBoard(String filePath) {
		Board board = null;

		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
			board = (Board) in.readObject();
			in.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return board;
	}
}

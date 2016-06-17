//package tests;
//
//import static org.junit.Assert.*;
//
//import java.awt.Point;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import model.Block;
//import model.ModelConstants;
//
//public class ModelTest implements ModelConstants {
//
//	@Before
//	public void initialize() {
//		Block block = new Block(null, -1, 3);
//		Block block2 = new Block(new Point(2,-3), 0, 3);
//		Block block3 = new Block(new Point(2,3), 3, HORIZONTAL);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testBlockOrietation() {
//		Block block = new Block(new Point(0, 0), 2, 3);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testBlockLength() {
//		Block block = new Block(new Point(0, 0), 2, 3);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testBlockNullPoint() {
//		Block block = new Block(null, -2, HORIZONTAL);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testSetPosition0() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLength() {
//		Block block = new Block(new Point(2,3), 3, HORIZONTAL);
//		assertEquals(3,block.getLength());
//	}
//
//	@Test
//	public void testPlayer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetPosition() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsOccupiedIntInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsOccupiedPointIntInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetGridSquareIntInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetGridSquarePoint() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMoveBlock() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddBlock() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddPlayer() {
//		fail("Not yet implemented");
//	}
//
//}

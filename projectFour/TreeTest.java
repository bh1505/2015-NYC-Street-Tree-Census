package projectFour;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testEqualsObject() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		assertTrue("Should have returned true.", t.equals(s));
		}
	
	@Test
	public void testSameName() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		assertTrue("Should return true.", t.sameName(s));
		Tree tr = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (540, 10, "alive", "good", "Red oak", 33184, "brooklyn", 44.504, 45.432);
		assertFalse("Should return false.", tr.sameName(sr));
	}
	
	@Test
	public void testCompareName() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (540, 10, "alive", "good", "American linden", 33184, "brooklyn", 44.504, 45.432);
		assertEquals("Should return 0.", 0, t.compareName(s));
		Tree tr = new Tree (540, 10, "alive", "good", "black oak", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (540, 10, "alive", "good", "American linden", 33184, "brooklyn", 44.504, 45.432);
		assertEquals("Should return 1.", 1, tr.compareName(sr));
		Tree tre = new Tree (540, 10, "alive", "good", "English oak", 33184, "brooklyn", 44.504, 45.432);
		Tree sre = new Tree (540, 10, "alive", "good", "linden", 33184, "brooklyn", 44.504, 45.432);
		assertEquals("Should return true.", -1, tre.compareName(sre));
	}
	
	@Test
	public void testCompareTo() {
		Tree t = new Tree (440, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		assertEquals("Should have returned -1.", -1, t.compareTo(s));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}

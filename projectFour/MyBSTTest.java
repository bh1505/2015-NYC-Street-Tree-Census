package projectFour;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class MyBSTTest {

	@Test
	public void testAdd() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "red oak", 33184, "manhattan", 44.504, 45.432);
		MyBST <Tree> set = new MyBST <Tree> ();
		assertTrue("Should return true.", set.add(t));
		assertTrue("Should return true.", set.add(s));
		assertFalse("Should return false.", set.add(s));
		assertEquals("Size should be 2.", 2, set.size);
		assertEquals("Root should equal t.", t, set.root.getData());
		assertEquals("Root right should be s.", s, set.root.getRight().getData());
		assertEquals("Root left should be null.", null, set.root.getLeft());
		Tree r = new Tree (2010, 10, "alive", "fair", "African oak", 33184, "bronx", 44.504, 45.432);
		set.add(r);
		assertEquals("Root left should be r.", r, set.root.getLeft().getData());
		Tree q = new Tree (2310, 10, "alive", "fair", "zeta", 33184, "bronx", 44.504, 45.432);
		set.add(q);
		assertEquals("Root right right should be q", q, set.root.getRight().getRight().getData());
		assertEquals("SHould be 4", 4, set.size);
		try {
			MyBST <Tree> yo = new MyBST <Tree> ();
			yo.add(null);
		} catch (NullPointerException e) {
			//correct
		} catch (Exception e) {
			fail("Wrong exception.");
		}
	}

	@Test
	public void testRemove() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "red oak", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (4310, 10, "alive", "fair", "zeta", 33184, "bronx", 44.504, 45.432);
		Tree m = new Tree (1310, 10, "alive", "fair", "abeta", 33184, "bronx", 44.504, 45.432);
		Tree f = new Tree (9310, 10, "alive", "fair", "Abca", 33184, "bronx", 44.504, 45.432);
		MyBST <Tree> set = new MyBST <Tree> ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(m);
		set.add(f);
		assertEquals("Root right should be s.", s, set.root.getRight().getData());
		set.remove(s);
		assertEquals("Root right should be q.", q, set.root.getRight().getData());
		set.remove(m);
		assertEquals("Root left should be.", f, set.root.getLeft().getData());
		
	}

	@Test
	public void testContains() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "red oak", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (4310, 10, "alive", "fair", "zeta", 33184, "bronx", 44.504, 45.432);
		Tree m = new Tree (1310, 10, "alive", "fair", "abeta", 33184, "bronx", 44.504, 45.432);
		Tree f = new Tree (9310, 10, "alive", "fair", "Abca", 33184, "bronx", 44.504, 45.432);
		MyBST <Tree> set = new MyBST <Tree> ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(f);
		assertEquals("SHould be 4", 4, set.size);
		assertTrue("Should return true.", set.contains(q));
		assertTrue("Should return true.", set.contains(t));
		assertTrue("Should return true.", set.contains(f));
		set.remove(q);
		set.remove(t);
		set.remove(f);
		assertEquals("SHould be 1", 1, set.size);
		assertFalse("Should return false.", set.contains(q));
		assertFalse("Should return false.", set.contains(t));
		assertFalse("Should return false.", set.contains(f));
		assertFalse("Should return false.", set.contains(m));
	}

	@Test
	public void testFirst() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "ABca", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (4310, 10, "alive", "fair", "abgeta", 33184, "bronx", 44.504, 45.432);
		Tree m = new Tree (1310, 10, "alive", "fair", "abeta", 33184, "bronx", 44.504, 45.432);
		Tree f = new Tree (9310, 10, "alive", "fair", "Abca", 33184, "bronx", 44.504, 45.432);
		MyBST <Tree> set = new MyBST <Tree> ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(m);
		set.add(f);
		assertEquals("Should return s", s, set.first());
		assertTrue("Should return true.", set.contains(q));
		try {
			MyBST <Tree> colle = new MyBST <Tree> ();
			colle.first();
		} catch (NoSuchElementException e) {
			//correct
		} catch (Exception e) {
			fail("Incorrect");
		}
	}

	@Test
	public void testLast() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "black", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (4310, 10, "alive", "fair", "aaramel", 33184, "bronx", 44.504, 45.432);
		Tree m = new Tree (5710, 10, "alive", "fair", "aero", 33184, "bronx", 44.504, 45.432);
		Tree f = new Tree (3510, 10, "alive", "fair", "oxye", 33184, "bronx", 44.504, 45.432);
		MyBST <Tree> set = new MyBST <Tree> ();
		set.add(t);
		//set.add(s);
		set.add(q);
		set.add(m);
		//set.add(f);
		assertEquals("Should equal t.", t, set.last());
	}

	@Test
	public void testToString() {
		Tree t = new Tree (540, 10, "alive", "good", "n", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "f", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (310, 10, "alive", "fair", "b", 33184, "bronx", 44.504, 45.432);
		Tree tr = new Tree (640, 10, "alive", "good", "L", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (703, 10, "alive", "fair", "o", 33184, "manhattan", 44.504, 45.432);
		Tree qr = new Tree (8310, 10, "alive", "fair", "y", 33184, "bronx", 44.504, 45.432);
		MyBST <Tree> set = new MyBST <Tree> ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(tr);
		set.add(sr);
		set.add(qr);
		System.out.print(set.toString());
	}

}

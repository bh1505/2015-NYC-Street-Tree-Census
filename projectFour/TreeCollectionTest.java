package projectFour;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TreeCollectionTest {

	@Test
	public void testGetTotalNumberOfTrees() {
		Tree t = new Tree (540, 10, "alive", "good", "n", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "f", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (310, 10, "alive", "fair", "b", 33184, "bronx", 44.504, 45.432);
		Tree tr = new Tree (640, 10, "alive", "good", "L", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (703, 10, "alive", "fair", "o", 33184, "manhattan", 44.504, 45.432);
		Tree qr = new Tree (8310, 10, "alive", "fair", "y", 33184, "bronx", 44.504, 45.432);
		TreeCollection set = new TreeCollection ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(tr);
		set.add(sr);
		set.add(qr);
		assertEquals("Should return 6.", 6, set.getTotalNumberOfTrees());
		set.remove(qr);
		assertEquals("Should return 5.", 5, set.getTotalNumberOfTrees());		
	}

	@Test
	public void testGetCountByTreeSpecies() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "american linden", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (310, 10, "alive", "fair", "black oak", 33184, "bronx", 44.504, 45.432);
		Tree tr = new Tree (640, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (703, 10, "alive", "fair", "maple oak", 33184, "STATEN ISLAND", 44.504, 45.432);
		Tree qr = new Tree (8310, 10, "alive", "fair", "american linden", 33184, "brooklyn", 44.504, 45.432);
		TreeCollection set = new TreeCollection ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(tr);
		set.add(sr);
		set.add(qr);
		System.out.print(set.toString());
	
		//System.out.print(set.getSize());
		//assertEquals("Should return 3.", 2, set.getCountByTreeSpecies("oak"));
	}

	@Test
	public void testGetCountByBorough() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "blue tree", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (310, 10, "alive", "fair", "blue oak", 33184, "bronx", 44.504, 45.432);
		Tree tr = new Tree (640, 10, "alive", "good", "blue linden", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (703, 10, "alive", "fair", "red oak", 33184, "STATEN ISLAND", 44.504, 45.432);
		Tree qr = new Tree (8310, 10, "alive", "fair", "american linden", 33184, "brooklyn", 44.504, 45.432);
		TreeCollection set = new TreeCollection ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(tr);
		set.add(sr);
		set.add(qr);
		assertEquals("Should return 0", 0, set.getCountByBorough("oxye"));
	}

	@Test
	public void testGetCountByTreeSpeciesBorough() {
		Tree t = new Tree (540, 10, "alive", "good", "littleleaf linden", 33184, "bronx", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "american linden", 33184, "staten island", 44.504, 45.432);
		Tree q = new Tree (310, 10, "alive", "fair", "blue oak", 33184, "brooklyn", 44.504, 45.432);
		Tree tr = new Tree (640, 10, "alive", "good", "maple oak", 33184, "bronx", 44.504, 45.432);
		Tree sr = new Tree (703, 10, "alive", "fair", "red linden", 33184, "STATEN ISLAND", 44.504, 45.432);
		Tree qr = new Tree (8310, 10, "alive", "fair", "american linden", 33184, "bronx", 44.504, 45.432);
		TreeCollection set = new TreeCollection ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(tr);
		set.add(sr);
		set.add(qr);
		assertEquals("Should return 4.", 1, set.getCountByTreeSpeciesBorough("oak", "brooklyn"));
	}

	@Test
	public void testGetMatchingSpecies() {
		Tree t = new Tree (540, 10, "alive", "good", "american linden", 33184, "brooklyn", 44.504, 45.432);
		Tree s = new Tree (103, 10, "alive", "fair", "blue tree", 33184, "manhattan", 44.504, 45.432);
		Tree q = new Tree (310, 10, "alive", "fair", "blue oak", 33184, "bronx", 44.504, 45.432);
		Tree tr = new Tree (640, 10, "alive", "good", "blue linden", 33184, "brooklyn", 44.504, 45.432);
		Tree sr = new Tree (703, 10, "alive", "fair", "red oak", 33184, "STATEN ISLAND", 44.504, 45.432);
		Tree qr = new Tree (8310, 10, "alive", "fair", "american linden", 33184, "brooklyn", 44.504, 45.432);
		TreeCollection set = new TreeCollection ();
		set.add(t);
		set.add(s);
		set.add(q);
		set.add(tr);
		set.add(sr);
		set.add(qr);
		ArrayList <String> o = (ArrayList<String>) set.getMatchingSpecies("lin");
		for (int i = 0; i < o.size(); i++) {
			//System.out.println(o.get(i));
		}
	}

}

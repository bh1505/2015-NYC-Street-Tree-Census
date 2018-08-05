package projectFour;

/**
 * This class stores information about a certain Tree in New York City.
 * 
 * @author Brandon Herrera
 * @version 02/14/2017
 *
 */
public class Tree implements Comparable <Tree> {
	//Data fields for information about a particular tree
	private int tree_id;
	private int tree_dbh;
	private String status;
	private String health;
	private String spc_common;
	private int zipcode;
	private String boroname;
	private double x_sp;
	private double y_sp;
	
	/**
	 * 
	 * @param tree_id
	 * 	tree's id number
	 * @param tree_dbh
	 * 	tree's diameter
	 * @param status
	 * 	tree's status
	 * @param health
	 * 	tree's health
	 * @param spc_common
	 * 	tree's name
	 * @param zipcode
	 * 	tree's zipcode area
	 * @param boroname
	 * 	tree's borough location
	 * @param x_sp
	 * 	x double
	 * @param y_sp
	 *  y double
	 *  
	 * @throws IllegalArgumentException if invalid entry.
	 * 
	 */
	public Tree ( int tree_id, int tree_dbh, String status, String health, String spc_common,
			int zipcode, String boroname, double x_sp, double y_sp ) {
		//Check if tree_id was valid entry
		//must be positive integer
		if (tree_id < 0) {
			throw new IllegalArgumentException("Id must be a non-negative int.");
		//store value if positive
		} else {
			this.tree_id = tree_id;
		}
		//Validate diameter
		//Can not be negative number
		if (tree_dbh < 0) {
			throw new IllegalArgumentException("Diameter must be a non-negative int.");
		//if positive store value
		} else {
			this.tree_dbh = tree_dbh;
		}
		//Validate status (case insensitive)
		//if status equals a valid value, store that value
		if (status.toLowerCase().equals("alive")) {
			this.status = status;
		} else if (status.toLowerCase().equals("dead")) {
			this.status = status;
		} else if (status.toLowerCase().equals("stump")) {
			this.status = status;
		} else if (status.equals("") || status == null) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Invalid status entry.");
		}
		//Validate health (case insensitive)
		//if health equals a valid string value, store it
		if (health.toLowerCase().equals("good")) {
			this.health = health;
		} else if (health.toLowerCase().equals("fair")) {
			this.health = health;
		} else if (health.toLowerCase().equals("poor")) {
			this.health = health;
		} else if (health.equals("") || health == null) {
			this.health = health;
		} else {
			throw new IllegalArgumentException("Invalid health entry.");
		}
		//Validate spc_common (name)
		//Unless it is null, store entry.
		if (spc_common == null) {
			throw new IllegalArgumentException("Invalid spc_common (name) entry.");
		} else {
			this.spc_common = spc_common;
		}
		//Validate zipcode
		//if zipcode >= 0 and zipcode <= 99999, store value
		if (zipcode < 0 || zipcode > 99999) {
			throw new IllegalArgumentException("Zipcode must be a positive five"
					+ " digit number.");
		} else {
			this.zipcode = zipcode;	
		}
		//Validate borough (case insensitive)
		//if boroname equals a valid entry, store it.
		if (boroname.toLowerCase().equals("manhattan")) {
			this.boroname = boroname;
		} else if (boroname.toLowerCase().equals("bronx")) {
			this.boroname = boroname;
		} else if (boroname.toLowerCase().equals("brooklyn")) {
			this.boroname = boroname;
		} else if (boroname.toLowerCase().equals("queens")) {
			this.boroname = boroname;
		} else if (boroname.toLowerCase().equals("staten island")) {
			this.boroname = boroname;
		} else {
			throw new IllegalArgumentException ("Invalid borough name.");
		}
		//store x and y
		try {
			this.x_sp = x_sp;
			this.y_sp = y_sp;
		} catch (Exception e) {
			throw new IllegalArgumentException ("Value must be a double.");
		}
	}
	
	/**
	 * Overrides the equals method of class Object in order 
	 * to check if two Trees have same name and id.
	 * 
	 * @param 
	 * 	t object (tree) to be compared with 
	 * 
	 * @return 
	 * 	true if trees are equal to each other,
	 * 	false otherwise.
	 * 
	 * @throws 
	 * 	IllegalArgumentException if both trees have
	 * 	same id number but different species name.
	 */
	@Override
	public boolean equals(Object t) {
		//store id for both trees being compared
		int id = this.getTree_id();
		int di = ((Tree) t).getTree_id();
		//store names of trees
		String nameOne = this.getSpc_common().toLowerCase();
		String nameTwo = ((Tree) t).getSpc_common().toLowerCase();
		//if ids and names equal each other, return true
		if (id == di && nameOne.equals(nameTwo)) {
			return true;
		//if same id but different name, throw exception
		}else if (id == di){
			throw new IllegalArgumentException ("Two trees can not have identical"
					+ " id's but different species names.");
		//if not equal to each other, return false
		} else {
			return false;
		}
	}
	/**
	 * Returns id number of tree object
	 * @return 
	 * 	tree_id of tree
	 */
	public int getTree_id() {
		return tree_id;
	}
	/**
	 * Returns name of tree object
	 * @return 
	 * 	spc_common of tree
	 */
	public String getSpc_common() {
		return spc_common;
	}
	/**
	 * Returns name of  borough 
	 * tree is located in
	 * @return 
	 * 	boroname of tree object
	 */
	public String getBoroname() {
		return boroname;
	}

	/**
	 * Overrides compareTo method of Comparable<Tree> interface (case insensitive).
	 * Comparison between two trees is done by species name as primary
	 * key (in alphabetical order) and by the tree id as secondary key
	 * 
	 * @param 
	 * 	t Tree object to be compared with
	 * @return 
	 *  0 if trees are equal to each other 
	 * 	1 if this tree is 'greater' than param tree,
	 * -1 if "less" than
	 * 
	 */
	@Override
	public int compareTo(Tree t) {
		//store names of trees
		String speNameOne = this.getSpc_common().toLowerCase();
		String speNameTwo = t.getSpc_common().toLowerCase();
		//compare strings
		if (speNameOne.compareTo(speNameTwo) > 0) {
			return 1;
		} else if (speNameOne.compareTo(speNameTwo) < 0) {
			return -1;
		//if same names, compare by id
		} else {
			if (this.getTree_id() < t.getTree_id()) {
				return -1;
			} else if (this.getTree_id() > t.getTree_id()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	/**
	 * Overrides toString method of String class.
	 * Returns id and name of Tree object
	 * 
	 * @return 
	 * 	species name and id of Tree
	 */
	@Override 
	public String toString () {
		String treeString = String.format("%s (%d)", this.spc_common.toLowerCase(), this.tree_id);
		return treeString;
	}
	
	/**
	 * This method returns true if this tree and t have the same species 
	 * name (case insensitive). It returns false otherwise.
	 * 
	 * @param t
	 * 	tree object being compared with this tree
	 * @return
	 * 	true if same species name
	 *  false otherwise
	 *  
	 */
	public boolean sameName(Tree t) {
		//compare species names forgetting case
		String thisTree = this.spc_common.toLowerCase();
		String tree = t.spc_common.toLowerCase();
		if (thisTree.equals(tree)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method compares the species names of two tree objects.
	 * 
	 * @param t
	 * 	tree object to be compared with this tree
	 * @return
	 *  0 if trees have same species name
	 *  1 if this tree has a greater species name
	 * -1 if t has a greater species name
	 * 
	 */
	public int compareName (Tree t) {
		if (this.sameName(t)) {
			return 0;
		} else if (this.spc_common.toLowerCase().compareTo(t.spc_common.toLowerCase()) < 0) {
			return -1;
		} else {
			return 1;
		}
	}

}

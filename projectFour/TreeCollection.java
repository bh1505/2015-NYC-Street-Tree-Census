package projectFour;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class is used to store all the Tree objects.
 * 
 * @author Brandon Herrera
 * @version 04/22/2017
 *
 */
public class TreeCollection extends MyBST <Tree> {
	
	//data fields
	//list of unique tree species names
	private ArrayList <String> names = new ArrayList <String> ();
	//counts for amount of trees in borough
	private int bronxCount = 0;
	private int brookCount = 0;
	private int queensCount = 0;
	private int manhaCount = 0;
	private int siCount = 0;
	//amount of trees with matching tree species
	private int speciesCount = 0;
	//amount of trees with matching tree species and borough
	private int speborCount = 0;
	
	/**
	 * This method returns the total number of Tree objects in this set.
	 * 
	 * @return
	 * 	size of this tree collection
	 * 
	 */
	public int getTotalNumberOfTrees () {
		return this.size;
	}
	
	/**
	 * This method returns the number of Tree objects in this collection whose species 
	 * matches the speciesName specified (case insensitive). Their names match
	 * if the Tree name contains speciesName as a substring.
	 * 
	 * @param speciesName
	 * 	name being searched for in this collection
	 * @return
	 * 	amount of trees with a matching name
	 * 
	 */
	public int getCountByTreeSpecies (String speciesName) {
		this.speciesCount = 0;
		//find all possible names in this list that match speciesName
		ArrayList <String> match = (ArrayList<String>) getMatchingSpecies(speciesName);
		for (int i = 0; i < match.size(); i++) {
			//count each occurrence of each match
			helpCollect (this.root, match.get(i).toLowerCase());
		}
		return this.speciesCount;
	}
	
	/**
	 * This method helps count the amount of Trees with matching
	 * names.
	 * 
	 * @param n
	 * 	node currently being looked at
	 * @param name
	 * 	current name being searched for in collection
	 * 
	 */
	private void helpCollect (BSTNode <Tree> n, String name) {
		//if node is null stop searching here
		if (n==null) {
			return;
		} else {
			String thisName = n.getData().getSpc_common().toLowerCase();
			//if current node matches name
			if (thisName.equals(name))  {
				this.speciesCount ++;
				//continue search
				helpCollect(n.getLeft(), name);
				helpCollect(n.getRight(), name);
			//if name less than current node, search left
			} else if (thisName.compareTo(name) > 0) {
				helpCollect(n.getLeft(), name);	
			//search right
			} else if (thisName.compareTo(name) < 0) {
				helpCollect(n.getRight(), name);
			}
		}
	}
	
	/**
	 * This method returns the number of Tree objects in the collection
	 * that are located in the specified borough.
	 * 
	 * @param boroName
	 * 	borough being counted
	 * @return
	 *  number of trees located in boroName
	 *  
	 */
	public int getCountByBorough (String boroName) {
		//return count for specified borough
		String br = boroName.toLowerCase();
		if (br.equals("bronx")) {
			return bronxCount;
		} else if (br.equals("brooklyn")) {
			return brookCount;
		} else if (br.equals("queens")) {
			return queensCount;
		} else if (br.equals("manhattan")) {
			return manhaCount;
		} else if (br.equals("staten island")){
			return this.siCount;
		//if invalid borough
		} else {
			return 0;
		}
	}
	
	/**
	 * This method returns the number of Trees in the collection whose
	 * species matches the speciesName and which are located in the specified
	 * boroName.
	 * 
	 * @param speciesName
	 * 	name being looked for in collection
	 * @param boroName
	 * 	borough being checked for
	 * @return
	 * 	number of trees with matching species and located in boroName
	 * 
	 */
	public int getCountByTreeSpeciesBorough (String speciesName, String boroName) {
		this.speborCount = 0;
		int valid = 0;
		String br = boroName.toLowerCase();
		String [] boros = {"bronx", "brooklyn", "manhattan",
							"staten island", "queens"};
		for (int i = 0; i < 5; i++) {
			if (boros[i].equals(br)) {
				valid ++;
			}	
		}
		//if valid boroName
		if (valid > 0) {
			//list of all possible names in collection that match speciesName
			ArrayList <String> match = (ArrayList<String>) getMatchingSpecies(speciesName);
			for (int i = 0; i < match.size(); i++) {
				//count each occurrence of each possible name
				recSpebor (this.root, match.get(i).toLowerCase(), br);
			}
		}
		return this.speborCount;
	}
	
	/**
	 * This method helps count the number of Trees
	 * with matching name and borough.
	 * 
	 * @param n
	 * 	current node being looked at
	 * @param name
	 * 	name being searched for
	 * @param br
	 * 	borough being checked for
	 * 
	 */
	private void recSpebor (BSTNode <Tree> n, String name, String br) {
		if (n==null) {
			return;
		} else {
			String thisName = n.getData().getSpc_common().toLowerCase();
			String thisBor = n.getData().getBoroname().toLowerCase();
			//if matching name
			if (thisName.equals(name))  {
				//if matches name and borough
				if (thisBor.equals(br)) {
					this.speborCount ++;
				}
				//keep searching
				recSpebor (n.getLeft(), name, br);
				recSpebor (n.getRight(), name, br);
			//search left
			} else if (thisName.compareTo(name) > 0) {
				recSpebor(n.getLeft(), name, br);	
			//search right
			} else if (thisName.compareTo(name) < 0) {
				recSpebor(n.getRight(), name, br);
			}
		}
	}
	
	/**
	 * This method returns a Collection <String> object containing a list
	 * of all the actual tree species that match the specified speciesName.
	 * The species matches if it contains speciesName as a substring.
	 * 
	 * @param speciesName
	 * name being searched for 
	 * 
	 * @return
	 * 	list of all the actual tree species that match
	 * 
	 */
	public Collection <String> getMatchingSpecies (String speciesName) {
		ArrayList <String> match = new ArrayList <String> ();
		//look at all tree names
		for (int i = 0; i < names.size(); i++) {
			//if current name contains speciesName
			if (names.get(i).contains(speciesName.toLowerCase())) {
				//no duplicates
				if(!match.contains(names.get(i))) {
					match.add(names.get(i));
				}
			}
		}
		return match;
	}
	
	/**
	 * This method returns a string representation
	 * of this collection.
	 */
	@Override
	public String toString () {
		return super.toString();
	}
	
	/**
	 * This method overrides the add method of MyBST.
	 * 
	 * @param t
	 * 	tree being added
	 * @returns 
	 *  true if it was added
	 *  false otherwise
	 * @throws ClassCastException
	 * 	if the specified object cannot be compared with the
	 *  elements currently in this set
	 * @throws NullPointerException
	 * 	if the specified element is null
	 * 
	 */
	@Override
	public boolean add (Tree t) throws ClassCastException {
		if(t == null) {
			throw new NullPointerException("Can not add a null element.");
		}
		if (root == null) {
			BSTNode <Tree> newNode = new BSTNode <Tree> (t);
			this.root = newNode;
			size+=1;
			//keep count of trees in each borough
			addBorough(t.getBoroname().toLowerCase());
			//add to list of all names
			names.add(t.getSpc_common().toLowerCase());
			return true;
		}
		return recAdd(this.root, t);
	}
	
	/**
	 * This is a recursive helper method that helps add the specified
	 * element in the right location of the collection. It acts just like
	 * recAdd in MyBST but keeps count of certain data.
	 * 
	 * @param node
	 * 	Node currently being looked at
	 * @param newData
	 * 	specified tree being added 
	 * @return
	 *  true if tree was added
	 *  false if tree already exists
	 *  
	 */
	private boolean recAdd (BSTNode <Tree> node, Tree newData) {
		if(node.getData().compareTo(newData) == 0) {
			return false;
		} else if (newData.compareTo(node.getData()) < 0) {
			if (node.getLeft()==null) {
				node.setLeft(new BSTNode <Tree> (newData));
				size += 1;
				//count borough
				addBorough(newData.getBoroname().toLowerCase());
				//add name to list
				if (!names.contains(newData.getSpc_common().toLowerCase())) {
					//no duplicates
					names.add(newData.getSpc_common().toLowerCase());
				}
				return true;
			}
			return recAdd(node.getLeft(), newData);
		} else {
			if (node.getRight()==null) {
				node.setRight(new BSTNode <Tree> (newData));
				size += 1;
				addBorough(newData.getBoroname().toLowerCase());
				if (!names.contains(newData.getSpc_common().toLowerCase())) {
					names.add(newData.getSpc_common().toLowerCase());
				}
				return true;
			}
			return recAdd(node.getRight(), newData);
		}
	}
	
	/**
	 * This method helps keep count of the amount of
	 * trees in each borough.
	 * 
	 * @param n
	 * 	borough to be incremented
	 * 
	 */
	private void addBorough (String n) {
		if (n.equals("bronx")) {
			this.bronxCount ++;
		} else if (n.equals("brooklyn")) {
			this.brookCount ++;
		} else if (n.equals("queens")) {
			this.queensCount ++;
		} else if (n.equals("manhattan")) {
			this.manhaCount ++;
		} else if (n.equals("staten island")) {
			this.siCount ++;
		}
	}
}

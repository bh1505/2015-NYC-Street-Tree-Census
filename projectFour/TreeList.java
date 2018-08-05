package projectFour;
import java.util.ArrayList;

/**
 * This class is used to store all the Tree objects and 
 * provides methods that return information about the 
 * ArrayList<Tree>.
 * 
 * @author Brandon Herrera
 * @version 02/14/2017
 *
 */

public class TreeList extends ArrayList <Tree>{
	
	/**
	 * Returns number of tree objects in ArrayList<Tree>.
	 * @return 
	 * 	number of tree objects in ArrayList<Tree>.
	 */
	public int getTotalNumberOfTrees() {
		int numTrees = size();
		return numTrees;
	}
	
	/**
	 * Returns the number of Tree objects in the list whose species 
	 * name matches the speciesName parameter (case insensitive).
	 * 
	 * @param speciesName 
	 * 	the species name being counted in the list
	 * 
	 * @return count 
	 * 	if speciesName exists in the ArrayList at least once,
	 * 	0 if speciesName does not exist in list
	 * 
	 */
	public int getCountByTreeSpecies (String speciesName) {
		//Sentinel value to count frequency of speciesName in list
		int count = 0;
		for (int i = 0; i < size(); i++) {
			//if element at i equals speciesName, add 1 to count
			if (get(i).getSpc_common().contains(
					speciesName.toLowerCase())) {
				count += 1;
			}
		}
		//if there was at least one match
		if (count > 0) {
			return count;
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns amount of Tree objects in the list that are located in
	 * specified borough by parameter boroName (case-insensitive).
	 * 
	 * @param boroName 
	 * 	Trees located in boroName (borough) are counted
	 * 	in list
	 * 
	 * @return count
	 *  if at least one tree object exists in boroName (borough),
	 *  0 if no trees are located in specified borough
	 *  
	 */
	public int getCountByBorough (String boroName) {
		//Sentinel
		int count = 0;
		for (int i = 0; i < size(); i++) {
			//if tree at i in list is located in boroName, add 1 to count
			if (get(i).getBoroname().toLowerCase().equals(
					boroName.toLowerCase())) {
				count += 1;
			}
		}
		//if at least one tree is in boroName
		if (count > 0) {
			return count;
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns amount of Tree objects in list whose species name
	 * matches speciesName and is located in the specified
	 * boroName or borough (case insensitive).
	 * 
	 * @param speciesName 
	 * 	species name Tree object needs to match
	 * @param boroName 
	 * 	borough Tree object needs to be located in
	 * 
	 * @return
	 * 	count if at least one Tree object matches speciesName and boroName,
	 * 	0 if no Tree objects match
	 */
	public int getCountByTreeSpeciesBorough (String speciesName, String boroName) {
		//Sentinel
		int count = 0;
		for (int i = 0; i < size(); i++) {
			//if Tree object at i of list matches specified speciesName
			if (get(i).getSpc_common().contains(speciesName.toLowerCase())) {
				//if Tree is also located at specified boroName, add 1 to count
				if (get(i).getBoroname().toLowerCase().equals(boroName.toLowerCase())) {
					count += 1;
				}
			}
		}
		//if at least one match
		if (count > 0) {
			return count;
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns an ArrayList<String> object that contains a list of 
	 * all the Tree object speciesNames that contain the specified
	 * speciesName as a substring.Case insensitive and no duplicates.
	 * 
	 * @param speciesName
	 * 	substring that is being searched for in Tree object species names
	 * 
	 * @return
	 * 	ArrayList<String> of all species names that contain specified param
	 *	as a substring.
	 *
	 */
	public ArrayList <String> getMatchingSpecies (String speciesName) {
		ArrayList <String> match = new ArrayList <String>();
		for (int i = 0; i < size(); i++) {
			//if tree at i in list has species name that contains speciesName
			if (get(i).getSpc_common().contains(speciesName.toLowerCase())) {
				//if species name has not been added to list yet, add it
				if (!match.contains(get(i).getSpc_common())) {
					match.add(get(i).getSpc_common());
				}
				
			}
		}
		return match;
	}
	
	/**
	 * Overrides toString method of String class.
	 * Returns the total number of Tree objects in the list
	 * as a string.
	 * 
	 * @return 
	 * 	total number of Tree objects in list
	 */
	@Override
	public String toString() {
		int total = this.getTotalNumberOfTrees();
		String totalStr = String.format("Total # of Trees: %d", total);
		return totalStr;
		
		
	}
	
}

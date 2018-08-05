package projectFour;

import java.util.Scanner;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * This class is the actual program and contains the main method.
 * It opens and reads the data files, handles user input and thrown errors,
 * and displays data about the TreeCollection to the user.
 * 
 * @author Brandon Herrera
 * @version 04/22/2017
 *
 */

public class NYCStreetTrees {
	/**
	 * Main method.
	 * @param args
	 * 	contains file to be opened at position 0
	 * @throws Exception
	 * 	if invalid entry when creating a Tree object
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//open new file of file name entered in command line
		if (args.length == 0) {
			System.err.print("No input file found.");
			System.exit(1);
		}
		String file = args[0];
		File dataFile = new File(file);
		if (!dataFile.exists()) {
			System.err.print("File does not exist.");
			System.exit(1);
		} 
		//read file
		Scanner s = new Scanner(dataFile);
		//sentinel to know first line was skipped
		int c = 0;
		TreeCollection inv = new TreeCollection();
		//loop through each line of file
		while ( s.hasNextLine() ) {
			String line = s.nextLine();
			//skip first line of data file (labels of data fields)
			if (c == 0) {
				c+=1;
				continue;
			}
			//split line into 41 columns
			ArrayList <String> result = splitCSVLine(line);
			//if there is not 41, invalid file 
			if (result.size() < 41) {
				System.err.print("Invalid file type.");
				System.exit(1);
			}
			try {
				//parseInt any values needed to make Tree object
				int id = Integer.parseInt(result.get(0));
				int diam = Integer.parseInt(result.get(3));
				int zip = Integer.parseInt(result.get(25));
				//store String values
				String status = result.get(6);
				String health = result.get(7);
				String boro = result.get(29);
				String spc = result.get(9);
				//parseDouble x and y
				double x = Double.parseDouble(result.get(39));
				double y = Double.parseDouble(result.get(40));	
				//create Tree and add to TreeList
				Tree t = new Tree (id, diam, status, health,
						spc, zip, boro, x, y);
				inv.add(t);
			} catch (Exception e) {}
		}
		s.close();	
		//greet user and ask for species name on a loop
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\nEnter the tree species to learn more about it ('quit' to stop): ");
			String user = in.nextLine();
			//if user wishes to quit
			if (user.toLowerCase().equals("quit")) {
				in.close();
				break;
			}
			//check if valid tree name was entered
			ArrayList <String> matching = (ArrayList<String>) inv.getMatchingSpecies(user);
			if (matching.isEmpty()) {
				System.out.println("There are no records of " + user + " trees in NYC.");
				continue;
			}
			//print matches 
			System.out.println("All matching species: ");
			for (int i = 0; i < matching.size(); i++) {
				System.out.println("   " + matching.get(i));
			}
			System.out.println("\nPopularity in the city: ");
			//calculate total amount of trees for each borough
			//NYC
			int nycSpe = inv.getCountByTreeSpecies(user);
			int nycTrees = inv.getTotalNumberOfTrees();
			//Manhattan
			int manSpeBor = inv.getCountByTreeSpeciesBorough(user, "manhattan");
			int manTrees = inv.getCountByBorough("manhattan");
			//Bronx
			int bronxSpeBor = inv.getCountByTreeSpeciesBorough(user, "bronx");
			int bronxTrees = inv.getCountByBorough("bronx");
			//Brooklyn
			int brookSpeBor = inv.getCountByTreeSpeciesBorough(user, "brooklyn");
			int brookTrees = inv.getCountByBorough("brooklyn");
			//Queens
			int queensSpeBor = inv.getCountByTreeSpeciesBorough(user, "queens");
			int queensTrees = inv.getCountByBorough("queens");
			//Staten Island
			int siSpeBor = inv.getCountByTreeSpeciesBorough(user, "staten island");
			int siTrees = inv.getCountByBorough("staten island");
			//print stats for each borough and NYC for specified species name
			printStats("NYC", nycSpe, nycTrees);
			printStats("Manhattan", manSpeBor, manTrees);
			printStats("Bronx", bronxSpeBor, bronxTrees);
			printStats("Brooklyn", brookSpeBor, brookTrees);
			printStats("Queens", queensSpeBor, queensTrees);
			printStats("Staten Island", siSpeBor, siTrees);
		}
	}
	/**
	 * This method prints out a formatted string containing information
	 * for each borough and NYC in evenly separated columns. That of which includes
	 * name of borough, amount of species name matches in specified borough,
	 * amount of trees in borough, and the ratio of spebor/bor * 100, which is
	 * calculated in another method.
	 * 
	 * @param borough
	 * 	name of borough being counted 
	 * @param spebor
	 * 	amount of species name matches in specified borough
	 * @param bor
	 * 	amount of total trees in specified borough
	 */
	public static void printStats(String borough, int spebor, int bor) {
		System.out.printf("   %-13s :  %,8d %11s %6.2f"+"%s\n", borough, spebor, 
				"("+NumberFormat.getIntegerInstance().format(bor)+")",
				ratio(spebor, bor), "%");
	}
	/**
	 * Returns ratio of spebor/bor as percentage.
	 * 
	 * @param spebor
	 * 	amount of species name matches in specified borough
	 * @param bor
	 * 	amount of trees in specified borough
	 * @return
	 * 	0 if no trees located in borough to prevent dividing by 0,
	 *  ratio of spebor/bor as percentage otherwise
	 */
	public static float ratio(int spebor, int bor) {
		if (bor == 0) {
			return 0;
		} else{
		return ((float) spebor/bor)*100;
		}
	}
	
	/**
	 * Splits the given line of a CSV file according to commas and double quotes
	 * (double quotes are used to surround  multi-word entries that may contain commas). 
	 * 
	 * @param textLine  line of text to be parsed
	 * @return an ArrayList object containing all individual entries/tokens
	 *         found on the line.
	 */
	public static ArrayList<String> splitCSVLine(String textLine) {
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer();
		char nextChar;
		boolean insideQuotes = false;
		boolean insideEntry= false;
		
		//iterate over all characters in the textLine
		for (int i = 0; i < lineLength; i++) {
			nextChar = textLine.charAt(i);
			
			//handle smart quotes as well as regular quotes 
			if (nextChar == '"' || nextChar == '\u201C' || nextChar =='\u201D') { 
				//change insideQuotes flag when nextChar is a quote
				if (insideQuotes) {
					insideQuotes = false;
					insideEntry = false; 
				}
				else {
					insideQuotes = true; 
					insideEntry = true; 
				}
			}
			else if (Character.isWhitespace(nextChar)) {
				if  ( insideQuotes || insideEntry ) {
					// add it to the current entry
					nextWord.append( nextChar );
				}
				else  { // skip all spaces between entries 
					continue;
				}
			}
			else if ( nextChar == ',') {
				if (insideQuotes) //comma inside an entry 
					nextWord.append(nextChar);
				else { //end of entry found 
					insideEntry = false; 
					entries.add(nextWord.toString());
					nextWord = new StringBuffer();
				}
			}
			else {
				//add all other characters to the nextWord 
				nextWord.append(nextChar);
				insideEntry = true; 
			}

		}
		// add the last word (assuming not empty)
		// trim the white space before adding to the list
		if (!nextWord.toString().equals("")) {
			entries.add(nextWord.toString().trim());
		}
		
	
		return entries;
	}

}

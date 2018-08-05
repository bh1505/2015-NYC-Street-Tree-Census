# 2015-NYC-Street-Tree-Census
A tool for visualizing popularity of New York City street trees in different boroughs of the city. 
The program uses the 2015 Street Tree Census data provided by Department of Parks and Recreation: https://goo.gl/pIjCPG. 
Using this data and a name of the tree specified by the user, the program generates information about popularity of this 
type of tree in each borough of New York City.

The program runs in a loop that allows the user to check popularity of different tree names. On each iteration, the user is
prompted to enter either a name (for which the program computes the results) or the word ”quit” (any case of letters should work) to
indicate the termination of the program.

The name entered by the user may match names of several species (the name entered by the user is a substring
of an actual species name - ignoring the case).

The program prints the list of all the different species matching the name (without repeats) and then print the information regarding
the counts of all trees with those species names for NYC and for each borough individually. Each individual tree is stored onto 
my custom implementation of a binary search tree (MYBST.java) and sorted by name.

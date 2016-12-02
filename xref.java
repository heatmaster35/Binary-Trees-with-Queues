/*##################################
# Name: Anthony Lampi & Leo Gomez  #
# CruzID: alampi & legomez         #
# Class: CMPS-12B                  #
# Date: Nov 19, 2014               #
# filename: xref.java              #
# Details: a program that itorates #
#   over a file, and extracts words#
#   from each line.                #
##################################*/

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {
    
    static void processFile(String filename, boolean debug) throws IOException 
    {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) 
	    {
		for (String word: scan.nextLine().split ("\\W+")) 
		    {
                tree.insert(word, linenr);
		    }
	    }
        scan.close();
        if (debug)
            tree.debug();
	else
	    tree.output();
    }

    public static void main(String[] args) {
	String filename;
	if(args.length > 1)
	    filename = args[1];
	else
	    filename = args[0];
        boolean checkd;
        if(args[0].compareTo("-d") == 0)
	    checkd = true;
	else
	    checkd = false;
        try
	    {
                processFile(filename, checkd);
	    } 
	catch(IOException error)
	    {
	    auxlib.warn (error.getMessage());
	    }

	auxlib.exit();
    }
}
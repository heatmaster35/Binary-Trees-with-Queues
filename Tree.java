/*#################################
# Name: Anthony Lampi & Leo Gomez #
# CruzID: alampi & legomez        #
# Class: CMPS-12B                 #
# Date: Nov 19, 2014              #
# filename: Tree.java             #
# Details: a program to implement #
#    a binary search tree         #
#################################*/

import static java.lang.System.*;

class Tree 
{
    
    private class Node 
    {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;
    
    private void debugHelper(Node tree, int depth) 
    {

        if(tree == null) return;
        debugHelper(tree.left, depth+1);
        for (int indnt = 0; indnt < depth; ++indnt) System.out.print("   ");
        System.out.printf("%d %s%n" , depth, tree.key);
	debugHelper(tree.right, depth+1);
    }
    
    private void outputHelper(Node tree) 
    {
        if(tree == null) return;
	outputHelper(tree.left);
	System.out.printf("%s :", tree.key);
	while(tree.value.iterator().hasNext())
	    {
		System.out.printf(" %d", tree.value.iterator().next());
		tree.value.iterator().remove();
	    }
	System.out.println();
	outputHelper(tree.right);
    }
    
    public void insert(String key, Integer linenum) 
    {
        Node parent = new Node();
	Node currentn = root;
	Node newtemp = new Node();
	boolean leftside = true;
	newtemp.key = key;
	newtemp.value = new Queue<Integer>();
	newtemp.value.insert(linenum);
	//when tree is empty
	if(root == null)
	    {
		root = newtemp;
	    }
	//when tree has a value
	//will search for the next null or match value
	while(currentn != null)
	    {
		//will check for to see if it goes to
		//right or left child
		if(key.compareTo(currentn.key) > 0)
		    {
			parent = currentn;
			leftside = false;
			currentn = currentn.right;
		    }else if(key.compareTo(currentn.key) < 0)
		    {
			parent = currentn;
			leftside = true;
			currentn = currentn.left;
		    }else
		    {
			break;
		    }
	    }
	//if next null is found than insert the node
	if((currentn == null)&&(currentn != root))
	    {
		currentn = newtemp;
		if(leftside)
		    parent.left = currentn;
		else
		    parent.right = currentn;
	    }else
	    //if next match is found, then insert the value;
	    {
		currentn.value.insert(linenum);
	    }	    
    }
    
    public void debug() 
    {
        // Show debug output of tree
        debugHelper(root, 0);
    }
    
    public void output() 
    {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }
}
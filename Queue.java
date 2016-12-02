/*#######################################
# Name: Anthony Lampi & Leo Gomez       #
# CruzID: alampi & legomez              #
# Class: CMPS-12B                       #
# Date: Nov 19, 2014                    #
# filename: Queue.java                  #
# Details: a linked list implenentation #
#    of a queue.                        #
#######################################*/

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> 
{
    
    private class Node 
    {
	Item item;
	Node next;
    }
    private Node head = null;
    private Node tail = null;
    
    public boolean isempty() 
    {
	return (head == null);
    }
    
    public void insert(Item newitem) 
    {
	Node tmp = new Node();
	tmp.item =newitem;
	tmp.next =null;
	
	if(head == null)
	    {
		head =tmp;
		
		tail =tmp;
		
	    }
	else
	    {
		tail.next= tmp;
		tail =tmp;
	    } 
    }
    
    public Iterator <Item> iterator() 
    {
	return new Itor ();
    }
    
    class Itor implements Iterator <Item> 
    {
	Node current = head;
	public boolean hasNext() 
	{
	    return current != null;
	}
	public Item next() 
	{
	    if (! hasNext ()) throw new NoSuchElementException();
	    Item result = current.item;
	    current = current.next;
	    return result;
	}
	public void remove() 
	{
	    if(head != null)
		{
		    if(head.next != null)
			head = current.next;
		    else
			head = null;
		    current = head;
		}
	}
    }
}

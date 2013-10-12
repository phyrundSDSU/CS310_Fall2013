package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Comparator;

	/**
	 * linkedList Class to store very large numbers
	 * @param Node objects
	 */

public class LinkedListDS<E> implements ListADT<E>{
	
// Inner Class Node
    public class Node<E> implements Comparable<E>{
			E data;
			Node<E> next;

	 /**
	  * Inner Class Node constructor
	  * @param obj is a Node obj
	  */
			public Node(E obj){
			    data = obj;
				next = null;
			}

	 /**
	  * A comparator to compare Linked List objects
	  * @param Node obj
	  * @return Returns an int value
	  */
	public int compareTo(E obj) {
	    return ((Comparable<E>)data).compareTo(obj);
	}
	
    }
// IteratorHelper inner class
    class IteratorHelper implements Iterator<E>{
	    Node<E> index;
	    
	    /**
		  * An iterator to traverse through data structure 
		  * @param empty parameters
		  * @return Returns nothing
		  */	    
		public IteratorHelper(){
		    index = head;
		}
		
		 /**
		  * Checks to see if there is an item existing next
		  * @param empty parameters
		  * @return Returns a boolean value
		  */
		public boolean hasNext(){
			return index != null;
		}
		
		/**
		  * Sets the next value in the linkedList data structure
		  * @param empty parameters
		  * @return Returns an E object
		  */
		public E next(){
		    if(!hasNext()){
			    throw new NoSuchElementException();
			}
				E temp = index.data;
				index = index.next;	
				return temp;		
		}

		/**
		  * Removes an object from linkedList but not implemented here
		  * @param empty parameters
		  * @return Returns an exception
		  */
		public void remove(){
		    throw new UnsupportedOperationException();	
		}	
			
	}
//Fields from class LinkedList	
    private Node<E> head, tail;
    private int currentSize;
		
	
    /**
	  * Constructor for linkedList Class
	  * @param empty parameters
	  */
    public LinkedListDS(){
	    head = tail = null;
		currentSize = 0;
	}
		
		
//Method definitions	
    
    /**
	  * Checks to see if linkedList data structure is empty
	  * @param empty parameters
	  * @return Returns a boolean value
	  */
    public boolean isEmpty(){return (this.size() == 0);}
    
    /**
	  * Checks to see if data structre is full
	  * @param empty parameters
	  * @return Returns a boolean value
	  */
	public boolean isFull(){return false;}

	/**
	  * Checks to see the size of data structure
	  * @param empty parameters
	  * @return Returns a boolean value
	  */
	public int size(){return currentSize;}
	
	/**
	  * Adds to the beginning of the linkedList
	  * @param an object of type E
	  * @return Returns void
	  */
	public void addFirst(E obj){
	    Node<E> newNode = new Node<E> (obj);
		newNode.next = head;
		head = newNode;
//		    if(tail == null)
//			    tail = head; 
		currentSize++;
	}

	
	/**
	  * Adds to the end of the linkedList
	  * @param an object of type E
	  * @return Returns void
	  */
	public void addLast(E obj){
	    Node<E> newNode = new Node<E> (obj);
		    if(tail == null){
			    tail = newNode;
				if(head == null)
				    head = tail;
			    currentSize++;
			}
			else{
				tail.next = newNode;
				tail = newNode;
				currentSize++;
			}
	}
	
	/**
	  * Removes the first item of  linkedList
	  * @param empty parameters
	  * @return Returns an object of type E
	  */
	public E removeFirst(){ 
	    if(head == null)
		    return null;
			
	    E tmp;
		tmp = head.data;
		head = head.next;
		if(currentSize == 1)
			tail = null;
		currentSize--;
		return tmp;
	}
	
	/**
	  * Removes the last object of the linkedList
	  * @param empty parameter list
	  * @return Returns an object of type E
	  */
	public E removeLast(){
	    Node<E> current = head, previous = null;
	    
		    if(head == null) // If list is empty return null
			    return null;
			if(head.next == null) // If there is one item remove first
				return removeFirst();
			
			while(current.next != null){ // Traverse through list until current.next == null
				previous = current;
				current = current.next;
			}
			previous.next = null;
			tail = previous;
			currentSize--;
			return current.data; 			
	}

	
	/**
	  * Preview of first object in linkedList
	  * @param empty parameter list
	  * @return Returns first object in linkedList
	  */
	public E peekFirst(){
	    return head.data;
	}

	/**
	  * Preview of last object in linkedList
	  * @param empty parameter list
	  * @return Returns last object in linkedList
	  */	
	public E peekLast(){
	    return tail.data;
	}

	/**
	  * Clears the linkedList data structure
	  * @param empty parameter list
	  * @return Returns void
	  */
	public void makeEmpty(){
	    head = null;
		tail = null;
		currentSize = 0;
	}

	/**
	  * Checks to see if object is in the linkedList
	  * @param an object of type E
	  * @return Returns a boolean value
	  */
	public boolean contains(E obj){
	    Node<E> tmp = head;
		   while(tmp != null){
		       if(tmp.compareTo(obj) == 0)
			       return true;
		       tmp = tmp.next;
		   }
		return false;
	}
	
	// Delete function
	public boolean remove(E obj){
		Node<E> previous = null, current = head;
		while(current != null && ((Comparable<E>)obj).compareTo(current.data) != 0){
			previous = current;
			current = current.next;
		}
		// if current != null, then node was found
		if(current == null)
			return false;
		if(current == head)
			head = head.next;
		else if(current == tail){
			previous.next = null;
			tail = previous;
			currentSize--;
		}
		else // node to remove is in the middle
			previous.next = current.next;
			currentSize--;
		if(head == null) // adjust tail pointer
			tail = null;
		return true;
	}
	
	public E find(E obj){
		Node<E> tmp = head;
		while(tmp != null){
			if(tmp.data == obj)
				return obj;
			tmp = tmp.next;
		}
		return null;
	}
	

	/**
	  * Creates an iterator object
	  * @param empty parameter list
	  * @return Returns an Iterator object
	  */
	public Iterator<E> iterator(){	
	    return new IteratorHelper();
	}

	
}
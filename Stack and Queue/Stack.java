package StackQueue;

public class Stack<E> {
    private List<E> store ; // use singly-linked list for the data store
    private int size ;  // keep track the # of items on stack
    private Node<E> top ;  // use as the reference to the top of the stack

    // default c'tor: set up an empty stack (list)
    public Stack() {
    	store=new List<E>();
    	top=store.head;  
    	size=0; 	
    }
    
    public boolean isEmpty() {
    	return size==0;
    }
    
    // add an item to the top of the stack
    public void push(E item) {
    	Node<E> adNode=new Node<E>(item);
    	store.insertFront(adNode);
    	top=store.head; 
    	size++;
    }
    
    // remove the top item from the stack and returns its integer value
    public E pop() {
       Node<E> rmNode=store.removeFromHead();
       top=store.head;
       size--;
       return rmNode.getData();
    }

    // retrieve the integer stored on the top of the stack without removing it from the stack
    public E peek() {
       return top.getData();        
    }
    
    public void displayStack() {
    	Node<E> cur=top;
    	for (int i=0; i<size; i++) {
    		System.out.print(cur.getData()+" ");
    		cur=cur.getNext();    	
    	}
    } 
    
}

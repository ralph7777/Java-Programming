package StackQueue;

public class Queue<E> {

	Node<E> front, rear ;
	int size ;
	
	// default c'tor create an empty queue
	public Queue() {
		front=null;
		rear=null;
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	// remove the front node and returns the integer value it stores.
	public E deleteQ() {
		if (size==0) {
			System.out.println("Warning:The Queue is already empty!");
			return null;
		}
		else {
			E item=front.getData();
			Node<E> nex=front.getNext();
			front=nex;
			size--;
			if (size==0) {
				rear=null;
			}
			return item;
		}
	} 
	
	// add n to the queue
	public void addQ(E n ) {
		Node<E> node=new Node<E>();
		node.setData(n);
		node.setNext(null);
		if (size==0) {
			rear=node;
			front=node;
		}
		else {
			rear.setNext(node);
			rear=node;
		}
		size++;
	} 
	
	// display the content of the queue
	public void displayQueue() {
    		Node<E> cur=front;
    		for (int i=0; i<size; i++) {
    			System.out.print(cur.getData()+" ");
    			cur=cur.getNext();    	
    		}
    	} 
 
}
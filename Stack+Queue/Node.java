package StackQueue;

public class Node<E> {
	
	E data;
 	Node<E> next;

    	public Node(){
    		this.next = null;
    	}

  	public Node(E data) {
  		this.data = data;
  		this.next = null;  		
  	}

  	public Node(E data, Node<E> nextNode) {
  		this.data = data;
  		this.next = nextNode;
  	}

  	// copy constructor: only copy the data field , but not the next field
  	public Node(Node<E> node) {
  		this.data = node.getData();
  		this.next = null; 	
  	} 

  	public void setData(E data) {
  		this.data=data;
  	}

  	public E getData() {
  		return data;	
  	}

  	public Node<E> getNext() {
  		return next;	
  	}

  	public void setNext(Node<E> nextNode) {
  		next=nextNode;
  	}

  	public String toString() {
  		return "<"+data.getClass().getSimpleName()+"> "+data;
  	}


}

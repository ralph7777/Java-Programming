package StackQueue;

public class List<E> {

	Node<E> head;

 	// default constructor: create an empty List , with head = null
	public List() {
		head=null;
	}

	// create a List with a single Node node
	public List(Node<E> node) {
        head=node;	
        head.next=null;
	}

 	// deep copy of List
	public List(List<E> other){
		if (other.getHead()==null) head=null;
		else {
			head=new Node<E>(other.getHead());
			Node<E> nodeOther=other.getHead();
			Node<E> nodeThis=head;
			while (nodeOther.next != null) {
				nodeThis.next=new Node<E>(nodeOther.next);
				nodeOther=nodeOther.next;
				nodeThis=nodeThis.next;
				}
				nodeThis.next=null;
			}
		}

	// create a linked List from a given int array	
	public List(E [] arr){
		if (arr.length==0) head=null;
		else {
			head=new Node<E>();
			Node<E> cur=head;
			for (int j=0; j<(arr.length-1); j++) {
				cur.setData(arr[j]);
				Node<E> s=new Node<E>();
				cur.setNext(s);
				cur=cur.getNext();
			}
			cur.setData(arr[arr.length-1]);
			cur.setNext(null);
		}
	}	


  	public Node<E> getHead() {
		return head;
	}

	// return number of Nodes in the List
	public int count() { 
		int i=0;
		Node<E> cur=head;
		while (cur!=null) {
			i++;
			cur=cur.next;
			}
		return i;
	}


	// reverse the order of this List
	public void reverse() {
		Node<E> pre=null;
		Node<E> cur=head;
		Node<E> nex;
		while (cur!=null) {
			nex=cur.getNext();
			cur.setNext(pre);
			pre=cur;
			cur=nex;
		}
		head=pre;
	}
	

	
	/**	returns a reverse linked List of the given List lst
	 */
   	public static List reverse(List lst) {
    		List rlist=new List(lst) ;
    		rlist.reverse();
    		return rlist;
	}

	/**	remove and return the first Node of the List
	 */
	public Node<E> removeFromHead()  {
		Node<E> first=head;
    		if (head!=null) {
    			Node<E> second=head.getNext();
    			head=second;
    		}
    		return first;
   	}  
    
	/**	remove and return the last Node of the List
	 */
	public Node<E> removeFromTail() {
		Node<E> cur=head;
		Node<E> nex=cur.getNext();
		while (nex.getNext()!=null) {
			cur=cur.getNext();
			nex=nex.getNext();
		}
		cur.setNext(null);
		return nex;
	}
	
	/**	insert a node in front of the first node of the List
	 */		
	public void insertFront(Node<E> node) {
		node.setNext(head);
		head=node;
	}
	
	/**	insert a node to the end of the last node of the List
	 */			
	public void insertLast(Node<E> node)  {
    		Node<E> cur=head;
    		if (cur==null) head=node;
    		else {
	   	 	while (cur.getNext()!=null) {
	    			cur=cur.getNext();
	    		}
	    		cur.setNext(node);
    		}
   	 }
	
}

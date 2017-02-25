package StackQueue;

class Testdriver {

  	public static void main(String[] args) {
  		
  		System.out.println("Test for Node class:");
  		//test constructors
  		Node<Integer> node1=new Node<Integer>(1);
  		Node<Integer> node3=new Node<Integer>(3);
  		Node<Integer> node2=new Node<Integer>(2,node3);
  		Node<Integer> node4=new Node<Integer>(node3);
  		
  		Node<Character> node5=new Node<Character>('a');
  		Node<String> node6=new Node<String>("hello");
	
  		//test set and get
  		node4.setData(4);
  		node1.setNext(node2);
		node3.setNext(node4);  		
		Node<Integer> cur=node1;
		for (int i=0;i<4;i++) {
			System.out.printf("The value of node%d is %d.\n",i+1,cur.getData());
			cur=cur.getNext();
		}
  		System.out.printf("The value of node5 is %c.\n",node5.getData());
  		System.out.printf("The value of node6 is %s.\n",node6.getData());

		//test toString
  		System.out.println();
  		System.out.println("The string representation of each node:");
  		System.out.println(node1);
  		System.out.println(node2);
  		System.out.println(node3);
  		System.out.println(node4);
  		System.out.println(node5);
  		System.out.println(node6);
  		System.out.println();
		System.out.println();
  		
  		
  		
  		System.out.println("Test for List class:");
	  	//test constructors
	  	Node<Integer> node1b=new Node<Integer>(100);	  		
	  	List<Integer> list1=new List<Integer>(node1b);
	  	System.out.printf("The head of list1 is %s.\n",list1.head);
		System.out.println();
		
	  	Integer[] arr1=new Integer[] {1,2,3,4};	
	  	List<Integer> list2=new List<Integer>(arr1);
	  	Node<Integer> cur1=list2.getHead();
	  	int i;
	  	System.out.print("list2: ");
		for (i=0;i<4;i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}
		System.out.println();
		
	  	List<Integer> list3=new List<Integer>(list2);
	  	cur1=list3.getHead();
	  	System.out.print("list3: ");
		for (i=0;i<4;i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}
		System.out.println();
		
	  	Character[] arr2=new Character[] {'a','b','c','d'};
	  	List<Character> list4=new List<Character>(arr2);
	  	Node<Character> cur2=list4.getHead();
	  	System.out.print("list4: ");
		for (i=0;i<4;i++) {
			System.out.printf("node%d %c ",i+1,cur2.getData());
			cur2=cur2.getNext();
			}
		System.out.println();
		
		//test count
		System.out.printf("The number of nodes in list2 (Integer data) is %d.\n",list3.count());
		System.out.printf("The number of nodes in list4 (Character data) is %d.\n",list4.count());
		System.out.println();
		
		//test reverse			
		list2.reverse();
		cur1=list2.getHead();
			System.out.print("reversed list3: ");
		for (i=0;i<4;i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}
		System.out.println();
			
		List list5=List.reverse(list4);
		cur2=list5.getHead();
	  	System.out.print("reversed list4(list5): ");
		for (i=0;i<4;i++) {
			System.out.printf("node%d %s ",i+1,cur2.getData());
			cur2=cur2.getNext();
			}
		System.out.println();
		System.out.println();
			
		//test remove and add
		Node<Integer> node2b=list3.removeFromHead();
		System.out.printf("The number of nodes in list3 after removeFromHead is %d.\n",list4.count());
		System.out.printf("The removed node is %s.\n",node2b);
	  	cur1=list3.getHead();
	  	System.out.print("current list3: ");
		for (i=0;i<list3.count();i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}
		System.out.println();
		System.out.println();
			
		Node<Integer> node3b=list3.removeFromTail();
		System.out.printf("The number of nodes in list3 after removeFromTail is %d.\n",list3.count());
		System.out.printf("The removed node is %s.\n",node3b);
	  	cur1=list3.getHead();
	  	System.out.print("current list3: ");
		for (i=0;i<list3.count();i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}
		System.out.println();
		System.out.println();
					
		list3.insertFront(node2b);
		System.out.printf("The number of nodes in list3 after insertFront is %d.\n",list3.count());
		System.out.printf("The inserted node is %s.\n",node2b);
	  	cur1=list3.getHead();
	  	System.out.print("current list3: ");
		for (i=0;i<list3.count();i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}	
		System.out.println();
		System.out.println();
			
		list3.insertLast(node3b);
		System.out.printf("The number of nodes in list3 after insertLast is %d.\n",list3.count());
		System.out.printf("The inserted node is %s.\n",node3b);
	  	cur1=list3.getHead();
	  	System.out.print("current list3: ");
		for (i=0;i<list3.count();i++) {
			System.out.printf("node%d %d ",i+1,cur1.getData());
			cur1=cur1.getNext();
			}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
  		System.out.println("Test for Stack class:");
    	//test constructor and isEmpty
    	Stack<Integer> s1=new Stack<Integer>();
    	Stack<String> s2=new Stack<String>();
    	System.out.println("The initial s1 is empty: "+s1.isEmpty());
    	System.out.println("The initial s2 is empty: "+s2.isEmpty());
		
    	//test push
    	s1.push(4);
    	System.out.println("s1 after push is empty: "+s1.isEmpty());
		System.out.println();
		
		System.out.println("After push, two Stack:");    	
    	s1.push(3);
    	s1.push(2);
    	s1.push(1);
  		System.out.print("s1: ");
  		s1.displayStack();
		System.out.println();
		
    	s2.push("?");
    	s2.push("you");
    	s2.push("are");
    	s2.push("How");    	
  		System.out.print("s2: ");
  		s2.displayStack();
		System.out.println();
		System.out.println();
		
		
		//test pop
		Integer n1=s1.pop();
		System.out.printf("The pop node is %d\n",n1);
  		System.out.print("s1 after pop: ");
  		s1.displayStack();
		System.out.println();
		
		String n2=s2.pop();
		System.out.printf("The pop node is %s\n",n2);
  		System.out.print("s2 after pop: ");
  		s2.displayStack();
		System.out.println();
		System.out.println();
		
		//test peek
		Integer n3=s1.peek();
		System.out.printf("The peek node is %d\n",n3);
  		System.out.print("s1 after peek: ");
  		s1.displayStack();
		System.out.println();
		System.out.println();
		
		String n4=s2.peek();
		System.out.printf("The peek node is %s\n",n4);
  		System.out.print("s2 after peek: ");
  		s2.displayStack();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
  		System.out.println("Test for Queue class:");
    	//test constructor and isEmpty
    	Queue<Integer> q1=new Queue<Integer>();
    	System.out.println("q1 is empty: "+q1.isEmpty());
    	Queue<String> q2=new Queue<String>();
    	System.out.println("q2 is empty: "+q2.isEmpty());
    	System.out.println();
		
    	//test addQ and displayQueue    	
    	q1.addQ(1);
    	System.out.println("q1 after addQ is empty: "+q1.isEmpty());

    	q1.addQ(2);
    	q1.addQ(3);
    	q1.addQ(4);
  		System.out.print("q1 after addQ: ");
    	q1.displayQueue();
    	System.out.println();
    	
    	q2.addQ("King"); 
    	q2.addQ("of");
    	q2.addQ("the");
    	q2.addQ("world");
  		System.out.print("q2 after addQ: ");
    	q2.displayQueue();
    	System.out.println();    	
    	System.out.println();  
    	
    	//test deleteQ
    	Integer n1d=q1.deleteQ();
		System.out.printf("The deleted value is %d\n",n1d);
  		System.out.print("q1 after deleteQ: ");
    	q1.displayQueue();
    	System.out.println();
    	
    	String n2d=q2.deleteQ();
		System.out.printf("The deleted value is %s\n",n2d);
  		System.out.print("q2 after deleteQ: ");
    	q2.displayQueue();
    	System.out.println();
  	}
}

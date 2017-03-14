package dijkstra;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class GraphD {
	
	//Field Summary:
	//countV: 	the number of vertices in graph;
	//graph:	the adjacent lists for storing the info of a graph;
	//parent:	store the parent vertex info;
	//distance:	store the distance from starting point to certain vertex;
	//flag:		store the info on whether a vertex is included in built-up tree or not;
	//heap:		store the pair of a vetex and its distance in a Heap.
	private int countV;	
	
	private ArrayList< ArrayList<Info> > graph = new ArrayList<ArrayList<Info>>(countV);

	private ArrayList<Character> parent = new ArrayList<Character>(countV);
	private ArrayList<Integer> distance = new ArrayList<Integer>(countV);
	private ArrayList<Boolean> flag = new ArrayList<Boolean>(countV);
	private PriorityQueue<Info> heap;
	
	
	/** constructor to create a graph using adjacent lists    
	 * @param fname : input file name, like "Case1.txt"
	 */
	public GraphD(String fname){
		Scanner in=null;
		try {
			in = new Scanner(new File(fname));
		}catch(IOException ex){
			System.out.print("ERROR:"+ex);
		}
		
		countV=in.nextInt();
		for (int i=0; i<countV; i++) {
			ArrayList<Info> vList=new ArrayList<Info>();
			Info v=new Info((char) (i+65),0);
			vList.add(v);
			graph.add(vList);
		}
		String blankline=in.nextLine();

		while (in.hasNextLine()) {
			// read the edge info
			String line=in.nextLine();
			
			String [] record = line.split("\\s+");
			char tail=record[0].charAt(0);
			char head=record[1].charAt(0);
			int weight = Integer.parseInt(record[2]);
				
			//add the edge to graph
			int tailId=((int) tail)-65;
			Info edge=new Info(head,weight);
			graph.get(tailId).add(edge);
		}
		
//		Test if the input is valid:
//		for (int i=0; i<countV; i++) {
//			int len=graph.get(i).size();
//			for (int j=0; j<len; j++) {
//				System.out.printf("%s, %s, %d %n",graph.get(i).get(0).getVertex(),
//						graph.get(i).get(j).getVertex(), graph.get(i).get(j).getWeight());
//			}
//		}
	}
	
	/** instance method getgraph, provide an access to the graph info
	 *  @return the adjacent list for a graph
	 */	
	public ArrayList< ArrayList<Info> > getgraph() {
		return graph;
	}
	
	//The Dijsktra's Algorithm:
	//step1: initialize parent, distance and flag:
	//       set all parent to 'blank', flag to flase, distances to infinity
	//		 except the starting point, set its distance to 0;
	//step2: add all the vertex + distance pairs to heap;
	//step3: while heap is not empty, poll the heap (which retrieves and removes the Min), 
	//		 set its flag to true, then check all neighbors of the pop-out vertex v , 
	//		 if any point's distance is greater than the the distance of v plus the weight
	//		 of edge connecting them, update its distance with smaller one, 
	//		 set its parent to v, also decrease its distance in heap.
	//step4: iterate step 3 till the heap becomes empty.
	
	/** instance method RunDijkstra: run Dijkstra Algorithm on a graph
	 * @param source: the chosen starting vertex in graph
	 */
	public void RunDijkstra(char source){
		
		//step1:
		Comparator<Info> comparator=new InfoComparator();
		heap=new PriorityQueue<Info>(countV, comparator);
		
		for (int i=0;i<countV;i++) {
			parent.add(i, ' ');
			if (i==((int) source)-65) {
				distance.add(i,0);
			}
			else {
				distance.add(i,Integer.MAX_VALUE);
			}
			flag.add(i,false);
			
			//step2:
			Info vertex=new Info((char) (i+65), distance.get(i));
			heap.add(vertex);
		}
		
		//step 3 and 4:
		ArrayList<Character> polled=new ArrayList<Character>();
		while (!heap.isEmpty()) {
			
			Info minV=heap.poll();
			if (polled.contains(minV.getVertex())) {
				continue;
			}
			else {
				polled.add(minV.getVertex());
				int id=((int) minV.getVertex())-65;
				int weight=minV.getWeight();
				flag.set(id, true);
				
				for (Info edge:graph.get(id)) {
					char tail=edge.getVertex();
					int tailId=((int) tail)-65;
					
					if (!flag.get(tailId) && id!=tailId) {
						int tailWeight=distance.get(tailId);
						int edgeWeight=edge.getWeight();
						
						if (tailWeight > (weight+edgeWeight)) {
							distance.set(tailId, weight+edgeWeight);
							parent.set(tailId, minV.getVertex());
							
							Info v=new Info(tail,distance.get(tailId));
							heap.add(v);
						}
					}

				}
			}
			
		}
		
	}
	
	//After running the algorithm, the distance list contains the minimum distance info,
	//while the parent list contains the shortest path route info to any vertices. 
	
	/** instance method ShortestPath: compute the weight of shortest path to any vertex
	 * @param dest: the termination point in graph
	 * @return the sum of weight along a shortest path 
	 */
	public int ShortestPath (Character dest) {
		return distance.get(((int) dest)-65);
	}
	
	
	/** instance method Route: display the sequence of vertices on a shortest path.
	 * @param source: the starting point in graph
	 * @param dest: the termination point in graph	
	 */
	public void Route (Character source, Character dest) {
		ArrayList<Character> route = new ArrayList<Character>();
		route.add(dest);
		while (dest!=source) {
			int destId=((int) dest)-65;
			Character par=parent.get(destId);
			dest=par;
			route.add(dest);
		}
		for (int i=(route.size()-1); i>=0; i--) {
			System.out.printf("%s ", route.get(i));
		}
	}
	
}

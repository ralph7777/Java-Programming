package dijkstra;

import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char source='A';
		char dest='B';
		do {
			System.out.println("Please enter a complete file name of test case");
			System.out.println("Case1.txt     Case2.txt     Case3.txt");
			String fname=input.next();
			
			GraphD graphD=new GraphD(fname);
			graphD.RunDijkstra(source);
			
			int weight=graphD.ShortestPath(dest);
			System.out.printf("From %s to %s, the weight of a shortest path: %n",source,dest);
			System.out.printf("The sequence of vertieces: %n");
			System.out.println(weight);
			graphD.Route(source, dest);
			System.out.printf("%n%nDo you want to test another case? (y) %n");
		} while ("y".equals(input.next()));
		input.close();
	}
}


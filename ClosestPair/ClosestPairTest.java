package ClosestPair;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/** The test driver
 */	
public class ClosestPairTest {

	public static void main(String[] paramArrayOfString) {
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please enter the complete file name containing the points you wanna test:");
			System.out.println("10points.txt     100points.txt     1000points.txt");
			String fname=input.next();
			
			PointsSet pset=new PointsSet(fname);
			System.out.printf("There are total %d points.%n",pset.getpoints().size());		
			
			ArrayList<Point> pointsx=PointsSet.SortX(pset);
			ArrayList<Point> pointsy=PointsSet.SortY(pset);
			
			
			Integer[] cp=PointsSet.ClosestPair(pointsx, pointsy);
			Point p1=pointsy.get(cp[0]);
			Point p2=pointsy.get(cp[1]);
			
			System.out.println("The minimum distance is:") ;
			System.out.printf("%.10f: (%d, %d)<--->(%d, %d)%n",PointsSet.Dist(p1, p2),p1.x,p1.y,p2.x,p2.y);
			System.out.println();
			System.out.print("Do you want to test another file? (y) ");
			} while ("y".equals(input.next()));
	
		input.close();
	}
}

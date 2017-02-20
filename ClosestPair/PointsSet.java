package ClosestPair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

/** class PointsSet
 */	
public class PointsSet {

	private ArrayList<Point> points = new ArrayList<Point>();
	
	
	/** constructor to create PointsSet    
	 * @param fname : input file name, like "10points.txt"
	 */
	public PointsSet(String fname){
		Scanner in=null;
		
		try {
			in = new Scanner(new File(fname));
		}catch(IOException ex){
			System.out.print("ERROR:"+ex);
		}
		while(in.hasNextInt()){
			Point p=new Point(in.nextInt(), in.nextInt());
			points.add(p);
			}
	}
	
	
	/** instance method getpoints
	 *  @return the points set as ArrayList
	 */	
	public ArrayList<Point> getpoints(){
		return points;
	}
	
	
	/** static method SortX: sort points in PointsSet according to x
	 * @param pset : an instance of PointsSet class
	 * @return a new ArrayList psetx containing the sorted points
	 */ 
	public static ArrayList<Point> SortX(PointsSet pset){
		ArrayList<Point> psetx = new ArrayList<Point>();
		psetx.addAll(pset.getpoints());
		Collections.sort(psetx, new ComparatorX());
		return psetx;
	}
    
	/** static method SortY: sort points in PointsSet according to y
	 * @param pset : an instance of PointsSet class
	 * @return a new ArrayList psety containing the sorted points
	 */ 
	public static ArrayList<Point> SortY(PointsSet pset){
		ArrayList<Point> psety = new ArrayList<Point>();
		psety.addAll(pset.getpoints());
		Collections.sort(psety, new ComparatorY());
		return psety;
	}
	
	
	/** static method ClosestPair: return the two points with minimum distance in a points set
	 * @param px: x-based sorted points set
	 * @param py: y-based sorted points set
	 * @return a two elements integer array containing indices of the two points in py
	 */
	public static Integer[] ClosestPair(ArrayList<Point> px, ArrayList<Point> py){

		//Algorithm:
		//step1: input 2 array of pointsset, one is x-sorted px, one is y-sorted py
		//       (in recursive call, keep upating px as the sublist of previous px)
		//step2: divide px to halves [0,(n-1)/2],[(n+1)/2,n-1], compute the minDist of two sub-px px1, px2, store in minDist
		//step3: iterate through py, for x in [midx-minD,midx+minD], compute the distance between it and following 7 points (if there is any)
		//	     store the minimum distance in dist3
		//step4: compare minDist and dist3, record two points with min dist as a,b
		//step5: base case1--size of px=3, compute all dist, record two points with min dist as a,b
		//       bast case2--size of px=2, record two points as a,b
		//step6: return an array of size two containing the indices of points a, b
		
		int nx=px.size();
		int n=py.size();
		
		Point a=px.get(0); // base case of size 2
		Point b=px.get(1); // base case of size 2
		double minDist;
		
		if (nx>=4) {
			//find the minDist of two sublist
			int mid=(nx-1)/2;
			int midx=px.get(mid).x;
			
			ArrayList<Point> px1=new ArrayList<Point>(px.subList(0, mid+1));
			Integer[] cp1 = PointsSet.ClosestPair(px1, py);
			double dist1=PointsSet.Dist(py.get(cp1[0]),py.get(cp1[1]));
						
			ArrayList<Point> px2=new ArrayList<Point>(px.subList(mid+1,nx));
			Integer[] cp2 = PointsSet.ClosestPair(px2, py);
			double dist2=PointsSet.Dist(py.get(cp2[0]),py.get(cp2[1]));
			
			if (dist1 <= dist2) {
				minDist=dist1;
				a=py.get(cp1[0]);
				b=py.get(cp1[1]);
			}
			else {
				minDist=dist2;
				a=py.get(cp2[0]);
				b=py.get(cp2[1]);
			}

			//find the minDist in middle area
			double dist3=minDist;
			Point a1,a2=a;
			Point b1,b2=b;
			for (int k=0;k<n-1;k++) {  //despite the last point in py
				int pyx=py.get(k).x;
				if ( pyx <= (midx+minDist) && pyx >= (midx-minDist) ) {
					a1=py.get(k);
					b1=py.get(k+1);
					double dist4=PointsSet.Dist(a1,b1);
					for (int m=k+2;m<k+8;m++) {
						if (m<n) {  //not exceed the length of py
							double dist5=PointsSet.Dist(a1,py.get(m));	
							if (dist5<dist4) {
								b1=py.get(m);
								dist4=dist5;
							}
						}
						else break;
					}
					if (dist4<dist3) {
						a2=a1;
						b2=b1;
						dist3=dist4;
					}
				}
			}
			
			//update the two points 
			if (dist3 < minDist) {
				a=a2;
				b=b2;
			}
		}
		
		else if (nx==3){ // base case of size 3
			minDist=PointsSet.Dist(px.get(0),px.get(1));
			for (int i=0;i<3;i++) {
				for (int j=i+1;j<3;j++){
					double dist = PointsSet.Dist(px.get(i),px.get(j));
					if (dist < minDist) {
						minDist=dist;
						a=px.get(i);
						b=px.get(j);						
					}
				}
			}
		}
		
		Integer[] cp={py.indexOf(a),py.indexOf(b)}; //return indices of two points
		return cp;
	}
	
	
	/** static method Dist: return the distance between point A and B
	 *  @param A : 1st point
	 *  @param n : 2nd point
	 *  @return  the distance between two points
	 */
	public static double Dist(Point p1, Point p2){
		int px = p1.x - p2.x;
		int py = p1.y - p2.y;
		return Math.sqrt(px * px + py * py);
	}

}
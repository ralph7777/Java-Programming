package ClosestPair;

import java.awt.Point;
import java.util.Comparator;

/** Comparator to sort points according to x
 */	
public class ComparatorX implements Comparator<Point> {  
    @Override  
    public int compare(Point p1, Point p2) {  
        if (p1.x > p2.x) {  
            return 1;  
        	}  
        else if (p1.x < p2.x) {  
            return -1;  
        	}  
        else {  
            return 0;  
        	}  
    }  
} 

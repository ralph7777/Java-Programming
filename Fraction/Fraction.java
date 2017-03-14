
import java.util.Scanner;

public class Fraction {

	static Scanner sc = new Scanner(System.in);
	private int numerator ;
	private int denominator ;
	
	/** 
         * accessor : get Numerator and get Denominator  
   	 * @return numerator , denominator
         */
	public int getNumer() {
		return numerator;
	}
	public int getDenom() {
		return denominator;
	}
	
	/* constructors   */
	/** default constructor  : 0/1  */
	public Fraction(){
		numerator = 0;
		denominator = 1;
	}
	/** constructor for n/1   
	 * @param n ; serves for numerator and denomator = 1
	 */
	public Fraction(int n){
		numerator = n;
		denominator = 1;
	}
	/** constructor :  numer/denom     
	 * @param numer provides the value for numerator
  	 * @param denom provides the value for denominator
	 */
	public Fraction(int numer, int denom){
		numerator = numer;
		denominator = denom;
		reduce();
	}

	/** copy constructor    
	 * @param other : instantiate a Fraction as other

	 */
	public Fraction(Fraction other){
		numerator = other.getNumer();
		denominator = other.getDenom();
	}
	
	/** reduce() : simply the fraction and keep the sign with numerator

	 */
	private void reduce(){  
		if (denominator < 0) {
			denominator = -denominator;
			numerator = -numerator;
		}
		int cd = gcd(numerator,denominator);
		numerator /= cd;
		denominator /= cd;
	}

	/** finding the greatest common divisor 
	 *  @param n , 1st integer operand
	 *  @param m , 2nd integer operand
	 *  @return the greatest common divisor of n and m
	 */

	private int gcd(int n, int m){
		if (n < 0) n = -n;
		if (m < 0) m = -m;
		if (m == 0) return n;
		if (n < m) return gcd(m,n);
		else return gcd(m,n%m); 
	}
	
	/** overload the toString() of the Object class 
          * returns the string representation of fraction
          * if denominator is 1, only the numerator will be present 
	  * @return s String format of the fraction
	 */

	@Override public  String toString(){
		String s = String.valueOf(numerator);
		if (denominator == 1) {
			return s;
		}
		return s+"/" + denominator;
	}
	
	/** return true if the Fraction is indeed 0 false else  
	 *  @return true if this fraction is 0 and false elsewise
	 */
	public boolean isZero(){
		return numerator == 0;
	}

	/** instance method add: returns the fraction as the result of (this + other)
	  *  @param other , 2nd fraction operand for addion
	  *  @return (this + other)
	 */
	public Fraction add (Fraction other){
		int a = numerator;
		int b = denominator;
		int c = other.getNumer();
		int d = other.getDenom();
		Fraction result = new Fraction((a*d+b*c),b*d);
		return result;
	}
	
	/** instance method add: returns the fraction as the result of (this + n)
	 *  @param n , an integer
	 *  @return (this =n)
	 */
	public Fraction add(int n) {
		int a = numerator;
		int b = denominator;
		Fraction result = new Fraction(a+b*n,b);
		return result;
	}

	/** instance method minus: returns the fraction as the result of (this - other)
	 *  @param other 2nd operand of subtraction
	 *  @return (this - other)
	 */
	public Fraction minus (Fraction other){
		int a = numerator;
		int b = denominator;
		int c = other.getNumer();
		int d = other.getDenom();
		Fraction result = new Fraction((a*d-b*c),b*d);
		return result;
	}
	
	/** instance method minus: returns the fraction as the result of (this - n)
	 *  @param n : integer operand
	 *  @return (this - n)
	 */
	public Fraction minus(int n) {
		int a = numerator;
		int b = denominator;
		Fraction result = new Fraction(a-b*n,b);
		return result;
	}

	/** instance method times: returns the fraction as the result of (this * other)
	 *  @param other 2nd operand for the addition
	 *  @return (this*other)
	 */
	public Fraction times (Fraction other){
		int a = numerator;
		int b = denominator;
		int c = other.getNumer();
		int d = other.getDenom();
		Fraction result = new Fraction(a*c,b*d);
		return result;
	}

	/** instance method times: returns the fraction as the result of (this*n)
	 *  @param n :  multiplier
	 *  @return n*(this)
	 */
	public Fraction times(int n) {
		Fraction result = new Fraction(numerator*n,denominator);
		return result;
	}

	/** instance method divides: returns the fraction as the result of (this/other)
	  * @param other 2nd fraction operand of the division
	  * @return (this/other)
	 */
	public Fraction divides (Fraction other){
		int a = numerator;
		int b = denominator;
		int c = other.getNumer();
		int d = other.getDenom();
		Fraction result = new Fraction(a*d,b*c);
		return result;	
	}
	
	/** instance method divides: returns the fraction as the result of (this/n)
	 *   @param n : integer operand
	 *   @return (this/n)
	 */
	public Fraction divides(int n) {
		Fraction result = new Fraction(numerator,denominator*n);
		return result;		
	}
	
	/** static method add: returns the fraction as the result of (f1+ f2)
	 *  @param f1  1st operand
	 *  @param f2  2nd operand
	 *  @return (f1+f2)
	 */
	public static Fraction add(Fraction f1, Fraction f2){
		return f1.add(f2);
	}
	
	/** static method add: returns the fraction as the result of (f1+ n) where n is an integer
	 * @param f1  first operand , a fraction
	 * @param n , 2nd operand ,  a fraction
	 * @return (f1+n)
	 */ 
	public static Fraction add(Fraction f1, int n){
		return f1.add(n);
 	}

	/** static method add: returns the fraction as the result of (n + f1) where n is an integer
	 *  @param n : 1st operand , an integer
	 *  @param f1 : 2nd operand, a Fraction
	 *  @return (n+f1)
 	 */
	public static Fraction add(int n , Fraction f1){
		return f1.add(n);
	}

	/** static method minus: returns the fraction as the result of (f1-f2)
	 *  @param f1  first operand
	 *  @param f2  f2  second parand
	 *  @return (f1-f2)
	 */
	public static Fraction minus(Fraction f1, Fraction f2){
		return f1.minus(f2);
	}

	/** static method minus: returns the fraction as the result of (f1 - n) where n is an integer
	  * @param f1 , 1st operand , a fraction
	  * @param n , 2nd operand , an integer
	  * @return  (f1-n)
	 */
	public static Fraction minus(Fraction f1, int n){
		return f1.minus(n);
	}

	/** static method minus: returns the fraction as the result of (n - f1) where n is an integer
	 *  @param n : 1st operand, an integer
	 *  @param f1: 2nd operand, a Fraction
	 *  @return (n-f1)
	 */
	public static Fraction minus(int n , Fraction f1){
		return add(-n , f1);
	}

	/** static method times: returns the fraction as the result of (f1*f2)
	 *  @param  f1 : ist fraction operand
	 *  @param  f2 : 2nd fraction operand
	 *  @return (f1*f2)
	 */
	public static Fraction times(Fraction f1, Fraction f2){
		return f1.times(f2);	
	}
	
	/** static method times: returns the fraction as the result of (f1*n) where n is an integer 
	 *  @param f1  : 1st operand a fraction
	 *  @param n   : 2nd operand an integer
	 *  @return (f1*n)
	 */
	public static Fraction times(Fraction f1, int n){
		return f1.times(n);	
	}

	/** static method times: returns the fraction as the result of (n*f1) where n is an integer 
	  * @param n : 1st operand, integer
	  * @param f1 : 2nd operand , fraction
	  * @return n*f1
	 */
	public static Fraction times(int n , Fraction f1){
		return f1.times(n);	
	}
	
	/** static method divides: returns the fraction as the result of (f1/f2) where f2 != 0
	 * @param f1 1st operand
	 * @param f2 2nd operand
	 * @return (f1/f2)
	 */
	public static Fraction divides(Fraction f1, Fraction f2){
		return f1.divides(f2);		
	}

	/** static method divides: returns the fraction as the result of (f1/n) where n != 0
	 *  @param f1 : 1st operand , a fraction
	 *  @param n : 2nd operand, integer value
	 *  @return   f1/n
	 */
	public static Fraction divides(Fraction f1, int n){
		return f1.divides(n);		
	}

	/** static method divides: returns the fraction as the result of (n/f1) where f1 != 0
	  * @param n : integer operand
	  * @param f1 : Fraction parameter
	  * @return n/f1
 	  */
	public static Fraction divides(int n , Fraction f1){
		int a = f1.getNumer();
		int b = f1.getDenom();
		return new Fraction(n*b,a);
	}

	/** instance method negate returns  -this  
	  * @return the negative of (this)
	  */
	public Fraction negate(){
		return new Fraction(-numerator,denominator);
	}

	/** static class method  negate(Fraction f) returns -f  
	 * @param f operand to be negate
	 * @return the negation of f
	 */
	public static Fraction negate(Fraction f){
	    return f.negate();
   	 }

	/** instance method  invert that returns the reciprocal of this ,  i.e.   1/this 
	 *  @return the reciprocal of (this) fraction
	 */
	public Fraction invert(){
		return new Fraction(denominator,numerator);
	}

	/** static  method invert(Fraction f) that returns the reciprocal of f ,  i.e.   1/f 
	 *  @param f :fraction
	 *  @return  the reiprocal of f
	 */
	public static Fraction invert(Fraction f){
		return f.invert();
	}

	/** instance method power(n) raise this to the power n 
	 *   @param n : exponent
	 *   @return (this)^n 
	 */
	public Fraction power(int n){
		int nabs = Math.abs(n);
		int a = numerator^nabs;
		int b = denominator^nabs;
		if (n>=0) return new Fraction(a,b);
		else return new Fraction(b,a);
	}

	/** static method power(Fraction f, int n) raise the fraction f to the power n, i.e  (f)^n 
	  * @param f  :base fraction
	  * @param n : exponent
 	  * @return f^n
	 */
	public static  Fraction power(Fraction f, int n){
		return f.power(n);
	}

	/** static method that returns true if  f1 less than f2  and false elsewise 
	 *  @param f1 1st operand
	 *  @param f2 2nd operand 
         *  @return true if f1 is less than f2 and false elsewise
	 */
	public static boolean less(Fraction f1, Fraction f2){
		return f1.less(f2);
	}
	
	/** instance  method that returns true if  this less than f2  and false elsewise
	 *  @param f2 as operands
	 *  @return true if f1 less than f2
	 */
	public boolean less(Fraction f2){
		int a = numerator;
		int b = denominator;	
		int c = f2.getNumer();
		int d = f2.getDenom();
		return a*d < b*c;
	}

	/** static method that returns true if  f1 greater f2  and false elsewise
	 *  @param f1 1st operand
	 *  @param  f2 as 2nd  operands
	 *  @return true if f1 less than f2 and false elsewise
	 */
	public static boolean greater(Fraction f1, Fraction f2){
		return f1.greater(f2);	
	}

	/** instance  method that returns true if  this greater than  f2  and false elsewise
	 *  @param  f2 as operands
	 *  @return true if f1 greater  than f2 and false elsewise	 
	 */
	public boolean greater(Fraction f2){
		int a = numerator;
		int b = denominator;	
		int c = f2.getNumer();
		int d = f2.getDenom();
		return a*d > b*c;	
	}

	/** instance method that returns true if this ==  f2  and false elsewise
	 *  @param  f2 as operands
	 *  @return true if f1 equal to f2 and false elsewise	 
	 */
	public boolean equal( Fraction f2){
		int a = numerator;
		int b = denominator;	
		int c = f2.getNumer();
		int d = f2.getDenom();
		return a*d == b*c;
	}
	
	/** static method that returns true if f1 ==  f2  and false elsewise
	 *  @param f1 1st operand
	 *  @param f2 as 2nd operands
	 *  @return true if f1 equal to f2 and false elsewise
	 */
	public static boolean equal(Fraction f1, Fraction f2){
		return f1.equal(f2);	
	}
	
	/** static method that returns f1 if f1 less than f2  and f2 will be returned  elsewise
	 *  @param f1  first operand 
	 *  @param f2  2nd operand
	 *  @return f1  if f1 less than f2 and f2 elsewise
	 */
	public static Fraction min(Fraction f1, Fraction f2){
		if (f1.less(f2)) return f1;
		else return f2;		
	}
	
	/** static method that returns f2 if f1 less than   f2  and f1 will be returned  elsewise
	 *  @param f1  operand 1
	 *  @param f2 operand 2
	 *  @return f2 if f1 less than f2 and f1 elsewise
	 */
	public static Fraction max(Fraction f1, Fraction f2){
		if (f1.less(f2)) return f2;
		else return f1;	
	}

	/** static method that reads a fraction from console  (System.in) and returns a Fraction object .
         *  String class split() method is used 
	 *  @return as a Fraction
    	 */
	public static Fraction getFraction(){
		
		String line;
		line = sc.nextLine() ;
		String pat="/ " ;
		String [] tokens = line.split("[ /]+");
		// String [] tokens = line.split(pat);		
		int numer;
		int denom;
		int sign = 1;

		if (tokens[0].equals("-")){
			sign = -1 ;
	   	 	numer = sign*Integer.parseInt(tokens[1]) ;

	   	 	if (tokens.length == 3) {
	    			denom = Integer.parseInt(tokens[2]);
	   	 	}else denom = 1 ;
		 }else {
			numer = Integer.parseInt(tokens[0]);
			if ( tokens.length == 2) denom = Integer.parseInt(tokens[1]);
			else denom = 1 ;
		}
		Fraction tmp = new Fraction(numer, denom) ;
		return tmp;
	}


	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Fraction f1 = new Fraction() ;
		Fraction f2 = new Fraction(2,4) ;
		Fraction f3 = new Fraction(2) ;

		System.out.println("f1 = " + f1 ); 
		System.out.println("f2 = " + f2 ); 
		System.out.println("f3 = " + f3 ); 

		System.out.print("Please enter the first fraction: ");
		f1 = getFraction() ;
		System.out.print("Please enter the second fraction: ");
		f2 = getFraction() ;
		System.out.println("You have enter " + f1+ " and" + f2);
	
		test0(f1,f2);
		test1(f1,f2);
		test2(f1,f2) ;
		test3(f1,f2) ;
		System.out.printf("The end.....\n\n") ;
 	}

	/** test the deep copy constructor  
	 *   @param f1 first operand
	 *   @param  f2 second operand
	 */
	public static void test0(Fraction f1, Fraction f2)  {
		Fraction f1c = new Fraction(f1);
		Fraction f2c = new Fraction(f2);		
		System.out.println("The deep copy of " + f1 + " is " + f1c);
		System.out.println("The deep copy of " + f2 + " is " + f2c);
	}

	/**  test the arithematic operations and min , max 
	 *   @param f1 first operand
	 *   @param  f2 second operand
	 *
	 */
	public static void test1(Fraction f1, Fraction f2){
		Fraction add1 = f1.add(f2);
		Fraction add2 = Fraction.add(f1, f2);
		Fraction minus1 = f1.minus(f2);
		Fraction minus2 = Fraction.minus(f1, f2);
		Fraction times1 = f1.times(f2);
		Fraction times2 = Fraction.times(f1, f2);
		Fraction divides1 = f1.divides(f2);
		Fraction divides2 = Fraction.divides(f1, f2);
		Fraction negate1 = negate(f1);
		Fraction negate2 = Fraction.negate(f1);
		Fraction negate3 = negate(f2);
		Fraction negate4 = Fraction.negate(f2);	
		Fraction minf = Fraction.min(f1, f2);
		Fraction maxf = Fraction.max(f1, f2);
		System.out.println(f1 + "+" + f2 + "=" + add1);
		System.out.println(f1 + "+" + f2 + "=" + add2);
		System.out.println(f1 + "-" + f2 + "=" + minus1);
		System.out.println(f1 + "-" + f2 + "=" + minus2);
		System.out.println(f1 + "*" + f2 + "=" + times1);
		System.out.println(f1 + "*" + f2 + "=" + times2);
		System.out.println(f1 + "/" + f2 + "=" + divides1);
		System.out.println(f1 + "/" + f2 + "=" + divides2);
		System.out.println("-" + f1 + "=" + negate1);
		System.out.println("-" + f1 + "=" + negate2);
		System.out.println("-" + f2 + "=" + negate3);
		System.out.println("-" + f2 + "=" + negate4);
		System.out.println("min(" + f1 + ", " + f2 +")=" + minf);
		System.out.println("max(" + f1 + ", " + f2 +")=" + maxf);
	}

	/** test those relational operations
	 * @param f1 first operand
	 * @param  f2 second operand
         */
	public static void test2(Fraction f1, Fraction f2){
		boolean l1 = f1.less(f2);
		boolean l2 = Fraction.less(f1,f2);
		boolean g1 = f1.greater(f2);
		boolean g2 = Fraction.greater(f1,f2);
		System.out.println(f1 + " less than " + f2 +" is: " + l1);
		System.out.println(f1 + " less than " + f2 +" is: " + l2);
		System.out.println(f1 + " greater than " + f2 +" is: " + g1);
		System.out.println(f1 + " greater than " + f2 +" is: " + g2);
	}

	/** test the power method  
	 * @param f1 first operand
	 * @param  f2 second operand
	 */
	public static void test3(Fraction f1, Fraction f2){
		int n1 = 2;
		int n2 = -5;
		Fraction p1 = f1.power(n1);
		Fraction p2 = Fraction.power(f2,n1);		
		Fraction p3 = f1.power(n2);
		Fraction p4 = Fraction.power(f2,n2);
		System.out.println(p1+ "=" + f1 + "^(" + n1 + ")");
		System.out.println(p2+ "=" + f2 + "^(" + n1 + ")");	
		System.out.println(p3+ "=" + f1 + "^(" + n2 + ")");
		System.out.println(p4+ "=" + f2 + "^(" + n2 + ")");
	}


}
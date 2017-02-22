import java.util.Stack;

public class Converter {

	
	/** InToPostfix: returns a postfix expression from a infix expression
	 *  @param infix : a String of infix expression
	 *  @return a String of postfix expression
	 */
	public static String InToPostfix (String infix) {

    	// assume that infix is the infix arithmetic expression and 
	// that stack will hold operators and is initially empty
		String[] tokens = infix.split("\\s+");
		Stack<String> stack = new Stack<String>();
		String operators = "+-*/^()";
		String postfix = new String("");
		
		for ( int i = 0 ; i < tokens.length ; i++ ) {
			String token = tokens[i];

			int id=operators.indexOf(token);
			// token is an operand
			if (id<0) {
				postfix= postfix + token + " ";
				}

			// token is "("
			else if (token.equals(")")) {
				// look for matching "("
				while (!stack.peek().equals("(")) {
					postfix= postfix + stack.pop() + " ";
					}
				stack.pop();
				// if token == ")" and top == "("
				}
			
			// token is an operator
			else {
				if (!stack.isEmpty()) {
					String a=stack.peek();
					String b=token;
					// if top prior to/equal to token, pop out
					while (TestPrior(a,b)) {      
						postfix= postfix + stack.pop() + " ";
						if (stack.isEmpty()) break;
						a=stack.peek();
						}
					}
				// if not, push in
				stack.push(token);
				}

			}
		
		// pop out the remains in stack
		while (!stack.isEmpty())  { 	
			postfix= postfix + stack.pop() + " ";
		    }

		return postfix;
		} 


	/** TestPrior: returns True if operator "a" has higher or equal priority than operator "b"
	 *  @param a : String of an operator
	 *  @param b : String of an operator
	 *  @return a Boolean value
	 */		
	public static Boolean TestPrior(String a, String b) {
		//a-top of stack; b-token 
		String lel1="^";
		String lel2="/*";
		String lel3="+-";
		if (b.equals("(")) return false;   //  "(" has highest incoming priority, a<b
		if (a.equals("(")) return false;   //  "(" has lowest instack priority, a<b
		if ((a.equals(lel1)) || (lel2.contains(a)&&!lel1.contains(b)) || (lel3.contains(a)&&lel3.contains(b)))
			//a=^, or a=/* while b!=^, or a=+- while b=+-
			return true;
		return false;
		}


	/** Eval: evaluating a postfix expression
	 *  @param postfix : String of a postfix expression
	 *  @return an Integer value
	 */	
	public static int Eval(String postfix) {
		String[] tokens = postfix.split("\\s+");
		Stack<Integer> stack=new Stack<Integer>();
		String operators = "+-*/^";
		
		for ( int i = 0 ; i < tokens.length ; i++ ) {
			String tokenStr = tokens[i];
			
			if (!operators.contains(tokenStr)) {   
				// token is an operand, push in 
				int token=Integer.valueOf(tokenStr);
				stack.push(token);
				}

			else {
				// token is an operator, pop two values and evaluate
				int b=stack.pop();
				int a=stack.pop();
				stack.push(Operator(a,b,tokenStr));
				}
			}
		return stack.pop();
	}
	
	/** Operator: evaluating from String operator
	 *  @param a : first Integer number
	 *  @param b : second Integer number
	 *  @param op : a String representing an operator
	 *  @return Integer value of expression= a op b
	 */	
	public static int Operator(int a, int b, String op) {
		int result;
		switch (op) {
			case "+": result=a+b;
				break;
			case "-": result=a-b;
				break;
			case "*": result=a*b;
				break;
			case "/": result=a/b;
				break;
			case "^": result=(int) Math.pow((double) a, (double) b);
				break;
			default: result=0;			
		}
		return result;
	}
	

	//Test driver
	public static void main (String[] args){
		
		String in1="a + b - c * d ^ f / g  + h";
		String in2="( a + b  ) ^ ( c - d ) * ( e + f ) / ( g -  h )";
		String in3="( 12 + 32 ) * ( 5  -  12 ) ";
		String in4="( 11 + 21 - 3 * 2 ^ ( 44 - 42 ) ) / 2 * 9 + 10";
		
		System.out.println("The infix expression: " + in1);
		String po1=InToPostfix(in1);
		System.out.println("The postfix expression: "+ po1);
		System.out.println();
		
		System.out.println("The infix expression: " + in2);
		String po2=InToPostfix(in2);
		System.out.println("The postfix expression: "+ po2);
		System.out.println();
		
		System.out.println("The infix expression: " + in3);
		String po3=InToPostfix(in3);
		System.out.println("The postfix expression: "+ po3);
		System.out.printf("The evaluating result is %d \n",Eval(po3));
		System.out.println();
		
		System.out.println("The infix expression: " + in4);
		String po4=InToPostfix(in4);
		System.out.println("The postfix expression: "+ po4);
		System.out.printf("The evaluating result is %d \n",Eval(po4));
	}
	
}

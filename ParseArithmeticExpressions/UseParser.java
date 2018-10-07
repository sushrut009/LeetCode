package com.parse.arith;

import java.util.Stack;

public class UseParser {
    
	public static int operation(int a, int b,char ch) {
		if(ch== '+') 
			return a+b ;
		else if (ch == '-') 
			return a-b;
		else if (ch == '*') 
			return a*b ;
		else if (ch == '/')
			return b/a ;
		else 
			return 0 ;
        
		}
		
	
	
	
	public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  Stack<Integer> S = new Stack<Integer>();
	  ConvertInfixToPostfix C1 = new ConvertInfixToPostfix("2345-*+");
	  C1.PerformConversion();
	  String post = C1.getPostfix_string();
	  System.out.println(post);
	  int a ;
	  int b ;
	  int c;
	  for(int i=0;i<post.length();i++) {
	    if(C1.isOperator(C1.getPostfix_string().charAt(i))) {
	      a = S.pop();
	      b = S.pop();
	      c = operation(a,b,C1.getPostfix_string().charAt(i));
	      S.push(c);
	    } else {
	      S.push(Character.getNumericValue(C1.getPostfix_string().charAt(i)));
            }
          }
		
		
      }

}

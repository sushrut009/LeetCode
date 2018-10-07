package com.stack.delimiter;
import java.util.Stack ;
public class DelimiterMatching {
	private Stack<Character> S1 = new Stack<Character>(); // This is the stack used in our program
	
	public boolean match_delimiters(char opening_delimiter , char closing_delimiter) {
		if(opening_delimiter =='[' && closing_delimiter == ']') 
			return true ;
		else if(opening_delimiter=='{' && closing_delimiter == '}' ) 
			return true ;
		else if(opening_delimiter=='(' && closing_delimiter == ')') 
			return true ;
		else 
			return false ;		
	}
	
	
   public boolean delimit_match(String s) {
	   char c ;
	   boolean match ;
	   for(int i=0;i<s.length();i++) {
		   if(s.charAt(i)== '[' || s.charAt(i)== '{' || s.charAt(i)== '(' ) {
			   S1.push(s.charAt(i));
		   } else if(s.charAt(i)==']' || s.charAt(i)=='}' || s.charAt(i) == ')' ) {
			   if(!S1.isEmpty()) {  
			     c = S1.pop() ;
			     match = match_delimiters(c,s.charAt(i));
			     if(match== true)
				   continue ;
			     else
				   return false ; 
			   } else 
				   System.out.println("Delimiters not matching");
				   return false ;
		   } else 
			   continue;
	   }
	   
	   if(S1.isEmpty()) {
		   System.out.println("Correct : delimiters matched");
		   return true ;
	   } else {
		   System.out.println("Not correct : Delimiters not matched");
		   return false;
	   }
   }
	
	
	 

	
	
}

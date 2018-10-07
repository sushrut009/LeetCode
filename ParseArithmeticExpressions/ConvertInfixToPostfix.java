package com.parse.arith;
import java.util.*;
public class ConvertInfixToPostfix { // It is easier for an algorithm to process PostFix notation
  private String infix_string ;
  private String postfix_string ;
  private Stack<Character> my_stack;
  private Stack<Integer> S = new Stack<Integer>();
  
  
  public Stack<Integer> getS() {  //Getter method 
    return S;
  }

  public void setS(Stack<Integer> s) { //Setter
    S = s;
  }

  public ConvertInfixToPostfix(String my_string) { // This routing converts an expression given in Infix notation to Postfix
    infix_string = my_string ;
    postfix_string = "" ;
    my_stack = new Stack<Character>();
  }
  
  public Stack<Character> getMy_stack() {
	return my_stack;
  }

  public void setMy_stack(Stack<Character> my_stack) {
    this.my_stack = my_stack;
  }


  //Valid characters are '+' , '-' , '*' , '/' , '(' , ')'
  public boolean isOperator(char c) {
    switch(c) {
      case '+' :
      case '-' :
      case '*' :
      case '/' :
        return true ;
      default  :
	return false ;
	  }
  }
  
  public boolean isVariable(char c) {
    if(Character.isLetter(c)) {
      return true ;
    } else {
      return false ;
    }
  }
  
  public boolean isParenthesis(char c) {
    if(c == '(' || c== ')' ) {
      return true ;
    } else {
      return false ;
    }
  }
  
  public int groupId(char ch ) {
    int return_val;
    switch(ch) {
      case '+' :
      case '-' :
        return_val = 1;
        break;
      case '*' :
      case '/' :
	return_val = 2;
	break;
      default : 
	return_val = -1;
    }
    return return_val;
 }
	
	
  public boolean  compare(char opTop , char opThis) {
    int groupId_top = groupId(opTop);
    int groupId_this = groupId(opThis);
    if(groupId_top >= groupId_this)
      return true ;
    else 
      return false ;
    }
	
  public void PerformConversion() {
    boolean isVar ;
    boolean isPar ;
    boolean isOp  ;
    for(int i=0; i< this.infix_string.length();i++) {
      isVar = isVariable(this.infix_string.charAt(i)) ;
      isPar = isParenthesis(this.infix_string.charAt(i));
      isOp = isOperator(this.infix_string.charAt(i));
      if(isVar == true ) {
	 //Copy the variable directly 
	 postfix_string = postfix_string + this.infix_string.charAt(i);
      } else if(isOp == true ) {
	 char opThis = this.infix_string.charAt(i);
	 if(my_stack.isEmpty()) {
	   this.my_stack.push(opThis);
	  } else {
	     char opTop = this.my_stack.pop();
	     if(opTop == '(') {
	       this.my_stack.push(opTop);
	       this.my_stack.push(opThis);
	     } else {
	       //check which one takes precedence
	       if(compare(opTop,opThis)) {
	         postfix_string = postfix_string + opTop ;
	         this.my_stack.push(opThis);
	       } else {
	         this.my_stack.push(opTop);
	         this.my_stack.push(opThis);
	       }
	    			
	     }
	   }
      } else if(isPar == true) {
	  if(this.infix_string.charAt(i) == '(' ) {
	    this.my_stack.push('(');
	  } else {
	    Character opTop = this.my_stack.pop();
	     while( opTop!= '(') {
	       this.postfix_string= this.postfix_string + opTop ;
	       if(this.my_stack.isEmpty()) {
	         break;
	       } else {
	         opTop = this.my_stack.pop();
	       }
	     }
	  }
      } else {// Treat as the end
	  //Default :::::
	  break;
	 }
	    
	    	  
	    	  
    } 

    while(!this.my_stack.isEmpty()) {
      this.postfix_string = this.postfix_string + this.my_stack.pop();
    }
  }	
  
  public String getPostfix_string() {
    return postfix_string;
  }

  public void setPostfix_string(String postfix_string) {
    this.postfix_string = postfix_string;
  }

  public void displayPostfix() {
    System.out.println(postfix_string);
  }
  

}

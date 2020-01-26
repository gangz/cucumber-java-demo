package expression;

import java.util.Stack;

public class StackExpression implements Expression  {

	boolean isDigit(Character temp) {
		return temp <= '9' && temp>= '0';
	}
	
	boolean isOperator(Character abc) {
		return abc == '+' || abc == '-' || abc == '*' || abc == '/' ;
	}
	
	boolean isLeftParenthesis(Character abc) {
		return abc == '(';
	}
	
	boolean isRightParenthesis(Character abc) {
		return abc == ')';
	}
	
	Integer getLevel(Character op)
	{
	    switch(op)
	    {
	        case '*':
	        case '/':
	          return 2;
	        case '+':
	        case '-':
	          return 1;
	    }
		return 0;
	}

	
	Integer calculate(Stack<Integer> num, Stack<Character> op)
	{
	   Integer a = num.peek();
	   num.pop();
	   Integer b = num.peek();
	   num.pop();
	   Character c = op.peek();
	   op.pop();
	   switch(c)
	   {
	     case '+':
	       num.push(a+b);
	       break;
	     case '-':
	       num.push(b-a);
	       break;
	     case '*':
	         num.push(a*b);
	         break;
	     case '/':
	       if(a==0)
	         return -1;
	       num.push(b / a) ;
	       break;
	   }
	   return 0;
	}

	@Override
	public Integer evaluate(String expression) throws ExpressionError {
		Integer result ;
		Stack<Character> op = new Stack<Character>();
		Stack<Integer> num = new Stack<Integer>();
		
	    char temp ;
	    int pos = 0;
	    int end = expression.length();
	    if( pos - end > 50) {
	    	throw new ExpressionError();
	    }
	    while(pos < end)
	    {
	        temp = expression.charAt(pos);
	        if(isDigit(temp)){
	          String str = new String();
	          while(pos < end &&isDigit(expression.charAt(pos)))
	        	  {
	        		  str+=expression.charAt(pos);
		              pos++;
		          }

	          if( str.length() > 10) 
	        	  {
	        	  throw new ExpressionError();
	        	  }
	          num.push(Integer.parseInt(str));
	          pos--;
	        } else if(isLeftParenthesis(temp))
	        {
	          op.push(temp);
	        } else if(isRightParenthesis(temp))
	        {
	          while(!op.empty() && op.peek() != '(' )
	          {
	        	  int temp2 = calculate(num,op);
	              if (0!=temp2){
	            	throw new ExpressionError();
	              }
	          }
	          op.pop();
	        } else if(isOperator(temp))
	        {
	           while(!op.empty() &&  (getLevel(temp) <= getLevel(op.peek()))  )
	           {
	              if(isLeftParenthesis(op.peek())) break;
	              int temp2 = calculate(num,op);
	              if (0!=temp2){
	            	throw new ExpressionError();
	              }
	           }
	           op.push(temp);
	        }

	        pos ++;

	    }
	    while(!op.empty())
	    {
	    	int temp2 = calculate(num,op);
            if (0!=temp2){
          	throw new ExpressionError();
            }
	    }
	    result=num.peek();
	    return result;		
		
	} 
	


}

package lab5;
import java.util.Scanner;

import dataStructures.ArrayStack;
import dataStructures.LinkedBinaryTree;
enum ExpressionType{
	INFIX,
	PREFIX,
	POSTFIX;
	
}
public class Expression extends LinkedBinaryTree {
	private String notationExp;
	private ExpressionType et;
	Scanner input;
	private int P(char ch) {
		switch(ch) {
		case'+':
			return 1;
		case'-':
			return 1;
		case'*':
			return 2;
		case'/':
			return 2;
		case'^':
			return 3;
		}
		return -1;
	}
	public Expression() {
		super ();
		notationExp="";
		input=new Scanner(System.in);
		
	}
	public void readInfixExpression() {
		et=ExpressionType.INFIX;
		System.out.println(et);
		this.notationExp=input.nextLine();
	}
	public void readPostfixExpression() {
		et=ExpressionType.POSTFIX;
		System.out.println(et);
		this.notationExp=input.nextLine();
		
	}
	public void readPrefixExpression() {
		et=ExpressionType.PREFIX;
		System.out.println(et);
		this.notationExp=input.nextLine();
	}
	public void InfixToPostfix() {
		if(et==ExpressionType.INFIX) {
			et=ExpressionType.POSTFIX;
			String r=new String("");
			ArrayStack stack=new ArrayStack();
			String [] el=notationExp.split(" ");
			for(int i=0; i<el.length;i++) {
				if(Character.isLetterOrDigit(el[i].charAt(0))) {
					r+=el[i]+" ";
				}
				else if(el[i].charAt(0)=='(') {
					stack.push(el[i]);
				}
				else if(el[i].charAt(0)==')') {
					while(!stack.empty()&&stack.peek().toString().charAt(0)!='(') {
						r+=stack.peek()+" ";
						stack.pop();
					}
					stack.pop();
				}
				else {
					while(!stack.empty()&&P(el[i].charAt(0))<=P(stack.peek().toString().charAt(0))) {
						r+=stack.peek()+" ";
						stack.pop();
					}
					stack.push(el[i]);
				}
			}
			while(!stack.empty()) {
				if(stack.peek().toString().charAt(0)=='(') {
					System.out.println("Buruu ilerhiilel");}
				r+=stack.peek()+" ";
				stack.pop();
				}
				this.notationExp=r;
		}}
	public void PrefixToPostfix() {
		if(et==ExpressionType.PREFIX) {
			et=ExpressionType.POSTFIX;
		String r=new String("");
		ArrayStack stack=new ArrayStack();
		String [] el=notationExp.split(" ");
		for(int i=el.length-1;i>=0;i--) {
			if(el[i].length()==1&&Character.isLetterOrDigit(el[i].charAt(0))) {
				String op1=stack.peek().toString();
				stack.pop();
				String op2=stack.peek().toString();
				stack.pop();
				String temp =op1+op2+el[i].charAt(0)+" ";
				stack.push(temp);
			}
			else {
				stack.push(el[i]+" ");
			}
		}
		this.notationExp=stack.peek().toString();
	}}
	public void ExpressionTreeFromPostfix() {
		ArrayStack s=new ArrayStack();
		Expression t1,t2,temp;
		String []el=notationExp.split(" ");
		for(int i=0;i<el.length;i++) {
			if(Character.isLetterOrDigit(el[i].charAt(0))) {
			temp=new Expression();
			temp.makeTree(el[i], temp, temp);
			s.push(temp);
		}
			else {
				temp= new Expression();
				t1=(Expression)s.pop();
				t2=(Expression)s.pop();
				temp.makeTree(el[i].charAt(0), t1, t2);
				s.push(temp);
			}
	}
		temp=(Expression)s.pop();
		this.root=temp.root;
	}
	 /* function which will evaluate value of a  given postfix expression */ 
	   protected  static int bodoh(String express) 
	    { 
	        ArrayStack st = new ArrayStack(); 
	          
	        for(int i=0; i < express.length(); i++) /* loop to scan all elements of the expression one by one */
	        { 
	            char ch = express.charAt(i); 
	             
	            if(Character.isDigit(ch)) /* pushing value into the stack */
	            st.push(ch - '0'); 
	              
	           
	            else       /* if the operator comes it will be evaluated */
	            { 
	                int value1 = (int)st.pop(); 
	                int value2 = (int)st.pop(); 
	                  
	                switch(ch) 
	                { 
	                    case '+': 
	                    st.push(value2 + value1); 
	                    break; 
	                      
	                    case '-': 
	                    st.push(value2 - value1); 
	                    break; 
	                        
	                    case '*': 
	                    st.push(value2*value1); 
	                    break; 
	                    case '/': 
	                    st.push(value2/value1); 
	                    break; 
	              } 
	            } 
	        } 
	        return (int)st.pop();   // result return  
	    } 
	public static void main(String[] args) {
		try {
			Expression me=new Expression();
			int command;
			String l;
			while(true) {
				System.out.println("\n!!!!!MENU!!!!!");
				System.out.println("1) INFIX ilerhiilel oruulah");
				System.out.println("2) PREFIX ilerhiilel oruulah");
				System.out.println("3) POSTFIX ilerhiilel oruulah");
				System.out.println("4) INFIX ilerhiilel hevleh");
				System.out.println("5) PREFIX ilerhiilel hevleh");
				System.out.println("6) POSTFIX ilerhiilel hevleh");
				System.out.println("7) ilerhiilel bodoh");
				System.out.println("0) garah");
				command=Integer.parseInt(me.input.nextLine());
				switch(command) {
				case 0:
					System.exit(0);
					break;
				case 1:
					me.readInfixExpression();
					me.InfixToPostfix();
					me.ExpressionTreeFromPostfix();
					break;
				case 2:
					me.readPrefixExpression();
					me.PrefixToPostfix();
					me.ExpressionTreeFromPostfix();
					break;
				case 3:
					me.readPostfixExpression();
					me.ExpressionTreeFromPostfix();
					break;
				case 4:
					System.out.println("\n INFIX ilerhiilel:");
					me.inOrderOutput();
					break;
				case 5:
					System.out.println("\n PREFIX ilerhiilel:");
					me.preOrderOutput();
					break;
				case 6:
					System.out.println("\n POSTFIX ilerhiilel:");
					me.postOrderOutput();
					break;
				case 7:
					me.InfixToPostfix();
					bodoh(me.toString());
					break;
				default:
					System.out.println("0-7 utga l oruulna");
					break;
				}
			}
		}
		catch(Exception ex) {
			System.out.println("error "+ex.getMessage());
		}
		
	}
	
}

//Г.Төгөлдөр B210970023
package lab3;
import java.util.*;
import dataStructures.DerivedArrayStack;

public class MyStack extends DerivedArrayStack{
	public int maxsize;
	public Object[] stackArray;
	public int top;
	
	public MyStack(int size) {
		maxsize = size;
		stackArray = new Object[maxsize];
		top = -1;
	}
	
	public boolean full() {
		return(top==maxsize-1);
	}
	
	public boolean empty() {
		return(top==-1);
	}
	
	public Object peek() {
		return stackArray[top];
	}
	
	public void push(Object theObject) {
		if(!full()) {
			top++;
			stackArray[top] = theObject;
		}
	}
	
	public Object pop() {
		if(!empty()) {
			return stackArray[top--];
		}
		else 
			return "The Stack is empty";
	}
	
	Object[] toArray() {
		int j =0;
		Object[] array = new Object[top+1];
		for(int i=top;i>=0;i--) {
			array[j]=stackArray[i];
			j++;
		}
		return array;
	}
	
	public MyStack rand() {
		int a = top+1;
		Object [] array = new Object[a];
		Object [] array1 = new Object[a];
		
		for(int i=0;i<a;i++) {
			array[i] = stackArray[i];
		}
		for(int i=0;i<a;i++) {
			int x = (int)(Math.random()*(a-1-i));
			array1[i] = array[x];
			array[x] = array[a-1-i];
		}
		MyStack randStack = new MyStack(a);
		for(int i=0;i<a;i++) {
			randStack.push(array1[i]);
		}
		return randStack;
	}
	
	public MyStack unique() {
		int a = top+1;
		Object [] array = new Object[a];
		for(int i=0;i<a;i++) {
			array[i] = stackArray[i];
		}
		Arrays.sort(array);
		MyStack uniqueStack = new MyStack(a);
		for(int i=0;i<array.length-1;i++)  {
			if(array[i]!=array[i+1]) {
				uniqueStack.push(array[i]);
			}
		}
		uniqueStack.push(array[array.length-1]);	
	
		return uniqueStack;
	}
	
	public boolean exists(Object element) { 
		
		int a = top+1;
		Object [] array = new Object[a];
		
		for(int i=0;i<a;i++) {
			array[i] = stackArray[i];
		}
		boolean b = false;
		for(int i=0;i<a;i++) {
			if(element == array[i] ) {
				b=true;
				break;
			}
		}
		return b;	
	}
	
	public MyStack addRange(Object [] elements) {
		int v = size();
		for(int i=0;i<elements.length;i++) {
			add(i+v, new Integer((int)elements[i]));
		}
		int a = top+1;
		Object [] array = new Object[a];
		for(int i=0;i<a;i++) {
			array[i] = stackArray[i];
		}
		MyStack addRangeStack = new MyStack(10);
		for(int i=0;i<a;i++) {
			addRangeStack.push(array[i]);
		}
		for(int i=0;i<elements.length;i++) {
			addRangeStack.push(elements[i]);
		}
		return addRangeStack;
	
		
	}
	public static void main(String[] args) {
		MyStack s = new MyStack(10);
		s.push(1);
		s.push(4);
		s.push(1);
		s.push(4);
		s.push(5);
		
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ta songoltoo hiine uu");
		System.out.println("1.toArray()\n2.rand()\n3.unique()\n4.Exists()\n5.AddRange()\n0.Programaas garah");
		System.out.println("Tanii songolt");
		
		try {
			choice = sc.nextInt();
			while(choice!=0) {
				switch(choice) {
		
				case 1:
					Object[] array = s.toArray();
					System.out.println("toArray:");
					for(int i=0;i<array.length;i++) {
						System.out.print(array[i] + " ");
					}
					break;
				case 2:
				{
					MyStack randStack = s.rand();
					System.out.println("rand(): ");
					
					while(!randStack.empty()) {
						System.out.print(randStack.pop() + " ");
					}
					break;
				}	
				case 3:
				{
					MyStack uniqueStack = s.unique();
					System.out.println("unique(): ");
					
					while(!uniqueStack.empty()) {
						System.out.print(uniqueStack.pop() + " ");
					}
					break;
				}
				case 4:
				{
					Object element;
					try {
						System.out.println("Ta stack-d bga esehiig shalgah elementee oruulna uu?");
						element = sc.nextInt();
						System.out.println("Exists():"+ s.exists(element));
					}
					catch(Exception e) {
						System.out.println("Aldaa"+ e);
					}
				}
					break;
				case 5:
				{
					System.out.println("Massiviin hemjeeg oruulna uu?");
					int b =sc.nextInt();
					Object [] elements = new Object[b];
					for(int i=0;i<elements.length;i++) 
					{
						System.out.print(i + ":");
						try{
							elements[i]=sc.nextInt();
						}
						catch(InputMismatchException e) {
							System.out.println("Ta songoltoo integer utgaar oruulna uu?");
							main(args);
						}
					}
					MyStack AddRangeStack = s.addRange(elements);
					System.out.println("AddRange(): ");
					while(!AddRangeStack.empty()) {
						System.out.print(AddRangeStack.pop() + " ");
					}
					break;
				}
				case 9:
					System.out.println("\nSongoltuud:\n" + "1.toArray()\n2.rand()\n3.unique()\n4.Exists()\n5.AddRange()\n0.Programaas garah");
				default:
					System.out.println("Ta songoltoo zov oruulna uu\n"+ "Songoltuudiig harah bol 9-g songono uu");
				}
				System.out.println("\nTanii songolt:");
				choice = sc.nextInt();	
			}
			System.out.println("Program duuslaa");
			sc.close();
		}
		catch(Exception e){
			System.out.println(e);
			main(args);
		}
	}
}
//1- 311 
//2- 3 12
//3- 4 312
//3- 7 210
//Г.Төгөлдөр B210970023
package lab2 ;

import dataStructures.Chain ;
import java.util.*;

public class MyChain extends Chain {
	
	static MyChain x = new MyChain();
	static MyChain y = new MyChain();
	
	public Object[] toArray() {  // Жагсаалтыг массиврүү хөрвүүлж буцаана
		Object arr[] = new Object[size()];
		
		for(int i=0; i<size() ; i++) {
			arr[i] = this.get(i);
		}
		return arr;
	}
	
	public void addRange(Object[] elements) { // Өгөгдсөн элементыг жагсаалтын ард нэмнэ
		for(int i=0; i<elements.length ; i++) {
			this.add(size(), elements[i]);
		}
	}
	
	public MyChain  union(MyChain chain) { //жагсаалтын нэгдэл
		System.out.println(x.toString());
		System.out.println(y.toString());
		MyChain lst = new MyChain();
		int g = 0; 
		g = this.size();
		for(int i=0; i<this.size() ; i++) {
			lst.add(i, this.get(i));
		}
		for(int i=0  ; i<this.size() ; i++) {
			if(lst.indexOf(chain.get(i)) == -1) {
				lst.add(g, chain.get(i));
				g++ ;
			}
		}
		return lst;
	}
	
	public MyChain intersection(MyChain chain) {// жагсаалтын огтлол
		int k = 0;
		MyChain intersection = new MyChain();
		for(int i=0 ; i<x.size() ; i++) {
			for(int j=0 ; j<y.size() ; j++) {
				if((int)x.get(i) == (int) y.get(j)) {
					intersection.add(k, this.get(i));
					k++ ;
				}
			}
		}
		return intersection ;
	}
	
public static void main (String [] args ) {
	
	x.add(0,2);
	x.add(1,4);
	x.add(2,6);
	x.add(3,7);
	
	Object a [] ;
	a = x.toArray() ;
	
	y.add(0,4);
	y.add(1,6);
	y.add(2,7);
	y.add(3,8);
	
	Object b [] ;
	b = y.toArray() ;
	 try {
	System.out.println("Сонгоно уу?\n1. toArray\n2. AddRange\n3. Intersection\n4. Union\n0. Програмаас гарах");
	Scanner sc = new Scanner(System.in) ;
	int cmd ; 
	cmd = sc.nextInt();
	while(cmd!=0){
		if(cmd<5) {
		switch(cmd) {
			case 1:
				for(int i=0 ; i<a.length ; i++) {
					System.out.println(" "+(int)a[i]);
				}
				break ;
			case 2:
				x.addRange(b);
				System.out.println("AddRange is "+x);
				break ;
			case 3:
				System.out.println(x.toString());
				System.out.println(y.toString());
				MyChain intlst = x.intersection(y);
				System.out.println("Intersection is"+ intlst);
				break ;
			case 4: 
				System.out.println("Union is "+ x.union(y));
				break ;
			}
		}
		else
			System.out.println("Ta 0-4 hoorond utgaa oruulna uu");
		System.out.println("Сонгоно уу?\n1. toArray\n2. AddRange\n3. Intersection\n4. Union\n0. Програмаас гарах\n");
		cmd = sc.nextInt();
		}
	sc.close();
	 }
	 catch(Exception e) {
		 System.out.println("Програмийн алдаа"+e);
	 }
	}
}
//312 3-4
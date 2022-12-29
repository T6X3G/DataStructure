package lab4;

import java.util.*;
import dataStructures.*;

public class lab4 extends dataStructures.HashTable
{
	public lab4(int divisor)
	{
		super(divisor);
	}
	
	public void menu()
	{
		System.out.println("0. Hevleh");
		System.out.println("1. Nemeh");
		System.out.println("2. Search");
		System.out.println("3. UpdatedElement");
		System.out.println("4. UpdateKey");
		System.out.println("5. Delete");
		System.out.println("6. Exit");
		System.out.println("---Hiih uildliin dugaaraa oruulna uu---");
	}
	
	public void in()
	{
		try
		{
			Scanner in = new Scanner(System.in);
			Object key,element;
			System.out.println("key: ");
			key = in.nextLine();
			System.out.println("element: ");
			element = in.nextLine();
			this.put(key, element);
			System.out.println("Element nemegdlee: "+this.size());
		}
		catch(Exception ex)
		{
			System.out.println("Element zashad aldaa garlaa: "+ex.getMessage());
		}
	}
	
	public void search()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			Object key, element;
			System.out.println("haih elementiin key-g oruulna uu: ");
			key = sc.nextLine();
			element = this.get(key);
			if(element != null)
			{
				System.out.println(key+" tulhuurtei"+element+" element oldloo");
			}
			else
			{
				System.out.println(key+" tulhuurtei element oldsongui");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Element haihad aldaa garlaa: "+ex.getMessage());
		}
	}
	public Object updateElement(Object theKey, Object theElement)
	{
		Object updatedElement = null;
		int b = this.search(theKey);
		if(this.table [b]!= null)
		{
			updatedElement = this.put(theKey, theElement);
			if(updatedElement != null)
			{
				System.out.println(theKey+" tulhuurtei "+updatedElement+" elementiig "+theElement+" elementeer soliv");
			}
		}
		else
		{
			System.out.println(theKey+"tulhuurtei element oldsongui");
		}
		return updatedElement;
	}
	
	public void elementUpdate()
	{
		try
		{
			Scanner in = new Scanner(System.in);
			Object key,element;
			System.out.println("Zasah elementiin key: ");
			key = in.nextLine();
			System.out.println("Zasah element: ");
			element = in.nextLine();
			this.updateElement(key, element);
		}
		catch(Exception ex)
		{
			System.out.println("Element zashad aldaa garlaa: "+ex.getMessage());
		}
	}
	
	public Object updateKey(Object theKey, Object theNewKey)
	{
		Object elment = null;
		int b = this.search(theKey);
		int b1 = this.search(theNewKey);
		if(this.table[b] != null && this.table[b1]==null)
		{
			elment = this.table[b].getElement();
			this.table[b] = null;
			this.put(theNewKey, elment);
			System.out.println(theKey+" tulhuurtei"+elment+" elementiig "+theNewKey+" tulhuurtei bolgoloo.");
		}
		else
		{
			System.out.println(theKey+" tulhuurtei element oldsongui. Esvel "+theNewKey+" tulhuurtei element uussen baina.");
		}
		return elment;
	}
	
	public void keyUpdate()
	{
		try
		{
			Scanner in = new Scanner(System.in);
			Object key,newKey;
			System.out.println("Huuchin key oruulna uu: ");
			key = in.nextLine();
			System.out.println("Shine key oruulna uu: ");
			newKey = in.nextLine();
			this.updateKey(key, newKey);
		}
		catch(Exception ex)
		{
			System.out.println("Element zashad aldaa garlaa: "+ex.getMessage());
		}
	}
	
	public void delete(Object theKey)
	{
		Object element = this.get(theKey);
		if(element != null)
		{
			int b = this.search(theKey);
			this.table[b] = null;
			this.size--;
			System.out.println(theKey+" tulhuurtei"+element+" element ustgagdlaa. Elementiin too: "+this.size());
		}
		else
		{
			System.out.println(theKey+" tulhuurtei element oldsongui");
		}
	}
	
	
	public static void main(String args [])
	{
		int divisor, command;
		System.out.println("Hash husnegtiin urtiig oruulna uu=");
		Scanner sc = new Scanner(System.in);
		divisor = sc.nextInt();
		lab4 hash = new lab4(divisor);
		while(true)
		{
			hash.menu();
			command = sc.nextInt();
			switch(command)
			{
			case 0:
				hash.output();
				break;
			case 1:
				hash.in();
				break;
			case 2:
				hash.search();
				break;
			case 3:
				hash.elementUpdate();
				break;
			case 4:
				hash.keyUpdate();
				break;
			case 5:
				try
				{
					Scanner scan = new Scanner(System.in);
					Object key;
					System.out.println("Ustgah elementiin key-g oruulna uu: ");
					key = scan.nextLine();
					hash.delete(key);
				}
				catch(Exception ex)
				{
					System.out.println("Element ustgahad aldaa garlaa: "+ex.getMessage());
				}
				break;
			case 6:
				System.exit(0);
				break;
				default:
					System.out.println("Uildliin dugaar buruu bn!");
					System.out.println("0-6 hoorond uildlee oruulna uu");
					break;
			}
		}
	}
}
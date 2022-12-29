package biydaalt2;

import java.io.*;
import java.util.*;

import dataStructures.*;

public class CarParking extends ArrayStack{
	ArrayStack park;
	public CarParking() {
		super(10);
		park = new ArrayStack(10);
	}
	public void input() {
		String[] data = {};
		try {
			BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Tugul\\OneDrive\\Desktop\\ugugdl\\CS203\\src\\biydaalt2\\cars.txt"));
			String line;
			String[] values= {};
			while((line = input.readLine()) != null) {
				values = line.split(" ");
				output("-------------------------------");
				process(values[0], values[1]);
			}
		}
		catch(Exception ex) {
			output("Алдаа гарлаа "+ex.getMessage());
		}
	}
	public void process(String op, String plate) {
		ArrayStack a = new ArrayStack();
		if(op.equals("A")) {
			if( top == stack.length - 1) {
				output("|#|Зогсоол дүүрсэн тул " + plate + " дугаартай машин зогсоолд орсонгүй.");
			}
			else {
				output("|+| " +plate+" дугаартай машин зогсоолд орлоо");
				push(plate);
			}
		}
		else{
			for(int i=0;i<stack.length;i++) {
				if(top != -1) {
					if(peek().equals(plate)) {
						pop();
						output("|-| " +plate+" дугаартай машин зогсоолоос гарлаа.");
						break;
					}
					else park.push(pop());
				}
				else if(top==-1) {
					output("|?|"+plate+" дугаартай машин зогсоолд байхгүй байна.");
					break;
				}
			}
			for(int i=0;i<stack.length;i++) {
				if(park.top != -1) {
					System.out.println("|&| "+ park.peek() + " буцаан орууллаа");
					push(park.pop());
				}
			}
		}
	}
	public void output(String text) {
		System.out.println(text);
	}
	public static void main(String[] args) {
		CarParking c = new CarParking();
		c.input();
	}
}
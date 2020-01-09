package project;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;
public class performance {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		

		LinkedList<String> linkedList1 = new LinkedList<String>();
		Stack<String> stack1 = new Stack<String>();
		
		LinkedList<String> linkedList2 = new LinkedList<String>();
		Stack<String> stack2 = new Stack<String>();
		
		BufferedReader br1 = new BufferedReader(new FileReader("text1.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("text2.txt"));

		String line1 = null;
		String line2 = null;

		while ((line1 = br1.readLine()) != null) {
			String[] values = line1.split("/n");
			for (String str : values) {
				linkedList1.add(str);
				stack1.add(str);
			}
		}
		br1.close();
		
		while ((line2 = br2.readLine()) != null) {
			String[] values = line2.split("/n");
			for (String str : values) {
				linkedList2.add(str);
				stack2.add(str);
			}
		}
		br1.close();
		
		Instant start1 = Instant.now();
		for (int i=linkedList1.size()-1; 0<=i; i--) {
			System.out.println(Integer.parseInt(linkedList1.get(i)) * Integer.parseInt(linkedList2.get(i)));

		}
		Instant end1 = Instant.now();
		
		System.out.println("-------------------------------------------");
		
		Instant start2 = Instant.now();
		for (int i=0; i<stack1.size(); i++) {
			System.out.println(Integer.parseInt(stack1.pop()) * Integer.parseInt(stack2.pop()));
		}
		Instant end2 = Instant.now();
		
		
		Duration timeElapsed1 = Duration.between(start1, end1);
		System.out.println("LinkedList Take: "+ timeElapsed1.toMillis() +" milliseconds");
		
		Duration timeElapsed2 = Duration.between(start2, end2);
		System.out.println("Stack Take: "+ timeElapsed2.toMillis() +" milliseconds");
	}

}

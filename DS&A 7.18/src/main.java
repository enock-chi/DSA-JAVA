import java.util.*;
import dsa718.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arraylist<Integer> list = new Arraylist<>();
		
		for (int k = 0; k < 10; k++) {
			list.add(k, k + 1);
		}
		
		list.print();
		
		System.out.println(list.contains(5));
		
		for (int k = 10; k < 21; k++) {
			list.add(k, k + 1);
		}
		
		System.out.println(list.size());
		
		list.print();
		
		list.remove(0);
		
		list.print();
		

	}

}

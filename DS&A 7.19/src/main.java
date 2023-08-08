import java.util.*;
import dsa719.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arraylist<Integer> list = new Arraylist<>();
		
		for (int k = 1; k <= 25; k++) {
			list.add(k);
		}
		
		list.print();
		
		list.remove(5);
		
		list.print();
		
		list.clear();
		
		list.print();

	}

}

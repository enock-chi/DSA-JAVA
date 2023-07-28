import java.util.*;
import dsa75.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dsa75.ArrayList<Integer> list = new dsa75.ArrayList<>();
		
		list.print();
		
		for (int k = 1; k <= 50; k++) {
			list.add(k-1, k);
		}
		
		list.print();
		
		list.trimToSize(25);
		
		list.print();

	}

}

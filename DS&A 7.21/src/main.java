import java.util.*;
import dsa721.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		
		for ( int k = 1; k <= 20; k++ ) {
			list.addFirst(k);
		}
		
		list.print();
		
		list.remove(5);
		
		list.print();
		
		list.set(10, 50);
		
		list.print();

	}

}

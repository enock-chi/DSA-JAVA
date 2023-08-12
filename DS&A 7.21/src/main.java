import java.util.*;
import dsa721.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> pos = new ArrayList<>();
		
		for ( int k = 1; k <= 20; k++ ) {
			pos.add(list.addLast(k));
		}
		
		list.print();
		
		list.remove(pos.get(5));
		
		list.print();
		
		list.set(pos.get(10), 50);
		
		list.print();

	}

}

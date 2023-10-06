import dsa748.*;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> plist  = new ArrayList<>();
		Position<Integer> store;
		
		for (int k = 1; k <= 10; k++) {
			plist.add(list.addFirst(k));
		}
		
		list.print();
		
		store = list.before(plist.get(0));
		
		System.out.println(store.getData());
		
		System.out.println(list.first().getData());
		
		System.out.println(list.last().getData());
	}

}

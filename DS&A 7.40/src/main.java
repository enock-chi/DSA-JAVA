import java.util.*;

import dsa740.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>(); 
		ArrayList<Position<Integer>> plist = new ArrayList<>();
		
		for (int k = 1; k <= 10; k++) {
			plist.add(k-1,list.addLast(k));
		}
		
		list.print();
		
		list.remove(plist.remove(0));
		
		list.print();
		
		list.set(plist.get(8),11);
		list.print();
		
		list.moveToFront(plist.get(0));
		
		list.print();
		
		list.moveToFront(plist.get(3));
		list.print();

	}

}

import dsa737.*;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> plist = new ArrayList<>();
		
		for (int k = 1; k <= 10; k++) {
			plist.add(k-1,list.addLast(k));
		}
		
		list.print();
		
		System.out.println(list.positionAtIndex(5));

	}

}

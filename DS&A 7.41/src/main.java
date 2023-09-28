import dsa741.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> plist = new ArrayList<>();
		
		for ( int k = 1; k <= 10; k++) {
			plist.add(k-1,list.addLast(k));
		}
		
		list.print();
		
		
		plist.add(4,list.addBefore(plist.get(5), 14));
		
		list.print();
		
		list.remove(plist.remove(4));
		
		list.print();
		
		LinkedPositionalList<Integer> cloneList = list.clone();
		
		cloneList.print();
		
		cloneList.addLast(11);
		
		list.print();
		cloneList.print();

	}

}

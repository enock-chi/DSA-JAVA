import dsa736.*;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionList<Integer> list = new LinkedPositionList<>();
		ArrayList<Position<Integer>> positionList = new ArrayList<>();
		
		
		for (int k = 1; k <= 10; k++) {
			positionList.add(k-1,list.addLast(k));
		}
		
		list.print();
		
		remove(2,positionList,list);
		
		list.print();
		
		positionList.add(2,list.addBefore(positionList.get(2), 11));
		
		list.print();
		
		System.out.println(list.positionAtIndex(5));
		
		remove(2, positionList, list);
		
		list.print();

	}
	
	public static <e> void remove(int i, ArrayList list, LinkedPositionList pList) throws IllegalStateException{
		if ( list.isEmpty()) throw new IllegalStateException("");
		pList.remove((Position<e>) list.get(i));
		list.remove(i);
	}

}

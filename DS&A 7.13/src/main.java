import java.util.*;
import dsa713.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> position = new ArrayList<>();
		
		for ( int k = 1; k <= 20; k++) {
			position.add(list.addLast(k));
		}
		
		list.print();
		list.remove(remove(5,position));
		list.print();
		
		System.out.print(list.findPosition(6));

	}
	
	/**
	 * Function that edits our positions to match positional list in O(1) time
	 * 
	 * @param int i, index to remove
	 * @param ArrayList<Position<e>> pos, the array of positions
	 * @return the position to be removed in the positional list
	 * */
	public static <e> Position<e> remove(int i, ArrayList<Position<e>> pos){
		return pos.remove(i);
	}

}

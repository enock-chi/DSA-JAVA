import java.util.*;
import dsa712.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> position = new ArrayList<>();
		
		for (int k = 1; k <= 20; k++) {
			position.add(list.addLast(k));
		}
		
		list.print();
		list.remove(remove(1,position));
		list.print();
		list.remove(remove(1,position));
		list.print();
		/**
		 * Note how this below is implemented if you are adding 
		 * before or after the position in "Position" this also effects the logic
		 * based on further deletions and adding
		 * */
		position.add(2,list.addAfter(position.get(1), 56));
		list.print();
		list.remove(remove(1,position));
		list.print();
		
		System.out.println(list.indexOf(position.get(4)));
		

	}
	
	/**
	 * Returns Position after deleting it in "position"
	 * 
	 * @param int i, the index
	 * @param ArrayList<Position<e>> position, array keeping track of positions;
	 * @return position to be deleted
	 * */	
	public static <e> Position<e> remove(int i, ArrayList<Position<e>> position){
		Position<e> pos = position.get(i);
		position.remove(i);
		return pos;
	}

}

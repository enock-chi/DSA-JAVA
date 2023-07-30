import java.util.*;
import dsa712.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> position = new ArrayList<>();
		
		for (int k = 1; k <= 20; k++) {
			position.add(list.addFirst(k));
		}
		
		list.print();
		list.remove(remove(1,position));
		list.remove(remove(1,position));
		list.addBefore(position.get(1), 56);
		

	}
	
	public static <e> Position<e> remove(int i, ArrayList<Position<e>> position){
		Position<e> pos = position.get(i);
		position.remove(i);
		return pos;
	}

}

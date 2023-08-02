import java.util.*;
import dsa716.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		ArrayList<Position<Integer>> position = new ArrayList<>();
		
		for (int k = 1; k <= 20 ; k++) {
			position.add(list.addLast(k));
		}
		
		list.print();
		
		list.remove(remove(5,position));
		
		list.print();
		
		System.out.println(list.before(position.get(5)));
		

	}
	
	public static <e> Position<e> remove(int i, ArrayList<Position<e>> pos){
		return pos.remove(i);
	}

}

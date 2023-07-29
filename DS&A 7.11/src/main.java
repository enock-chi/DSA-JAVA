import java.util.*;
import dsa711.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        ArrayList<Position<Integer>> arr = new ArrayList<>();
        
        for (int k = 1; k <= 20; k++) {
        	arr.add(list.addFirst(k));
        }
        list.print();
        list.remove(remove(5,arr));
        list.print();
        list.remove(remove(5,arr));
        list.print();
        
        
	}
	
	/**
	 * Manages the ArrayList of Positions so that it always matches the linked list
	 * 
	 * @param i, The position to be removed
	 * @param  arr, The ArrayList keeping position references 
	 * @returns the desired position to remove
	 * */
	public static <e> Position<e> remove(int i, ArrayList<Position<e>> arr){
		Position<e> output = arr.get(i);
		arr.remove(i);
		return output;
	}

}

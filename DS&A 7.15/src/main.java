/**
 * @author Enock Chikobvu
 * 
 * Notes:
 *   - [ 
 *      Logic works with normal queue ADT however the logic to make 
 *      dequeue(p) would requeire extra logic outside the LinkedPositionalQueue
 *     ]
 *    
 * */

import java.util.*;
import dsa715.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalQueue<Integer> list = new LinkedPositionalQueue<>();
		
		
		for (int k = 1; k <= 20; k++) {
			list.enqueue(k);
		}
		
		list.print();
		
		list.dequeue();
		
		list.print();
		
	}

}

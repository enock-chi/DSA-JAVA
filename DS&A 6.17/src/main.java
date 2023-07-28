import java.util.*;

import dsa617.LinkedList;
import dsa617.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		newStack<Integer> list = new newStack<>();
		newStack<Integer> newList = new newStack<>();
		for ( int k = 0; k < 10; k++) {
			list.push(random.nextInt(40) + 10);
		}
		
		list.print();
		newList.print();
		int size = list.Size()
;		
		for ( int k = 0; k < size; k++) {
			newList.push(list.pop());
		}
		
		list.print();
		newList.print();
		
		newList.pop();
		 
		list.print();
		newList.print();

	}

}

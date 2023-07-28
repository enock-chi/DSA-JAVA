import java.util.*;
import dsa73.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DequeADT<Integer> deque = new DequeADT<>();
		
		for (int k = 1; k <= 10; k ++) {
			deque.addLast(k);
		}
		
		deque.print();
		deque.removeFirst();
		deque.print();
		deque.removeLast();
		deque.print();
		
		System.out.println(deque.first());
		System.out.println(deque.last());


	}

}

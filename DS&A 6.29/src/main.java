import java.util.*;
import dsa629.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		LinkedQueue<Integer> queue1 = new LinkedQueue<>();
		
		for (int k = 1; k <= 10; k++) {
			queue.enqueue(k);
		}
		
		for (int k = 5; k <= 10; k++) {
			queue1.enqueue(k);
		}
		
		queue.print();
		queue1.print();
		
		queue.concatenate(queue1);
		queue.print();
		queue1.print();
		

	}

}

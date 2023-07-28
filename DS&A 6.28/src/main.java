import java.util.*;
import dsa628.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        ArrayQueue<Integer> queue1 = new ArrayQueue<>(10);
        
        for ( int l = 1; l <= 10; l++) {
        	queue.enqueue(l);
        }
        
        queue.print();
        
        queue1 = queue.clone();
        
        System.out.println("======================================");
        
        queue1.print();
        queue1.dequeue();
        queue1.print();
        queue.print();
        
        queue =  queue1.clone();
        queue.print();
        
        
        
	}

}

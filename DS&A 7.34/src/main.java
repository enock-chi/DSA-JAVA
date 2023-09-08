import java.util.*;
import dsa734.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedQueue<Integer> list = new LinkedQueue<>();
        
        for (int k = 1; k <= 10; k++) {
        	list.enqueue(k);
        }
        
        list.print();
        
        for (int k = 1; k <= 3; k++) {
        	list.dequeue();
        }
        
        list.enqueue(11);
        
        list.dequeue();
        
        list.print();
        
        
	}

}

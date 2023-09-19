import dsa735.*;

/**
 * 
 * @author Enock Chikobvu
 * 
 * -Info [
 *         For this exercise I didn't follow the exact instructions instead i implemented the previous exercise,
 *         but with ArrayStacks that are resized and used in the queue. Though i am aware that there is an error that 
 *         would occur if you push an element and stack is empty.  
 *       ]
 *
 */

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue<Integer> queue = new ArrayQueue<>();
        for ( int k = 1; k <= 25; k++) {
            queue.enqueue(k);
        }
        
        queue.print();
        
        queue.dequeue();
        
        queue.enqueue(40);
        
        queue.print();
        
        queue.dequeue();
        
        
        queue.print();
           
        for ( int k = 1; k <= 10; k++) {
            queue.dequeue();
        }
        
        queue.enqueue(41);
        
        queue.print();
	}

}

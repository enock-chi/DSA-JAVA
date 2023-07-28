import java.util.*;
import dsa624.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        Random random = new Random();
        LinkedStack<Integer> stack = new LinkedStack<>();
        DoublyQueue<Integer> queue = new DoublyQueue<>();
        
        for (int j = 0 ; j < 10 ; j++) {
        	stack.push((int) random.nextInt(40) + 10);
        	
        }
        
        queue.print();
        stack.print();
        
        int search = input.nextInt();
        
        System.out.println(queue.scan(stack,search));
	}

}

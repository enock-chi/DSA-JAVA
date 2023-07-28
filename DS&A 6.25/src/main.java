import java.util.*;
import dsa625.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		LinkedStack<Integer> stack = new LinkedStack<>();
		
		for ( int k = 1; k <= 10; k++) {
			stack.push(k);
		}
		
		stack.print();
		
		stack.pop();
		stack.print();
		
		stack.pop();
		stack.print();
	
	}

}

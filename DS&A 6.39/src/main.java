import java.util.*;

import dsa639.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		LinkedStack<Integer> stack = new LinkedStack<>(10);
		
		for ( int k = 1; k <= 15; k++) {
			stack.push(k);
		}
		
		System.out.println(stack.size());
		
		stack.print();

	}

}

/*
 * to complete this would need to traverse all the wall
 * to the node before tail and set it as tail which is relatively 
 * easy, however not my preferred method due to time complexity.
 * what is done is strictly applies to what a stack is in terms of
 * LIFO principle
 */

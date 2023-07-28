import java.util.*;
import dsa627.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        ArrayStack<Integer> stack1 = new ArrayStack<>(10);
        
        for (int k = 1; k <= 10; k++) {
        	stack.push(k);
        }
        
        stack.print();
        
        try {
			stack1 = stack.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        
        stack1.print();
	}

}

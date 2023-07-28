import java.util.*;
import dsa72.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackADT<Integer> stack = new StackADT<>();
		Arraylist<Integer> list = new Arraylist<>();
		
		for (int k = 1; k <= 10; k++) {
			stack.push(k);
		}
		
		stack.print();
		stack.pop();
		stack.print();

	}

}

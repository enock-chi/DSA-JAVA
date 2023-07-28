import java.util.*;
import dsa710.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<Integer> list = new ArrayStack<>();
		
		for ( int k = 1; k <= 20; k++) {
			list.push(k);
		}
		
		list.print();
		
		list.pop();
		
		list.print();

	}

}

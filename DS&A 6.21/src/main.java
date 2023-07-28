import java.util.*;
import dsa621.*;
import dsa621.LinkedList;
import java.math.BigInteger;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		LinkedStack<Integer> stack = new LinkedStack<>();
		LinkedStack<Integer> tempStack = new LinkedStack<>();
		
		for (int k = 5; k > 0; k--) {
			stack.push(k);
		}
		
		LinkedStack<Integer>[] arr = new LinkedStack[stack.size()];
		
		for ( int k = 0; k < arr.length; k++) {
			arr[k] = new LinkedStack<>();
		}
		
		try {
			tempStack = stack.clone();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		for (int k = 0; k < arr.length; k++) {
			LinkedStack<Integer> rotation = null;
			try {
				rotation = tempStack.clone();
			} catch (Exception e) {
				System.out.println(e);
			}
			int count = 0;
			
			for(int x = 0; x < stack.size(); x++) {
				if ( k < (stack.size()-3)) {
					arr[x].push(tempStack.top());
				} else if( k == (stack.size() -3)) {
					if (count < 2) {
						count++;
						arr[x].push(rotation.top());
					} else {
						count = 1;
						rotation.rotate();
						arr[x].push(rotation.top());
					}
				} else if( k == (stack.size()-2)) {
					arr[x].push(rotation.top());
					arr[x].push(rotation.next());
				}
			}
			tempStack.print();
			tempStack.pop();
		}
		
		 System.out.println("================");
		 for (int k = 0; k < arr.length; k++) {
			 arr[k].print();
		 }
		   
        
	}
	
	public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }
	
	public static void print(LinkedStack<Integer>[] arr) {
		for (LinkedStack<Integer> item: arr) {
			item.print();
		}
	}
}

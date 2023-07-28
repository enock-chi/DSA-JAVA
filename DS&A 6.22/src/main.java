import java.util.*;
import dsa622.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		ArrayStack<Integer> A = new ArrayStack<>();
		ArrayStack<Integer> B = new ArrayStack<>(5);
		ArrayStack<Integer> C = new ArrayStack<>(3);
		
		for (int k = 0; k < 100; k++) {
			A.insert(random.nextInt(40)+10);
		}
		
		A.print();
		System.out.println("==============================================================================================================================");
		
		for (int k = 0; k < C.length(); k++) {
			A.dump(A, C);
		}
		
		for (int k = 0; k < B.length(); k++) {
			A.dump(A, B);
		}
		
		A.print();
		B.print();
		C.print();
		
		A.insert(66);
		
		A.print();
		
		
		
	}


}

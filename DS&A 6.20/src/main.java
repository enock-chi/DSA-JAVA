import dsa620.LinkedStack;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r = {3, 2, 1}, s = {5,4}, t = {9,8,7,6};
		
		LinkedStack<Integer> S = new LinkedStack<>(),  R = new LinkedStack<>(), T = new LinkedStack<>();
		
		setStack(S,s);
		setStack(R,r);
		setStack(T,t);
		
		S.print();
		T.print();
		R.print();
		
		transferStack(R,T);
		transferStack(S,R,t.length);
		
		System.out.println("===========================");
		
		S.print();
		R.print();
		T.print();
		

	}
	
	public static void setStack(LinkedStack x, int[] y) {
		for ( int k = 0 ; k < y.length; k++) {
			x.push(y[k]);
		}
	}
	
	public static void transferStack(LinkedStack x, LinkedStack y) {
		int size = y.Size();
		for ( int k = 0 ; k < size; k++) {
			x.push(y.pop());
		}
	}
	
	public static void transferStack(LinkedStack x, LinkedStack y, int num) {
		for ( int k = 0 ; k < num; k++) {
			x.push(y.pop());
		}
	}

}

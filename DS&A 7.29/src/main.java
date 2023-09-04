import java.util.*;
import dsa729.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		
		for ( int k = 1; k <= 10; k++) {
			list.add( k - 1, k);
		}
		
		list.print();
		
		for ( int k = 11; k <= 21; k++) {
			list.add( k - 1, k);
		}
		
		list.print();
		
		for ( int k = 0; k < 12; k++) {
			list.remove(list.size() - 1);
		}
		list.print();

	}

}

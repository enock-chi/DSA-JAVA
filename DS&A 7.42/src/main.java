import dsa742.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		for ( int k = 1; k <= 10; k++) {
			list.addLast(k);
		}
		
		list.print();
		
		list.reverse();
		
		list.print();

	}

}

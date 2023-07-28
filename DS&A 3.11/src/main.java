import dsa311.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dlist<Integer> list = new Dlist<>();
		int[] arr = { 5, 12, 8, 25, 32, 19, 4, 38, 11, 16, 27, 3 };
		
		for ( int k = 0; k < arr.length; k++ ) {
			list.addFirst(arr[k]);
		}
		
		list.output();
		
		list.addLast(100);
		
		list.output();
		
		list.removeFirst();
		
		list.output();
		
		list.removeLast();
		
		list.output();
		
		

	}

}

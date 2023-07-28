import dsa331.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 12, 8, 25, 32, 19, 4, 38, 11, 16, 27, 3 };
		Dub<Integer> list = new Dub<>();
		
		for ( int k = 0; k < arr.length; k++) {
			list.addLast(arr[k]);
		}
		
		list.output();
		
		list.removeFirst();
		
		list.output();
		
		list.removeLast();
		
		list.output();

	}

}

import dsa312.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linked<Integer> list = new Linked<>();
		int[] arr = { 5, 12, 8, 25, 32, 19, 4, 38, 11, 16, 27, 3 };
		
		for ( int k = 0 ; k < arr.length; k++) {
			list.addLast(arr[k]);
		}
		
		list.output();
		
		list.rotate();
		
		list.output();

	}

}

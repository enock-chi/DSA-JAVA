import dsa332.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {25, 45, 12, 34, 3, 20, 42, 28, 7, 17, 38, 50, 9, 16, 5, 31, 23, 47, 18, 11};
		CircularDub<Integer> list = new CircularDub<>();
		
		for ( int k = 0; k < arr.length; k++) {
			list.addLast(arr[k]);
		}
		
		list.output();
		

		

	}

}

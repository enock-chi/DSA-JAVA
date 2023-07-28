import dsa333.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {42, 17, 9, 34, 23, 6, 39, 50, 28, 7, 30, 8, 1, 13, 12, 15, 25, 46, 33, 5};
		CircLink<Integer> list = new CircLink<>();
		
		for ( int k = 0; k < arr.length; k++) {
			list.add(arr[k]);
		}
		
		list.output();


	}

}

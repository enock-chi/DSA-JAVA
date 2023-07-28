import dsa310.*;

public class mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		CircLink<Integer> list = new CircLink<>();
		
		for ( int k = 0; k < arr.length; k++) {
			list.addFirst(arr[k]);
		}
		
		list.output();
		

	}

}

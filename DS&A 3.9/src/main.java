import dsa39.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		int[] arr = {23,45,3,56,8,54,32,42,12,34,18};
		
		for (int k = 0; k < arr.length; k++) {
			list.addFirst(arr[k]);
		}
		
		list.output();
		
		list.addLast(99);
		
		list.output();
		
		list.removeFirst();
		
		list.output();
		
		System.out.println(list.size());
		

	}

}

import java.util.*;
import dsa38.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		CircList<Integer> list = new CircList<>();
		int[] arr = {21, 2, 53, 34, 95, 10, 8, 28, 13, 16, 23, 12};
		
		for (int k = 0; k < arr.length; k++) {
			list.addFirst(arr[k]);
		}
		
		list.output();
		list.findMid();
		list.addLast(4);
		list.output();
		list.findMid();

	}

}

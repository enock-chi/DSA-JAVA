package playground;
import java.util.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<>(List.of(0,1,3));
		recurse(arr,0,new ArrayList());
		
	}
	
	public static void recurse(List<Integer> arr, int x, List<Integer> newList) {
        if (x == arr.size()) {
            System.out.println(newList.toString());
        } else {
                List<Integer> list = new ArrayList<>(newList);
                list.add(arr.get(x));
                recurse(arr, x + 1, list);
                recurse(arr, x + 1, newList);
        }
	}
}

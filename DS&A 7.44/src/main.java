import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int k = 1; k <= 10 ; k++) {
			list.add(k-1, k);
		}
		
		System.out.println(list);
		
		cardShuffle(list);
		
		System.out.println(list);

	}
	
	public static <E> void cardShuffle(ArrayList<E> list) {
		int end ;
		int begin;
		
		if ((list.size() % 2) == 0) {
			begin = end = list.size() / 2;
		} else {
			end = (int)(list.size()/2) + 1;
			begin = (int)(list.size()/2) + 1;
		}
		
		ArrayList<E> list1 = new ArrayList<>(list.subList(0, end));
		ArrayList<E> list2 = new ArrayList<>(list.subList(begin, list.size()));
		for (int k = 0; k < list.size(); k = k+2) {
			if (!list1.isEmpty()) list.set(k,list1.remove(0));
			if (!list2.isEmpty()) list.set(k+1,list2.remove(0));
		}
	}
	

}

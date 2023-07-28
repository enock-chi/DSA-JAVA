import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listing = new ArrayList<>(List.of(1, 6, 3, 8, 9, 4, 7, 12, 5, 10, 11, 2, 13, 16, 15));
		System.out.println(String.valueOf(recurse(listing, new ArrayList<>(),listing.size() - 1)));

	}
	
	public static List<Integer> recurse(List<Integer> list, List<Integer> newList, int count) {
		   if (count < 0) {
			   return newList;
		   } else {
			   if ((list.get(count) % 2) == 0){
				   newList.add(0,list.get(count));
			   } else {
				   newList.add(list.get(count));
			   }
			   return recurse(list,newList, count -1);
		   }
	}

}

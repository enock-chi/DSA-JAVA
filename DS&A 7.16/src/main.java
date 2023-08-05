import java.util.*;
import dsa716.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		
		for (int k = 1; k <= 10 ; k++) {
			list.addLast(k);
		}
		
		list.print();
		
		list.remove(5);
		
		list.print();
		
        list.remove(5);
		
		list.print();
		
		
		
		System.out.println(list.after(6));
		
		System.out.println("==========================================");
		
		dsa716.Iterator<Integer> iterator = list.alternateIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		iterator.remove();
		list.print();

	}
	
	

}

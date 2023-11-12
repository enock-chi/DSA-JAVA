import java.util.ListIterator;

import dsa749.*;

public class main {

	public static void main(String[] args) {
		LinkedPositionalList<Integer> myList = new LinkedPositionalList<>();
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);

        ListIterator<Integer> iterator = myList.listiterator();

        // Iterate forward through the list
        
        Integer element = iterator.next();           
        System.out.println(element);                  
    
        
        myList.print();
       
        iterator.next();
        System.out.println(iterator.hasPrevious());
        
      
        Integer elements = iterator.previous();
        System.out.println(elements);
        
        
       
	}

}

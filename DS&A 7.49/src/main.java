import dsa749.*;

public class main {

	public static void main(String[] args) {
		LinkedPositionalList<Integer> myList = new LinkedPositionalList<>();
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);

        ListIterator<Integer> iterator = myList.listIterator();

        // Iterate forward through the list
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            // Perform some operation with the element
            System.out.println(element);
        }

        // Iterate backward through the list
        while (iterator.hasPrevious()) {
            Integer element = iterator.previous();
            // Perform some operation with the element
            System.out.println(element);
        }
	}

}

import java.util.*;
import dsa726.ArrayBasedList;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayBasedList<Integer> list = new ArrayBasedList<>();
        
        for ( int k = 0; k <= 10; k++) {
        	list.addFront(k);
        }
        
        list.print();
        
        for ( int k = 1; k <= 10; k++) {
        	list.addBack(k);
        }
        
        list.print();
        
        list.removeBack();
        
        list.print();
        
        list.removeFront();
        
        list.print();
        
        list.set(19, 11);
        
        list.set(-1, 11);
        
        list.print();
	}

}

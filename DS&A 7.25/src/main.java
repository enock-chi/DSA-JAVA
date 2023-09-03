import java.util.*;
import dsa725.ArrayBasedList;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayBasedList<Integer> list = new ArrayBasedList<>();
        
        for ( int k = 0; k <= 10; k++) {
        	list.addFront(k);
        }
        
        list.print();
        
        for ( int k = 1 ; k <= 9; k++) {
        	list.addBack(k);
        }
        
        list.print();
        
        list.removeBack();
        list.removeFront();
        
        list.print();
	}

}

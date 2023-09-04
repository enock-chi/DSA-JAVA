import java.util.*;
import dsa727.ArrayBasedList;
public class main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
        ArrayBasedList<Integer> list = new ArrayBasedList<>();
        ArrayBasedList<Integer> oList = new ArrayBasedList<>();
        
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
        
        oList = list.clone();
        
        oList.print();
        
        oList.set(3, 14);
        
        list.print();
        oList.print();
        
	}

}

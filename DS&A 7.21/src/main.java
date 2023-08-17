/**
 * @author Enock Chikobvu
 * 
 * -NOTES [
 *          This is an implementation of a self organizing list using the adapter design method 
 *          of a LinkedPositionalList. The self organizing list is called the "Move to Front Heuristic".
 *          If someone is using the Java Data Structures and Algorithms text book you might have encountered some problems 
 *          of which if using the text book though correct a few details were left out and would cause some errors that could 
 *          take  a while to figure out.
 *            
 *            - 1 ) Your LinkedPositionalList should import java.lang.Iterable
 *            - 2 ) The above applies but for the PositionalList interface, you should then
 *                  extend the interface by Iterable in order to make it possible to Iterate through 
 *                  the instances of Position<Item<e>>.
 *            - 3 ) Create a method to add items to your MTF as this isn't provided in the code segments, and if not done 
 *                  could make it hard to test your program 
 *        ]
 * */

import java.util.*;
import dsa721.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MTF<Integer> mtf = new MTF<>();
		//ArrayList<Position<MTF.Item<Integer>>> pList = new ArrayList<>();
		
		for (int k = 1; k <= 5; k++) {
			mtf.add(k);
		}
		
		mtf.print();
		
		mtf.access(3);
		
		mtf.print();

	}

}

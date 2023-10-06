/**
 * @author Enock Chikobvu
 * 
 * { @code private Position<E> addBetween(E data, Node<E> prev, Node<E> next){
				Node<E> newest = new Node<>(data,prev,next);
				if ( size == 0) {
					head = newest;
					newest.setNext(head);
					newest.setPrev(head);
				} else {
					prev.setNext(newest);
				    next.setPrev(newest);
				}
				size++;
				return newest;
			}
   }
   
   { @literal The code written above works fine for both add last and first however keep in mind
              it's a circular so if printing with refernce to head it will print different.
 */

import dsa748.*;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		
		for (int k = 1; k <= 10; k++) {
			list.addFirst(k);
		}
		
		list.print();
		
		
	}

}

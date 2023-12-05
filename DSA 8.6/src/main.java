import java.util.*;
import dsa86.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
         ArrayList<Position<Integer>> pList = new ArrayList<>();
         pList.add(tree.addRoot(1));
         for ( int k = 2; k <= 10; k++) {
        	 ArrayList<Position<Integer>> tempList = new ArrayList<>();
        	 for ( Position<Integer> p: pList) {
        		 if (k % 2 == 0) {
        			 tempList.add(tree.addLeft(p, k));
        			 k++;
        		 }
        		 tempList.add(tree.addRight(p, k));
        	 }
        	 pList.clear();
        	 pList.addAll(tempList);
        	 tempList.clear();
         }
         tree.print();
         System.out.println();
         tree.printProper();
	}

}

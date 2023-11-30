import java.util.*;
import dsa85.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);
        ArrayList<Position<Integer>> p = new ArrayList<>();
        p.add(tree.addLeft(tree.root(), 2));
        p.add(tree.addRight(tree.root(), 3));
        for (int k = 4; k <= 10; k++) {
            ArrayList<Position<Integer>> tempP = new ArrayList<>();
            for (Position<Integer> c: p) {
            	tempP.add(tree.addLeft(c, k));
            	k++;
            	tempP.add(tree.addRight(c, k));
            }
            p.clear();
            p.addAll(tempP);
            tempP.clear();
            
        }
        tree.print(tree.root(), new ArrayList<>());
        
        System.out.println(tree.leaves());
	}

}

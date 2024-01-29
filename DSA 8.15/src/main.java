import dsa815.*;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		ArrayList<Position<Integer>> list = new ArrayList<>();
		Position<Integer> root = tree.addRoot(0);
		list.add(root);
		list.add(tree.addLeft(root, 1));
		list.add(tree.addRight(root, 2));
		int count = 3;
		for (int k = 1; k <= 10; k = k * 2) {
			for (int x = k ; x <= (k * 2); x++) {
				if (tree.left(list.get(x)) == null) tree.addLeft(list.get(x),count++);
				if (tree.right(list.get(x)) == null) list.add(tree.addRight(list.get(x), count++));
			}
			
		}
		
		tree.print(root);
		System.out.println("");
		System.out.println(tree.level(list.get(10)));
		tree.print(list.get(10));

	}

}

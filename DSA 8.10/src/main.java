import java.util.*;
import dsa810.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
		tree.addRoot("/");
		Position<String> left = tree.addLeft(tree.root(), "+");
		Position<String> right = tree.addRight(tree.root(), "-");
		Position<String> leftsubleft = tree.addLeft(left, "*");
		Position<String> leftsubright = tree.addRight(left, "-");
		Position<String> rightsubleft = tree.addLeft(right, "+");
		Position<String> rightsubright =tree.addRight(right, "/");
		//=================================================================
		tree.addLeft(leftsubleft, "10");
		tree.addRight(leftsubleft,"6");
		tree.addLeft(leftsubright, "4");
		tree.addRight(leftsubright, "12");
		tree.addLeft(rightsubleft, "31");
		tree.addRight(rightsubleft, "2");
		tree.addLeft(rightsubright, "100");
		tree.addRight(rightsubright, "1");
		System.out.println(tree.answer(tree.root()));

	}

}
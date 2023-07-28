import java.util.*;
import dsa36.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		dsa36.LinkedList<Integer> listing = new dsa36.LinkedList<>();
		
		for (int k = 0; k < 10; k++) {
			listing.append(random.nextInt(10) + 1);
		}
		
		listing.display();
		
		System.out.println((int)listing.finder());

	}

}

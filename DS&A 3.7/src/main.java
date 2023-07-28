import java.util.*;
import dsa37.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Random random = new Random();
        ArrayList<Integer> pushkin = new ArrayList<>();
        CircList<Integer> list = new CircList<>();
        
        for (int k = 0; k < 6; k++) {
        	list.addFirst((int)random.nextInt(30) + 1);
        }
        for (int k = 0; k < 6; k++) {
        	int ans = random.nextInt(30) + 1;
        	pushkin.add(ans);
        	list.addLast(ans);
        }
        
        list.output();
        list.removeFirst();
        list.output();
        list.removeLast();
        list.output();
       
	}

}

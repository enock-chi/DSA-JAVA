import java.util.*;
import dsa79.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        dsa79.ArrayList<Integer> list = new dsa79.ArrayList<>();
        
        for (int k = 1; k <= 21; k++) {
        	list.add(k-1, k);
        }
        
        list.print();
	}

}

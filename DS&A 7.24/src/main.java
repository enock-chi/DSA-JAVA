import java.util.*;
import dsa724.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		
		for (int k = 1; k <= 20; k++ ) {
			list.addLast(k);
		}
        
		System.out.println(list.toString());
	}

}

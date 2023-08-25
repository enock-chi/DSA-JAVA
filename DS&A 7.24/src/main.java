import java.util.*;
import dsa724.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MTF<Integer> list = new MTF<>();
		
		for (int k = 1; k <= 20; k++ ) {
			list.access(k);
		}
		
		list.print();
	}

}

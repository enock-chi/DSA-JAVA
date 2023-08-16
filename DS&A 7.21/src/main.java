import java.util.*;
import dsa721.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MTF<Integer> mtf = new MTF<>();
		
		for (int k = 1; k <= 20; k++) {
			mtf.access(k);
		}
		
		System.out.println(mtf.toString());

	}

}

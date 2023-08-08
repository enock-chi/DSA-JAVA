import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Integer>  list= new ArrayList<>(); 
        
        for (int k = 1; k <= 20; k++) {
        	list.add(k);
        }
        
        System.out.println(list.toString());
        Collections.reverse(list);
        System.out.println(list.toString());
	}

}

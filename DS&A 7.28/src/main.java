import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Integer> arr = new ArrayList<>();
        
        for ( int k = 1; k <= 10; k++) {
        	arr.add(k);
        }
        
        System.out.println(arr);
        
        Collections.shuffle(arr);
        
        System.out.println(arr);
        
        shuffle(arr);
        
        System.out.println(arr);
	}
	
	public static <e> void shuffle(List<e> list) {
		Random random = new Random();
		for (int k = 0; k < list.size(); k++) {
			int index = random.nextInt(list.size());
			e temp = list.get(index);
			list.set(index, list.get(k));
			list.set(k, temp);
		}
		
	}

}

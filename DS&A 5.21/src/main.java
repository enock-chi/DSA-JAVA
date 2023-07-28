import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 6, 3, 8, 9, 4, 7, 12, 5, 10, 11, 2, 13, 16, 15};
		System.out.println(Arrays.toString(recurse( Arrays.copyOf(arr,arr.length), 0,0)));

	}
	
	public static int[] recurse( int[] newArr, int count, int x) {
		if ( count == newArr.length-1) {
			System.out.println(newArr.length);
			return newArr;
		} else {
			//System.out.println(x);
			int temp = newArr[count + 1];
			newArr[count + 1] = newArr[count];
			newArr[count] = temp;
			return recurse(newArr,(newArr[count] >= newArr[count+1]) ? 0:count+1, x + 1);
		}
	}

}

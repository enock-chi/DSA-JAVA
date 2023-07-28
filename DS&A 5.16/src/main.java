import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int x = 5;
          int[] a = {5,4,3,2,1};
          int[] b = new int[x];
          int[] c = new int[x];
          recurse(a,b,c,0);
          
	}
	
	public static void recurse(int[] a, int[] b, int[] c, int count) {
		count = ( count < a.length ) ? count : 0;
		if (c[c.length -1] != 0 && count == 4) {
			System.out.print(Arrays.toString(c));
		} else {
			b[count] = a[a.length - count - 1];
			c[count] = b[b.length - count - 1];
			recurse(a,b,c,count + 1 );
		}
	}

}

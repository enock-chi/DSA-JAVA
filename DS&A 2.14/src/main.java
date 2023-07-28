
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] index = new int[4];
		for ( int i = 0; i <= 4 ; i++) {
			try {
				index[i] = i;
			} catch(IndexOutOfBoundsException e) {
				System.out.print("Don’t try buffer overflow attacks in Java!");
			}
			
		}

	}

}

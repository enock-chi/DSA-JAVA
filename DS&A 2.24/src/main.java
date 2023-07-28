import java.util.*;
import dsa224.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Pregression should start where?");
		int first = input.nextInt();
		
		System.out.println("Pregression should have a count of?");
		int second = input.nextInt();
		
		AbsFib seq1 = new AbsFib(first,second);
		seq1.printProgression(10);

	}

}


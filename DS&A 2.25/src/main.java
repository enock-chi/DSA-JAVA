import java.util.*;
import dsa225.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter to numbers to begine the sequence?");
		double current = input.nextLong();
		
		Progression<Double> seq = new SquareRootProgression(current);
		seq.printProgression(10);
		
		input.close();
	}

}

//2.26 is added here.
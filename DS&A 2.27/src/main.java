import java.util.*;
import java.nio.charset.*;
import dsa227.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// this is exercise 2.28 despite naming convention;
		boolean boolSwitch =true;
		Scanner input = new Scanner(System.in);
		Application app = new Application();
		while (boolSwitch) {
           app.menu();
           System.out.println("To terminate, enter \"C\"");
           String string = input.nextLine();
           boolSwitch = (string.equals("C"))? false: true;
		}
		//input.close();
	}

}

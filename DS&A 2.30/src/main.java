import java.util.*;
import dsa230.*;
import java.io.File;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BarChart barChart = new BarChart();
		String relativePath = "../DS&A 2.30/docs/messagetoself.txt";
		
		File file = new File(relativePath);
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				barChart.readline(scanner.nextLine());
			}
			
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		barChart.printCount();
		
	}

}

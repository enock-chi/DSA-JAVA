package dsa230;

public class BarChart {
	private Object[][] alphabet = new Object[26][2];
	private String line = "";
	
	
	public BarChart() {
		initAlphabet();
	}
	
	public void initAlphabet() {
		for (int i = 0; i < 26; i++) {
			alphabet[i][0] = (char)('a'+i);
			alphabet[i][1] = 0;
			
		}
	}
	
	public void readline(String line) {
		this.line = line;
		for ( int i = 0; i < 26; i++) {
			String lowercase = alphabet[i][0].toString();
			String uppercase = lowercase.toUpperCase();
			int count = 0;
			for ( int k = 0; k < line.length(); k++) {
				char comp = line.charAt(k);
				if ((lowercase.equals(Character.toString(comp))) || (uppercase.equals(Character.toString(comp)))) {
					count++;
				}
			}
			alphabet[i][1] = (int)alphabet[i][1] + count;
		}
	}
	
	public void printCount() {
		for (int k = 0; k < 26 ; k++) {
			System.out .println(alphabet[k][0] +" : "+printDot((int)alphabet[k][1]));
		}
	}
	
	public String printDot(int num) {
		String temp = "";
		for (int k = 0; k < (int)(num); k++) {
			temp +=".";
		}
		return temp;
	}

}

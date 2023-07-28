
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "pots&pans";
		System.out.println(recurse(str, str.length() - 1));
         
	}
	
	public static String recurse(String str, int count) {
		String rev = "";
		
		if (count == -1) {
			return "";
		} else {
			rev = rev.concat(String.valueOf(str.charAt(count)));
			return rev + recurse(str,count - 1);
		}
	}

}

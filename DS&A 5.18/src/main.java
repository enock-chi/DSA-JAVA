
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "racecar";
		String str2 = "gohangasalamiimalasagnahog";
		System.out.println(recurse(str,0,str.length()));
		System.out.println(recurse(str2,0,str2.length()));
	}
	
	public static boolean recurse(String str, int x, int y) {
		double check = ((str.length() % 2) == 0) ? str.length() / 2 : Math.ceil(((double)str.length() / 2));
		if ( x > check) {
			return true;
		} else {
			String xS = String.valueOf(str.charAt(x));
			String yS = String.valueOf(str.charAt(y - 1));
			return recurse(str,x+1,y-1) && (xS.equals(yS)) ;
		}
	}

}

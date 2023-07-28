import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Supercalifragilisticexpialidocious";
        recurse(str,str.length() - 1,0,0);
	}
	
	public static void recurse(String str, int x, int vows, int consts) {
		List<String> list = new ArrayList<>(List.of("A","E","I","O","U"));
		if (x < 0) {
			System.out.println(vows);
			System.out.println(consts);
		} else {
			String chr = String.valueOf(Character.toUpperCase(str.charAt(x)));
			recurse(str,x - 1, vows + (list.contains(chr) ? 1 : 0),consts + (list.contains(chr) ? 0 : 1));
		}
	}

}

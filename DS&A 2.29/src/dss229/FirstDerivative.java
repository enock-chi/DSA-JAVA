package dss229;

public class FirstDerivative {
	private String equation ;
	
	public FirstDerivative() {
		this.equation = "x^2+5x+6";
	}
	
	public FirstDerivative(String equation) {
		this.equation = equation;
	}
	
	public String getFirstDiv() {
		String[] split ;
		String[] split1;
		String[] split2;
		
		split = equation.split("[\\+\\-]");
		if (split[0].contains("^")) {
			split1 = split[0].split("[\\^]");
			split2 = split[1].split("(?<=\\d)(?=\\D)");
			
		} else {
			split1 = split[1].split("[\\^]");
			split2 = split[0].split("(?<=\\d)(?=\\D)");
		}
		
		return createFirstDiv(split,split1,split2);
	}
	
	public String createFirstDiv (String[] split, String[] split1, String[] split2) {
		String div = "";
		          if (isNumeric(split1[1])) {
		        	  double coef = Double.parseDouble(split1[1]);
		        	  div += Double.toString(coef) +"x"+ ((coef - 1) <= 1 ? " " : "^"+Double.toString(coef -1)) +" "+ split2[0]+"x";
		          }
		return div;
	}
	
	public boolean isNumeric(String subset) {
		try {
			Double.parseDouble(subset);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}


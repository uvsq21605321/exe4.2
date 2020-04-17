package uvsq.m1.gl;


public enum Operation {
	

	PLUS('+') { 
		public double eval(double a,double b) {
			return a + b;
		}
	},
	MOINS('-') {
		public double eval(double a,double b) {
			return a - b;
		}
	},
	MULT('*') {
		public double eval(double a,double b) {
			return a * b;
		}
	},
	DIV('/') {
		public double eval(double a,double b) throws ArithmeticException {
			if (b == 0)
				throw new ArithmeticException("0");
			else
				return a / b;
		}
	};

	private char sign;


	Operation(char symbole){

		String symboles = "+-*/";
		if (symboles.indexOf(symbole)==-1)
			throw new IllegalArgumentException();
		else
			this.sign = symbole;
	}

	public char getSymbol(){
		return sign;
	}

	public abstract double eval(double val1, double val2) throws ArithmeticException;
}


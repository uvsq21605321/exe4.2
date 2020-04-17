package uvsq.m1.gl;

import java.util.Stack;

public class Interpreteur {

	protected Stack<Double> operandes;
	protected Stack<Stack<Double>> operandesPreced;
	
	
	public Interpreteur() {
		operandes = new Stack<Double>();
		operandesPreced = new Stack<Stack<Double>>();
	}

	public void quit() {
		System.out.println("Out");
		System.exit(0);
		
	}

	public void undo() {
		

		if(operandesPreced.size()>1) {
			operandesPreced.pop();
			operandes=operandesPreced.peek();
		}else {
			operandesPreced.clear();
			operandes.clear();
		}
		

	}


}

package uvsq.m1.gl;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {

	public MoteurRPN() {
		super();
	}

	// enregistrer une opérande
	public void enregistrerOperande(double val) {
		operandes.add(val);
		Stack<Double> temp=new Stack<Double>();
		temp.addAll(operandes);
		operandesPreced.add(temp);
	}
	
		public void appliquerOperation(Operation operation) throws ArithmeticException {
			if (operandes.size() >= 2) {

				double val1 = operandes.pop();

				double val2 = operandes.pop();

				operandes.add(operation.eval(val1, val2));
				
				
				Stack<Double> temp=new Stack<Double>();
				temp.addAll(operandes);
				operandesPreced.add(temp);		
				
			}

			else
				throw new ArithmeticException("pas asez d'operandes pour effectuer l'operation)");
		}
		// la liste des operandes
		public Stack <Double> listeOperandes() {
			
			System.out.print("(");
			for (int i = 0; i < operandes.size(); i++) {
				if (i == operandes.size() - 1) {
					System.out.print(operandes.get(i));
					break;
				}
				System.out.print(operandes.get(i) + "|");
			}
			System.out.print(")");

			return operandes;
			
		}


}
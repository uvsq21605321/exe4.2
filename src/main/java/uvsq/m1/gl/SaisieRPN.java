package uvsq.m1.gl;

import java.util.Scanner;

public class SaisieRPN {
	private Scanner sc;
	private MoteurRPN moteurRPN;
	private final static int MAX_VALUE = 10000000;
	private final static int MIN_VALUE = 1000000;
	private Invoker invoqueur;

	
	public SaisieRPN() {
		
		moteurRPN = new MoteurRPN();
		invoqueur = new Invoker();
		init();
		sc = new Scanner(System.in);

	}


	private void invoqueMoteurRPN(String x) throws ArithmeticException, NumberFormatException {

		switch (x) {

		case "+":
			// perform action on invoker object
			invoqueur.invoquer("plus");
			invoqueur.invoquer("retourner");
			break;
		case "-":
			invoqueur.invoquer("moins");
			invoqueur.invoquer("retourner");
			break;
		case "*":
			invoqueur.invoquer("mult");
			invoqueur.invoquer("retourner");
			break;
		case "/":
			invoqueur.invoquer("div");
			invoqueur.invoquer("retourner");
			break;

		case "undo":
			invoqueur.invoquer("undo");
			invoqueur.invoquer("retourner");
			break;

		case "quit":
			invoqueur.invoquer("quit");
			break;
		default:
			// verification du nombre saisie 
			double operande = Double.parseDouble(x);
			if (Math.abs(operande) > -MIN_VALUE && operande < MAX_VALUE) {

			
				this.invoqueur.invoquer(new Enregistrer(moteurRPN,operande));
				
				invoqueur.invoquer("retourner");
			} else {
				throw new ArithmeticException("opreandes non inclus dans l'intervalle");
			}
			break;
		}

	}

	public void saisie() {

		System.out.println("                 		 *******CALCULATRICE RPN*******");
		System.out.println("Saisir nombre, operation ou exit pour quitter");
		while (true) {
			String str = sc.nextLine();
			try {
				invoqueMoteurRPN(str);
			} catch (ArithmeticException | NumberFormatException msg) {
				System.out.println("incorrecte car : " + msg.getMessage());
				invoqueur.invoquer("retourner");
			}
		}
	}



	private void init() {
		
		Appliquer plus = new Appliquer(moteurRPN, Operation.PLUS);
	
		this.invoqueur.addNewCommande("plus", plus);

		
		Appliquer moins = new Appliquer(moteurRPN, Operation.MOINS);
		
		this.invoqueur.addNewCommande("moins", moins);

		
		Appliquer div = new Appliquer(moteurRPN, Operation.DIV);
		
		this.invoqueur.addNewCommande("div", div);

		
		Appliquer mult = new Appliquer(moteurRPN, Operation.MULT);
		
		this.invoqueur.addNewCommande("mult", mult);
		
		Undo undo =new Undo(moteurRPN);
		this.invoqueur.addNewCommande("undo", undo);
		
		Quit quit=new Quit(moteurRPN);
		this.invoqueur.addNewCommande("quit", quit);
		
		Retourner retourner=new Retourner(moteurRPN);
		this.invoqueur.addNewCommande("retourner", retourner);
	}

}

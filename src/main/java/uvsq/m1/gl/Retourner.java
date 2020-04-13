package uvsq.m1.gl;



public class Retourner implements Command {

	private MoteurRPN moteurRPN;
	
	public Retourner(MoteurRPN moteurRPN){
		this.moteurRPN=moteurRPN;
	}
	
	public void execute() {
		this.moteurRPN.listeOperandes();
	}

}
package uvsq.m1.gl;

public class Enregistrer implements Command {

	private MoteurRPN moteurRPN;
	private Double val;
	
	
	public Enregistrer(MoteurRPN moteurRPN,Double val){
		this.moteurRPN=moteurRPN;
		this.val=val;
	}
	
	public void execute() {
		//open command is forwarding request to openFile method
		this.moteurRPN.enregistrerOperande(val);
	}
}
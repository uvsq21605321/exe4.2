package uvsq.m1.gl;

public class Undo implements Command {

	private Interpreteur intrInterpreteur;
	
	public Undo(Interpreteur intrInterpreteur){
		this.intrInterpreteur=intrInterpreteur;
	}
	
	public void run() {

		this.intrInterpreteur.undo();
	}

}
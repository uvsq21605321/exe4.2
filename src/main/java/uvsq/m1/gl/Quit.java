package uvsq.m1.gl;


public class Quit implements Command {

	private Interpreteur intrInterpreteur;
	
	public Quit(Interpreteur intrInterpreteur){
		this.intrInterpreteur=intrInterpreteur;
	}
	
	public void run() {
		
		this.intrInterpreteur.quit();
	}

}
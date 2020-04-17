package uvsq.m1.gl;


public class Appliquer implements Command {

	private MoteurRPN moteurRPN;
	private Operation operation;
	
	public Appliquer(MoteurRPN moteurRPN,Operation operation){
		this.moteurRPN=moteurRPN;
		this.operation=operation;
	}
	
	public void run() {
		
		this.moteurRPN.appliquerOperation(operation);
	}

}

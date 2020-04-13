package uvsq.m1.gl;

public enum CalculatriceRPN {
	CALCULRPN;
	public void start( String[] args )
    {
		SaisieRPN Saisie = new SaisieRPN();
		Saisie.saisie();
    }
	public static void main(String[] args) {
		CALCULRPN.start(args);
	}
}
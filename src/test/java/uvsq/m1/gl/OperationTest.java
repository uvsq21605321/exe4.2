package uvsq.m1.gl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {

	public class OperationsTest {
		private MoteurRPN M;

		@Before
		public void initialize() {
			M = new MoteurRPN();

		}

		@Test
		public void testOperationplus() {
			double val1 = 10, val2 = 90;
			M.enregistrerOperande(val1);
			M.enregistrerOperande(val2);
			M.appliquerOperation(Operation.PLUS);
			assertTrue(M.listeOperandes().get(0) == 100);

		}

		@Test
		public void testOperationmoins() {
			double val1 = 10, val2 = 90;
			M.enregistrerOperande(val1);
			M.enregistrerOperande(val2);
			M.appliquerOperation(Operation.MOINS);
			assertTrue(M.listeOperandes().get(0) == 80);

		}

		@Test
		public void testOperationmult() {
			double val1 = 10, val2 = 90;
			M.enregistrerOperande(val1);
			M.enregistrerOperande(val2);
			M.appliquerOperation(Operation.MULT);
			assertTrue(M.listeOperandes().get(0) == 900);

		}

		@Test
		public void testOperationdiv() {
			double val1 = 10, val2 = 90;
			M.enregistrerOperande(val1);
			M.enregistrerOperande(val2);
			M.appliquerOperation(Operation.DIV);
			assertTrue(M.listeOperandes().get(0) == 9);

		}
		@Test (expected = ArithmeticException.class)
		public void TestDivisionSurZero(){
			
			double val1=77,val2=0;
			M.enregistrerOperande(val2);
			M.enregistrerOperande(val1);
			M.appliquerOperation(Operation.DIV);
		}
		@Test
		public void testGetSymbol() {
			Operation o = Operation.MOINS;
			assertEquals(o.getSymbol(), '-');

		}

	}
	
}

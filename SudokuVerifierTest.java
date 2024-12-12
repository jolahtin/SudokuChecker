import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void testNegativeValue() {
		int a = v.verify("-417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("negative value", a, -1);
	}
	
	@Test
	public void testSubgridinValid() {
		int a = v.verify("417369825632158947954724316825437169791586432346912758289643571573291684164875293");
		assertEquals("broken subgrid", a, -2);
	}
	
	@Test
	public void testRowinvalid() {
		int a = v.verify("417364825632158947958729316825437169791586432346912758289643571573291684164875293");
		assertEquals("repeated number in row", a, -3);
	}
	
	@Test
	public void testColumnInvalid() {
		int a = v.verify("417369825632158947958724316825437169791586432436912758289643571573291684164875293");
		assertEquals("repeated number in column", a, -4);
	}
	@Test
	public void testUnicodeInvalid() {
		int a = v.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529ä");
		assertEquals("incorrect character", a, 1);
	}
}

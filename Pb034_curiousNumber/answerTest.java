package Q034_curiousNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void factorialOf1Is1()
	{
		assertTrue(1 == Algo.factorial(1));
	}
	
	@Test
	public void factorialOf9Is362880()
	{
		assertTrue(362880 == Algo.factorial(9));
	}
	
	@Test
	public void factorialOf0Is0()
	{
		assertTrue(1 == Algo.factorial(0));
	}
	
	@Test
	public void factorial4f0Is24()
	{
		assertTrue(24 == Algo.factorial(4));
	}
	
	@Test
	public void factorial5f0Is120()
	{
		assertTrue(120 == Algo.factorial(5));
	}
	
	@Test
	public void factorial8f0Is40320()
	{
		assertTrue(40320 == Algo.factorial(8));
	}
	
	@Test
	public void number145IsCuriousNumber()
	{
		assertTrue(Algo.isCuriousNumber(145));
	}
	
	@Test
	public void number40585IsCuriousNumber()
	{
		assertTrue(Algo.isCuriousNumber(145));
	}
	
	
	@Test
	public void number144IsNotCuriousNumber()
	{
		assertFalse(Algo.isCuriousNumber(144));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}

}

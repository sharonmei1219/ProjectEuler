package Q047_consecutiveNumberWith4Factors;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void number644has3Factor()
	{
		assertTrue(3 == Algo.getNumberOfFactor(644));
	}
	
	@Test
	public void number14has2Factor()
	{
		assertTrue(2 == Algo.getNumberOfFactor(14));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}

}

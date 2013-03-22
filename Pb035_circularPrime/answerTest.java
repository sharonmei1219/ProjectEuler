package Q035_circularPrime;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void number31isCircularPrime()
	{
		assertTrue(Algo.isCircularPrime(31));
	}
	
	@Test
	public void number72isNotCircularPrime()
	{
		assertFalse(Algo.isCircularPrime(72));
	}
	
	@Test
	public void number19isNotCircularPrime()
	{
		assertFalse(Algo.isCircularPrime(19));
	}
	
	@Test
	public void number197isCircularPrime()
	{
		assertTrue(Algo.isCircularPrime(197));
	}

	@Test
	public void answer()
	{
		int a = Algo.answer();
	}
}

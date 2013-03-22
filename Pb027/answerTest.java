package Q027_eulerFormularAB;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void number40and40willgive40Primes()
	{
		assertTrue(40 == Algo.getNumberOfPrimes(1,41));
	}
	
	@Test
	public void numberMinus79and16011willgive80Primes()
	{
		assertTrue(80 == Algo.getNumberOfPrimes(-79,1601));
	}
	
	@Test
	public void answer()
	{
//		System.out.print(Algo.getAnswer());
	}
}

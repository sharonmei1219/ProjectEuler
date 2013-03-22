package Q050_sumOfConsecutivPrimes;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void number5isSumOf2CPrimes()
	{
		assertTrue(2 == Algo.getnumberOfConsectutivePrime(5));
	}
	
	@Test
	public void number41isSumOf6CPrimes()
	{
		assertTrue(6 == Algo.getnumberOfConsectutivePrime(41));
	}
	
	@Test
	public void number23isSumOf3CPrimes()
	{
		assertTrue(3 == Algo.getnumberOfConsectutivePrime(23));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}

}

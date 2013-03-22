package Q049_permutationsPrimes;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{
	@Test
	public void number4817isPermutationsOf1487()
	{
		assertTrue(Permutation.isPermutation(4817,1487));
	}
	
	@Test
	public void number4817isNotPermutationsOf1587()
	{
		assertFalse(Permutation.isPermutation(4817,1587));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.getAnswer();
	}

}

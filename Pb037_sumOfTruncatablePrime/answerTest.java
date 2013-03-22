package Q037_sumOfTruncatablePrime;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{
	@Test
	public void number19IsNotTruncatablePrime()
	{
		assertFalse(Algo.isTruncatable(19));
	}
	
	@Test
	public void number3797IsTruncatablePrime()
	{
		assertTrue(Algo.isTruncatable(3797));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}

}

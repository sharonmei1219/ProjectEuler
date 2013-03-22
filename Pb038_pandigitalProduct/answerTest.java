package Q038_pandigitalProduct;

import static org.junit.Assert.*;

import org.junit.Test;


public class answerTest
{

	@Test
	public void concate123and456WillGet123456()
	{
		assertTrue(123456 == Algo.concatenateNumber(123, 456));
	}

	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}
}

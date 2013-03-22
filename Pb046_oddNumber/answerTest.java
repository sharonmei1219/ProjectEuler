package Q046_oddNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void number5isNotASquareNumber()
	{
		assertFalse(Algo.isSquare(5));
	}
	
	@Test
	public void number9isNotASquareNumber()
	{
		assertTrue(Algo.isSquare(9));
	}
	
	@Test
	public void number21SumOfAPrimeAndTwiceSquare()
	{
		assertTrue(Algo.isSumOfAPrimeAndTwiceSquare(21));
	}

	@Test
	public void number3SumOfAPrimeAndTwiceSquare()
	{
		assertTrue(Algo.isSumOfAPrimeAndTwiceSquare(33));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}
}


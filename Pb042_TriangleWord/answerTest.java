package Q042_TriangleWord;

import static org.junit.Assert.*;

import org.junit.Test;


public class answerTest
{


	
	@Test
	public void stringSKYisValueOf55()
	{
		assertTrue(55 == Algo.getStringValue("SKY"));
	}
	
	@Test
	public void stringABisValueOf3()
	{
		assertTrue(3 == Algo.getStringValue("AB"));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}
}

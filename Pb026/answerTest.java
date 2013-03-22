package Q026_greatestCycle;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void cycleLengthOf6Is1()
	{
		int result = Algo.cycleLength(6);
		assertTrue(1 == result);
	}
	
	@Test
	public void cycleLengthOf7Is6()
	{
		assertTrue(6 == Algo.cycleLength(7));
	}
	
//	@Test
//	public void answer()
//	{
//		System.out.print(Algo.greatestCycle());
//	}

}

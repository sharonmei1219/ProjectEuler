package Q030_sumOfDigitalPower5;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void number1634canBeWrittenAsSumOfDigitalPowerOf4()
	{
		assertTrue(Algo.canNumberWritenAsSumOfEachDigPow(1634, 4));
	}
	
	@Test
	public void number1633canBeWrittenAsSumOfDigitalPowerOf4()
	{
		assertTrue(false == Algo.canNumberWritenAsSumOfEachDigPow(1633, 4));
	}
	
	@Test
	public void number8208canBeWrittenAsSumOfDigitalPowerOf4()
	{
		assertTrue(Algo.canNumberWritenAsSumOfEachDigPow(8208, 4));
	}
	
	@Test
	public void answer()
	{
		System.out.print(Algo.getSum(5));
	}

}

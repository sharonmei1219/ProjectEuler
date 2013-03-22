package Q040_NthDigitalOfirrationalNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{

	@Test
	public void thereAre9DigitalsBefore10()
	{
		assertTrue(9 == Algo.getNumberOfDigitalInFractionBeforIntegerWithNDigitals(2));
	}
	
	@Test
	public void thereAre189DigitalsBefore100()
	{
		assertTrue(189 == Algo.getNumberOfDigitalInFractionBeforIntegerWithNDigitals(3));
	}
	
	@Test
	public void number1isTheFirstDigital()
	{
		assertTrue(1 == Algo.getNthDigital(1));
	}
	
	@Test
	public void number5isThe100thDigital()
	{
		assertTrue(5 == Algo.getNthDigital(100));
	}
	
	@Test
	public void number2isThe15thDigital()
	{
		assertTrue(2 == Algo.getNthDigital(15));
	}
	
	@Test
	public void number1isThe16thDigital()
	{
		assertTrue(1 == Algo.getNthDigital(16));
	}
	
	@Test
	public void number3isThe17thDigital()
	{
		assertTrue(3 == Algo.getNthDigital(17));
	}
	
	@Test
	public void number9isThe189thDigital()
	{
		assertTrue(9 == Algo.getNthDigital(189));
	}
	
	@Test
	public void number1isThe190thDigital()
	{
		assertTrue(1 == Algo.getNthDigital(190));
	}
	
	
	@Test
	public void number3isThe261thDigital()
	{
		assertTrue(3 == Algo.getNthDigital(261));
	}
	
	@Test
	public void number2isThe260thDigital()
	{
		assertTrue(2 == Algo.getNthDigital(260));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}

}

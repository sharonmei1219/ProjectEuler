package Q048_lastTenDigital;

import static org.junit.Assert.*;

import org.junit.Test;

public class testAnswer
{

	@Test
	public void tenDigital9876543210123ToString()
	{
		TenDigitalNumber a = new TenDigitalNumber("9876543210123");
		assertTrue(a.toString().equals("6543210123"));
	}
	
	@Test
	public void tenDigitalNumberAdd()
	{
		TenDigitalNumber a = new TenDigitalNumber("9876543210123");
		TenDigitalNumber b = new TenDigitalNumber("1111111111111");
		a.add(b);
		assertTrue(a.toString().equals("7654321234"));
	}
	
	@Test
	public void tenDigitalNumberAddWithJinWei()
	{
		TenDigitalNumber a = new TenDigitalNumber("9876543210123");
		TenDigitalNumber b = new TenDigitalNumber("1116111111111");
		a.add(b);
		assertTrue(a.toString().equals("2654321234"));
	}
	
	@Test
	public void tenDigitalNumberMutiply()
	{
		TenDigitalNumber a = new TenDigitalNumber("9876543210123");
		a.multiply(1000);
		assertTrue(a.toString().equals("3210123000"));
	}
	
	@Test
	public void answer()
	{
		Algo.answer();
	}
}

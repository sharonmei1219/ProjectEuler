package Q036_palindromicNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class answerTest
{
	@Test
	public void getPalindromicNumberOf123InEvenDigitalsIs321123()
	{
		assertTrue(321123 == Algo.getPalindromicNumberInOct(123, 1));
	}
	
	@Test
	public void getPalindromicNumberOf124InEvenDigitalsIs421124()
	{
		assertTrue(421124 == Algo.getPalindromicNumberInOct(124, 1));
	}
	
	@Test
	public void getPalindromicNumberOf124InOddDigitalsIs421124()
	{
		assertTrue(42124 == Algo.getPalindromicNumberInOct(124, 10));
	}
	
	@Test
	public void getPalindromicNumberOf1234InOddDigitalsIs4321234()
	{
		assertTrue(4321234 == Algo.getPalindromicNumberInOct(1234, 10));
	}
	
	@Test
	public void getPalindromicNumberOf100InOddDigitalsIs0()
	{
		assertTrue(0 == Algo.getPalindromicNumberInOct(100, 10));
	}
	
	@Test
	public void number2IsNotPalindromicNumberInBinary()
	{
		assertFalse(Algo.isNumberPalindromicInBinary(2));
	}
	
	@Test
	public void number5IsPalindromicNumberInBinary()
	{
		assertTrue(Algo.isNumberPalindromicInBinary(5));
	}
	
	@Test
	public void number19IsNotPalindromicNumberInBinary()
	{
		assertFalse(Algo.isNumberPalindromicInBinary(19));
	}
	
	@Test
	public void number585585IsNotPalindromicNumberInOct()
	{
		assertTrue(Algo.isNumberPalindromicInOct(585585));
	}
	
	@Test
	public void number585585IsNotPalindromicNumberInBinary()
	{
		assertTrue(Algo.isNumberPalindromicInBinary(585585));
	}
	
	@Test
	public void getAnswer()
	{
		Algo.answer();
	}
}

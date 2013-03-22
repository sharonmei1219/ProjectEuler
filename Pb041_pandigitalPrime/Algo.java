package Q041_pandigitalPrime;

import Primes.Primes;
import PandigitalNumber.*;

public class Algo
{
	public static class RecordPrimePandigital extends PandigitalsLoopStrategy
	{
		public int primePandigital = 0;

		@Override
		public void accessPandigital(long Pandigital)
		{
			
			if (Primes.isPrime((int)Pandigital))
			{
				if (Pandigital > primePandigital)
					primePandigital = (int)Pandigital;

			}
		}
		
		@Override
		public long answer()
		{
			
	return primePandigital;
		}
	}
	
	static public void answer()
	{
		PandigitalsLoopStrategy primeRecorder = new RecordPrimePandigital();
		PandigitalsLoop pandigitalLoop = new PandigitalsLoop(primeRecorder);
		int bitMap = 0x3FF;
		
		for(int pandigitalWeiShu = 9; pandigitalWeiShu >= 1; pandigitalWeiShu --)
		{
			bitMap = (bitMap >> 1);
			pandigitalLoop.transverse(bitMap, 0);
		}
		
		System.out.print("the answer is: ");
		System.out.println(primeRecorder.answer());
	}
}

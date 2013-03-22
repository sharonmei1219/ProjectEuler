package Q043_subDivStringPandigitals;

public class SubDiv
{

	public static int prime[] = { 2, 3, 5, 7, 11, 13, 17 };

	public static boolean isSubDivStringNumber(long number)
	{
		int subNumber = (int) (number % 100 * 10);
		number /= 100;
		int primeIndex = 6;
		
		while (primeIndex >= 0)
		{
			subNumber /= 10;
			subNumber += number % 10 * 100;
			number /= 10;

			if (0 != subNumber % prime[primeIndex])
			{
				return false;

			}
			primeIndex--;
		}

		return true;
	}

}

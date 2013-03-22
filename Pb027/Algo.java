package Q027_eulerFormularAB;

public class Algo
{
	public static int getAnswer()
	{
		int numberOfPrimes = 0;
		int answer = 0;

		for (int a = 999; a > -1000; a--)
		{
			for (int b = 999; b > -1000; b--)
			{
				int n = getNumberOfPrimes(a, b);
				if (n >= numberOfPrimes)
				{
					numberOfPrimes = n;
					answer = a * b;
				}
			}
		}

		return answer;
	}

	public static int getNumberOfPrimes(int a, int b)
	{
		int n = 0;

		while (isPrime(n * n + a * n + b))
			n++;

		return n;
	}

	private static boolean isPrime(int number)
	{
		if (number < 0) return false;
		for (int i = 2; i <= Math.sqrt(number); i++)
		{
			if (0 == number % i)
				return false;
		}
		return true;
	}
}

package Q034_curiousNumber;

public class Algo
{
	public static int FACTORIAL[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	public static int factorial(int number)
	{
		if (-1 != FACTORIAL[number])
			return FACTORIAL[number];
		else
		{
			int result = 1;
			for (int factor = number; factor > 1; factor--)
				result *= factor;
			FACTORIAL[number] = result;
			return result;
		}
	}

	public static boolean isCuriousNumber(int number)
	{
		int sumOfFactorial = 0;
		int factor = number;

		while (factor > 0)
		{
			sumOfFactorial += factorial(factor % 10);
			factor /= 10;
		}

		if (sumOfFactorial == number)
			return true;

		return false;
	}

	public static int answer()
	{
		int sum = 0;
		for (int number = 10; number < 10000000; number++)
		{
			if (isCuriousNumber(number))
			{
				System.out.println(number);
				sum += number;
			}

		}
		
		System.out.print("the answer is: ");
		System.out.println(sum);
		return sum;
	}
}

package Q040_NthDigitalOfirrationalNumber;

public class Algo
{
	static public void answer()
	{
		int sum = 1;
		for (int i = 1; i <= 6; i++)
		{
			sum *= getNthDigital((int) Math.pow(10, i));
		}

		System.out.print("sum = ");
		System.out.println(sum);
	}

	public static int getNthDigital(int N)
	{
		int numberOfDigitals = 2;
		int numberOfDigitalsBefore = 0;

		while (N > getNumberOfDigitalInFractionBeforIntegerWithNDigitals(numberOfDigitals))
		{
			numberOfDigitals++;
		}

		numberOfDigitals--;

		int numberOffset = N
				- getNumberOfDigitalInFractionBeforIntegerWithNDigitals(numberOfDigitals);

		int number = 0;
		if (numberOfDigitals == 1)
		{
			number = numberOffset / numberOfDigitals;
		} else
		{
			number = (int) Math.pow(10, (numberOfDigitals - 1)) + numberOffset
					/ numberOfDigitals - 1;
		}



		int digitalOffset = 0;

		if (0 != numberOffset % numberOfDigitals)
		{
			number++;
			digitalOffset = numberOfDigitals - numberOffset % numberOfDigitals + 1;

		} else
		{
			digitalOffset = 1;
		}

		for (int i = 1; i < digitalOffset; i++)
		{
			number /= 10;
		}

		return number % 10;

	}

	public static int getNumberOfDigitalInFractionBeforIntegerWithNDigitals(
			int number)
	{
		int numberOfDigitals = 0;
		for (int numberOrder = 1; numberOrder < number; numberOrder++)
		{
			numberOfDigitals += 9 * Math.pow(10, (numberOrder - 1))
					* numberOrder;
		}
		return numberOfDigitals;
	}

}

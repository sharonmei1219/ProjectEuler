package Q038_pandigitalProduct;
import PandigitalNumber.PandigitalNumber;

public class Algo
{
	public static void answer()
	{
		int maxConcatenatedProduct = 0;
		for (int number = 1; number <= 100000; number ++)
		{
			int concatenatedProduct = greatestConcProductWithoutDupDigital(number);

			if ( PandigitalNumber.isPandigitalNumber(concatenatedProduct))
			{
				if (maxConcatenatedProduct < concatenatedProduct)
					maxConcatenatedProduct = concatenatedProduct;
			}
		}

		System.out.print("the answer is: ");
		System.out.println(maxConcatenatedProduct);

		return;
	}

	private static int greatestConcProductWithoutDupDigital(int number)
	{
		int concatenatedProduct = 0;
		int nextConcatenatedProduct = number;
		
		for(int multiplier = 2; !PandigitalNumber.hasDuplicateNumber(nextConcatenatedProduct); multiplier++)
		{
			concatenatedProduct = nextConcatenatedProduct;
			nextConcatenatedProduct = concatenateNumber(concatenatedProduct,
					multiplier * number);
		}
		return concatenatedProduct;
	}

	public static int concatenateNumber(int numberA, int numberB)
	{
		for (int digitalCounts = numberB; digitalCounts > 0; digitalCounts /= 10)
		{
			numberA *= 10;
		}

		return numberA + numberB;
	}

}

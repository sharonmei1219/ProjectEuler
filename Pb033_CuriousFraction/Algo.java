package Q033_CuriousFraction;

public class Algo
{

	public static void answer()
	{
		try
		{
			Fraction product = new Fraction(1, 1);

			for (int denominator = 10; denominator <= 100; denominator++)
			{
				for (int numerator = 10; numerator < denominator; numerator++)
				{
					FractionInterface candidate = new Fraction(numerator, denominator);
					FractionInterface signature = buildSignatureFraction(numerator, denominator);
					
					if (signature.equals(candidate))	product.multiplex(new Fraction(numerator, denominator));

				}
			}

			product.toLowestCommonTerm();
			System.out.print("the answer is: ");
			System.out.println(product.denominator);
		}

		catch (ZeroDeminatorException e)
		{
		}

	}
	
	private static FractionInterface buildSignatureFraction(int numerator, int denominator)
	{
		int digitalsNumerator [] = {numerator / 10, numerator % 10};
		int digitalDenominator [] = {denominator / 10, denominator % 10};
		
		try
		{
		for (int digitalsN = 0; digitalsN < 2; digitalsN ++)
			for(int digitalsD = 0; digitalsD < 2; digitalsD ++)
			{
				if (digitalsNumerator[digitalsN] == digitalDenominator[digitalsD])
				{
					if (0 != digitalsNumerator[digitalsN])
					return new Fraction(digitalsNumerator[1-digitalsN], digitalDenominator[1-digitalsD]);
				}
			}

		return new NullFraction();
		}
		catch(ZeroDeminatorException e)
		{
			return new NullFraction();
		}
	}
	
}

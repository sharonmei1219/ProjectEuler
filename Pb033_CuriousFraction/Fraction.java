package Q033_CuriousFraction;

public class Fraction implements FractionInterface
{
	public int numerator;
	public int denominator;

	public Fraction(int numerator, int denominator) throws ZeroDeminatorException
	{
		if (0 == denominator) throw new ZeroDeminatorException();

		this.numerator = numerator;
		this.denominator = denominator;
	}

	public void multiplex(Fraction fractionB)
	{
		this.numerator *= fractionB.numerator;
		this.denominator *= fractionB.denominator;
	}

	@Override
	public int getNumerator()
	{
		return numerator;
	}

	@Override
	public int getDenominator()
	{
		return denominator;
	}

	@Override
	public boolean equals(FractionInterface fractionB)
	{
		try
		{
			Fraction fractionA = new Fraction(this.numerator, this.denominator);

			fractionA.toLowestCommonTerm();
			fractionB.toLowestCommonTerm();

			if (fractionA.getNumerator() == fractionB.getNumerator()
					&& fractionA.getDenominator() == fractionB.getDenominator())
				return true;

			return false;
		} catch (ZeroDeminatorException e)
		{
			return false;
		}
	}

	@Override
	public void toLowestCommonTerm()
	{
		int factor = 2;
		while (factor <= numerator)
		{
			if (0 == numerator % factor && 0 == denominator % factor)
			{
				numerator /= factor;
				denominator /= factor;
			} else
			{
				factor++;
			}
		}
	}
}

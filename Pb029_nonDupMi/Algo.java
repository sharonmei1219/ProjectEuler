package Q029_nonDupMi;

public class Algo
{
	public static int numberOfNonDupMi(int input)
	{
		int total = (input - 1) * (input -1);
		
		for (int a = input; a >= 2; a --)  total -= getNumberOfDuplicate(a, input);

		return total;
	}

	public static int getNumberOfDuplicate(int number, int upBound)
	{
		int di = beMiOfOtherNumber(number);

		int duplicate = 0;
		
		int miRang = log(di, upBound);
		int neatMi = log(di, number);
		
	    for (int Mi = 2; Mi <= upBound; Mi++)
	    {
	    	if(hasFactorInRange(Mi * neatMi, neatMi, miRang)) 	duplicate++;
  	    }
	    
		return duplicate;
	}
	
	public static int beMiOfOtherNumber(int number)
	{
	    for(int i = 2; i <= number; i++)
	    {
	    	int devidedNumber = number;
	    	while (0 == devidedNumber%i) devidedNumber = devidedNumber/i;
	    	if(1 == devidedNumber) return i;
	    }
	    return number;
	}
	
	public static int log(int di, int number)
	{
		int mi = 0;
		while (0 != number)
		{
			number = number/di;
			mi++;
		}
		return mi - 1;
	}
	
	
	public static boolean hasFactorInRange(int number, int lowBound, int upBound)
	{
        for (int factor = 2; factor < number; factor ++)
        {
        	if ( 0 == number%factor && factor <= upBound && factor > lowBound) return true;
        }
		
        return false;
	}
}

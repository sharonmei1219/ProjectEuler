package Q047_consecutiveNumberWith4Factors;

public class Algo
{
	public static void answer()
	{
		int count = 0;
		int number = 2;
		
		while (4 != count)
		{
			if (4 == getNumberOfFactor(number)) 
				{
				count ++;
				}
			else count = 0;
			
			number ++;
		}
		
		System.out.print("the answer is :");
		System.out.println(number - 4);
		
	}
	
	public static int getNumberOfFactor(int number)
	{
		int factor = 2;
		int numberOfFactor = 0;
		
		while (number > 1)
		{
			if(0 == number % factor) numberOfFactor ++;
			while (0 == number % factor) number /= factor;
			factor ++;
		}
		
		return numberOfFactor;
	}

}

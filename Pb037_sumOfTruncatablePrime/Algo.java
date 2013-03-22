package Q037_sumOfTruncatablePrime;

public class Algo
{
	
	public static void answer()
	{
		int count = 0;
		int number = 10;
		int sum = 0;
		
		while(count < 11)
		{
			if(isTruncatable(number))
			{
				count ++;
				sum += number;
			}
			
			number ++;
		}
		System.out.print("Q037 the answer is: ");
		System.out.println(sum);
	}
public static boolean isTruncatable(int number)
{

int factor = 1;
while(number/factor > 0)
{
    if (!isPrime(number/factor) || !isPrime(number%factor)) return false;
	factor *= 10;
}

return true;
}

public static boolean isPrime(int number)
{
	int squrtNumber = (int) Math.floor(Math.sqrt(number))+1;
	int pn = 2;
	
	if(1 == number) return false;
	
	while (pn < squrtNumber)
	{
		if (0 == number%pn) 
			return false;
		
		pn ++;
	}
	return true;
}
}

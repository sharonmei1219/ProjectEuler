package Q035_circularPrime;

public class Algo
{
	public static int answer()
	{
		int count = 0;
		for (int number = 2; number < 1000000; number ++)
		{
			if(isCircularPrime(number)) count ++;
		}
		System.out.print("the answer is: ");
		System.out.print(count);
		return count;
	}
	
	public static boolean isCircularPrime(int number)
	{
		int rotatedNumber = number;
		do
		{
			if(!isPrime(rotatedNumber)) return false;
			rotatedNumber = rotate(rotatedNumber);
		}while(number != rotatedNumber);
		
		return true;
	}
	
	public static int rotate(int number)
	{
		int high = number%10;
		int low = number/10;
		
		while(number > 10)
		{
			high *= 10;
			number /= 10;
		}
		return high + low;
	}
	
	public static boolean isPrime(int number)
	{
    	int squrtNumber = (int) Math.floor(Math.sqrt(number))+1;
    	int pn = 2;
    	
    	while (pn < squrtNumber)
    	{
    		if (0 == number%pn) 
    			return false;
    		
    		pn ++;
    	}
    	return true;
	}
}

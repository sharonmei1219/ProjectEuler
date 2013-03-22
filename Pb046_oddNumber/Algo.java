package Q046_oddNumber;
import Primes.Primes;

public class Algo
{
	public static void answer()
	{
		int oddNumber = 33;
		
		while(isSumOfAPrimeAndTwiceSquare(oddNumber))
		{
			oddNumber += 2;
			while(Primes.isPrime(oddNumber)) oddNumber += 2;
		}
		
		System.out.print("the answer is: ");
		System.out.println(oddNumber);
	}
	
	public static boolean isSumOfAPrimeAndTwiceSquare(int number)
	{
		int primeIndex = 1;
		int prime = Primes.get(primeIndex);
		
		while(prime < number)
		{
			int factor = (number - prime)/2;
			if(isSquare(factor))
			{
//				System.out.print(number);
//				System.out.print(" = ");
//				System.out.print(prime);
//				System.out.print(" + 2 * ");
//				System.out.println(factor);
				return true;
			}
			
			primeIndex ++;
			prime = Primes.get(primeIndex);
		}
		
		return false;
	}
	
	public static boolean isSquare(int number)
	{
		int factor = (int) Math.sqrt(number);
		if (factor * factor == number)
			return true;
		return false;
	}
}

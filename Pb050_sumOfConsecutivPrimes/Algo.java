package Q050_sumOfConsecutivPrimes;

import Primes.Primes;

public class Algo
{

	public static void answer()
	{
		int primeIndex = 2;
		int prime = Primes.get(primeIndex);
		int thePrimeWithMaxPrimeSub = 0;
		int maxPrimeSub = 0;
		while (prime < 1000000)
		{
//			System.out.println(prime);
			int numberOfConsectutivePrime = getnumberOfConsectutivePrime(prime);
			if(numberOfConsectutivePrime > maxPrimeSub)
			{
				thePrimeWithMaxPrimeSub = prime;
				maxPrimeSub = numberOfConsectutivePrime;
				System.out.print("prime: ");
				System.out.print(prime);
				System.out.print("has ");
				System.out.println(maxPrimeSub);

				
			}
			
			primeIndex ++;
			prime = Primes.get(primeIndex);
		}
		
		System.out.print("the answer is: ");
		System.out.println(thePrimeWithMaxPrimeSub);
	}
	
	public static int getnumberOfConsectutivePrime(int number)
	{
		int primeIndex = 1;
		int prime = Primes.get(primeIndex);
		int count = 1;
		int sum = prime;
		while(prime <= number)
		{
			primeIndex ++;
			prime = Primes.get(primeIndex);
			sum += prime;
			count ++;
			
			while(sum > number)
			{ 
				int primeToSubIndex = primeIndex - count + 1;
				int primeToSub = Primes.get(primeToSubIndex);
				sum -= primeToSub;
			   count --;
			 }
			
			if(sum == number) return count;
		}
		
		return count;

	}
}

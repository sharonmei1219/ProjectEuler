package Q049_permutationsPrimes;

import Primes.Primes;
import java.util.*;

public class Algo
{
	public static void getAnswer()
	{
		int basePrimeIndex = getFirstPrimeIndex(1000);

		while (Primes.get(basePrimeIndex) < 9999)
		{
			List<Integer> primes = getPermutationList(basePrimeIndex);
			List <Integer> equalGap = buildEqualGapList(primes);
			
			if(equalGap.size() >= 3)
			{
				Iterator <Integer> it = equalGap.iterator();
				while (it.hasNext())
				{
					System.out.print(it.next());
					System.out.print(", ");
				}
				System.out.println();
			}
			
			basePrimeIndex ++;
		}

	}

	private static List<Integer> getPermutationList(int basePrimeIndex)
	{
		int permutationPrimeIndex = basePrimeIndex + 1;
		int permutationPrime = Primes.get(permutationPrimeIndex);
		
		int basePrime = Primes.get(basePrimeIndex);
		List <Integer> primes = new LinkedList<Integer>();
		
		primes.add(basePrime);
		
		while (permutationPrime < 9999)
		{
			if (Permutation.isPermutation(basePrime, permutationPrime))
			{
				primes.add(permutationPrime);
			}
			permutationPrimeIndex++;
			permutationPrime = Primes.get(permutationPrimeIndex);
		}
		return primes;
	}
	
	private static List<Integer> buildEqualGapList(List <Integer> primes)
	{
		List<Integer> equalGapList = new LinkedList<Integer>();
		Iterator<Integer> it = primes.iterator();
		
		while(it.hasNext())
		{
			int firstPrime = it.next();
			Iterator <Integer> itSecond = it;
			while(itSecond.hasNext())
			{
				int secondPrime = itSecond.next();
				int gap = secondPrime - firstPrime;
				int thirdPrime = secondPrime + gap;
				if(primes.contains(thirdPrime))
				{
					equalGapList.add(firstPrime);
					equalGapList.add(secondPrime);
					equalGapList.add(thirdPrime);
				}
			}
		}
		
		return equalGapList;
		
	}
	
	public static int getFirstPrimeIndex(int number)
	{
		int i = 1;
		while (Primes.get(i) < number)
			i++;
		return i;
	}
}

package Q045_nextMixtureOfTrianglePentagonalHex;

import java.math.BigInteger;

import InterestingNumber.InterestingNumber;

public class Algo
{

	public static void answer()
	{
		BigInteger n = new BigInteger("144");
		boolean found = false;
		while (!found)
		{
			BigInteger nthH = InterestingNumber.getNthHexagonal(n);
			
			if (InterestingNumber.isPentagonal(nthH))
			{
				found = true;
				System.out.print("the answer is: ");
				System.out.println(nthH.toString());
			}

			n = n.add(new BigInteger("1"));
		}
	}
	
	public static void answerDouble()
	{
		int n =  2;
		boolean found = false;
		while (!found)
		{
			double nthH = InterestingNumber.getNthHexagonal(n);
			
			if (InterestingNumber.isPentagonal(nthH))
			{
				found = true;
				System.out.print("the answer is: ");
				System.out.println(nthH);
			}

			n = n++;
		}
	}
}

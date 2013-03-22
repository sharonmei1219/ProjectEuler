package Q044_minPentagonalDifference;

import InterestingNumber.InterestingNumber;

public class Algo
{
	public static int getNthPentagonal(int n)
	{
		return (n * (3 * n - 1))/2;
	}
	
	public static void answer()
	{
		int m = 1;
		int n = 1;
		int minDiffernce = 100000000;
		boolean fineMinDifference = false;
		
		while (!fineMinDifference)
		{
			int mthP = getNthPentagonal(m);
			n = m - 1;
			int minGap = mthP - getNthPentagonal(n);
			if (minDiffernce < minGap) 
				{
				System.out.print("the answer is: ");
				System.out.println(minDiffernce);
				fineMinDifference = true;
				}
			
			while(!fineMinDifference && n > 0)
			{
				int nthP = getNthPentagonal(n);
				if (InterestingNumber.isPentagonal(mthP + nthP) && InterestingNumber.isPentagonal(mthP - nthP))
				{
					if(mthP - nthP < minDiffernce) 
						{minDiffernce = mthP - nthP;
						System.out.println(minDiffernce);
						fineMinDifference = true;
						
						}
				}
				n --;
			}
			m ++;
		}
		
	}

}

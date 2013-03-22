package Q036_palindromicNumber;

public class Algo
{
	public static int answer()
	{
	int sum = 0;
		for(int number = 0; number < 1000000; number ++)
		{
//			for(int overlap = 0; overlap < 2; overlap++)
//			{
//				int palindromicNumber = getPalindromicNumberInOct(number, palindromicOverlap[overlap]);
//				if (palindromicNumber < 1000000 && isNumberPalindromicInBinary(palindromicNumber))
//				{
//					System.out.println(palindromicNumber);
//					sum += palindromicNumber;
//				}
//			}
			
			if(isNumberPalindromicInBinary(number) && isNumberPalindromicInOct(number))
				{
				System.out.println(number);
				sum += number;
			}
				
		}
		System.out.print("the answer is: ");
		System.out.println(sum);
		return sum;
	}
	public static int getPalindromicNumberInOct(int number, int palindromicOverlap)
	{
		if (0 == number%10) return 0;
		
		int lower = number;
		int higher = 0;
		int factor = palindromicOverlap;
		
		int lowerB;
//		if (palindromicOverlap == 1) lowerB = palindromicOverlap - 1;
//		else lowerB = palindromicOverlap;
		lowerB = palindromicOverlap - 1;
		
		
		while (number >  lowerB)
		{
			higher *= 10;
			higher += number % 10;
			
			number /= 10;
			factor *= 10;
		}
		
		return higher * factor + lower;
	}
	
	public static boolean isNumberPalindromicInBinary(int number)
	{
		if (0 == (number & 1)) return false;
		
		int reversNumber = 0;
		int normalNumber = number;
		
		while (0 != number)
		{
			reversNumber <<= 1;
			reversNumber += (number & 1);
			number >>= 1;
		}
		
		if (reversNumber == normalNumber) return true;
		
		return false;
	}
	
	public static boolean isNumberPalindromicInOct(int number)
	{
		if (0 == (number % 10)) return false;
		
		int reversNumber = 0;
		int normalNumber = number;
		
		while (0 != number)
		{
			reversNumber *= 10;
			reversNumber += (number % 10);
			number /= 10;
		}
		
		if (reversNumber == normalNumber) return true;
		
		return false;
	}
	
	
	static int palindromicOverlap[] = {1, 10};
}

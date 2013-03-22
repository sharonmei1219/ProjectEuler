package Q030_sumOfDigitalPower5;

public class Algo
{
	
	public static int getSum(int pow)
	{
		int sum = 0;
		for (int num = 2; num <= 1000000; num++)
		{
			if(canNumberWritenAsSumOfEachDigPow(num,pow)) sum += num;
		}
		return sum;
	}
	
	
	public static boolean canNumberWritenAsSumOfEachDigPow(int number, int pow)
	{
		int tempNumber = number;
		int sum = 0;
		while (0 != tempNumber)
		{
			int digital = tempNumber % 10;
			tempNumber /= 10;
			sum += (int) Math.pow(digital, pow);
		}

		if (sum == number)
			return true;
		return false;
	}
}

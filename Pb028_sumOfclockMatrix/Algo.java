package Q028_sumOfclockMatrix;

public class Algo
{
	public static int answer()
	{
		int sum = 1;
		for (int i = 1; i <= 500; i++)
		{
			sum += (16 * i * i + 4 * i + 4);
		}
		return sum;
	}
}

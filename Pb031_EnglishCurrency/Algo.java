package Q031_EnglishCurrency;

public class Algo
{
	public static int UNIT[] = {1, 2, 5, 10, 20, 50, 100, 200};
	 
	public static int getNumberOfExpression(int total, int unitNumber)
	{
		if (0 == unitNumber || 0 == total) return 1;

		int numberOfExpression = 0;
		
		while (total >= 0)
		{
			numberOfExpression += getNumberOfExpression(total, unitNumber - 1);
			total -= UNIT[unitNumber];
		}
		
		return numberOfExpression;
	}
}

package Q048_lastTenDigital;

public class Algo
{
	public static void answer()
	{
		TenDigitalNumber sum = new TenDigitalNumber(0);
		for(int number = 1; number <= 1000; number ++)
		{
			TenDigitalNumber mi = new TenDigitalNumber(number);
			for(int factor = 1; factor < number; factor ++)
			{
				mi.multiply(number);
			}
			sum.add(mi);
		}
	
		System.out.print("the answer is: ");
		System.out.println(sum.toString());
	}

}

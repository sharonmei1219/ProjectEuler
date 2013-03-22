package Q048_lastTenDigital;

public class TenDigitalNumber
{
	private long number;

	public TenDigitalNumber(String strNumber)
	{
		String tenDigNumber;
		int len = strNumber.length();
		if (len > 10)
		{
			tenDigNumber = strNumber.substring(len - 10, len);
		} else
		{
			tenDigNumber = strNumber;
		}
		number = Long.parseLong(tenDigNumber);
	}
	
	public TenDigitalNumber(int number)
	{
		this.number = number;
	}
	
	public void add(TenDigitalNumber b)
	{
		this.number += b.number;
		long factor = (long) Math.pow(10, 10);
		if (number > factor) number %= factor; 
	}
	
	public void multiply(int n)
	{
		number *= n;
		long factor = (long) Math.pow(10, 10);
		if (number > factor) number %= factor; 
	}

	public String toString()
	{
		return String.valueOf(number);
	}
}

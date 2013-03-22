package Q043_subDivStringPandigitals;
import PandigitalNumber.*;

public class SubDivPadigitalsCollector extends PandigitalsLoopStrategy
{
	private int beginDigital;
	private int endDigital;
	private long sum;

	public SubDivPadigitalsCollector(int begin, int end)
	{
		this.beginDigital = begin;
		this.endDigital = end;
		sum = 0;
	}

	public int begin()
	{
		return beginDigital;
	}

	public int end()
	{
		return endDigital;
	}
	
	public void accessPandigital(long pandigital)
	{
		
		if(SubDiv.isSubDivStringNumber(pandigital))
		{
			sum += pandigital;
		}
		
	}
	
	public long answer()
	{
		return sum;
	}
}

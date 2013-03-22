package Q043_subDivStringPandigitals;
import PandigitalNumber.*;

public class Algo
{
	public static void answer()
	{
		PandigitalsLoopStrategy subDivCollector = new SubDivPadigitalsCollector(9, 0);
		PandigitalsLoop pandigitals = new PandigitalsLoop(subDivCollector);
		pandigitals.transverse(0x3FF, 0);
		
		System.out.print("the answer is: ");
		System.out.println(subDivCollector.answer());
	}

}

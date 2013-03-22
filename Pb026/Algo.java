package Q026_greatestCycle;

import java.util.*;

public class Algo
{
	public static int greatestCycle()
	{
		int greatestCycleLength = 0;
		int greatestCycleNumber = 7;
		
		for (int i = 1; i < 1000; i++)
		{
			int cl = cycleLength(i);
			if (greatestCycleLength < cl)
			{
				greatestCycleLength = cl;
				greatestCycleNumber = i;
			}
		}
		
		return greatestCycleNumber;
	}

	public static int cycleLength(int number)
	{
		int restA = 1;
		Vector<Integer> restVector = new Vector<Integer>();

		while (!hasElement(restVector, restA) && 0 != restA)
		{
			restVector.add(new Integer(restA));
			restA = restA % number;
			restA *= 10;
		}

		return restVector.size() - positionOfElement(restVector, restA);
	}

	private static boolean hasElement(Vector<Integer> restVector, int restA)
	{
		for (int i = 0; i < restVector.size(); i++)
		{
			if (restA == restVector.get(i))
				return true;
		}
		return false;
	}

	private static int positionOfElement(Vector<Integer> restVector, int restA)
	{
		for (int i = 0; i < restVector.size(); i++)
		{
			if (restVector.get(i) == restA)
				return i;
		}

		return 0;
	}
}

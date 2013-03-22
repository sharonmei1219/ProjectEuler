package Q032_pandigital;

import java.util.*;

public class Algo
{
	public static List<Integer> digitals;
	public static List<Integer> uniqProducts;

	public static int getNumberOfExpression()
	{
		uniqProducts = new ArrayList<Integer>();
		
		digitals = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) digitals.add(i);

		getNumberOfExpressionWith1stNumberIs(0);
		
		int sumOfProducts = 0;
		for (int i = 0; i < uniqProducts.size(); i++) sumOfProducts += uniqProducts.get(i);

		return sumOfProducts;
	}

	public static void getNumberOfExpressionWith1stNumberIs(int firstNumber)
	{
		int index = 0;

		while (index < digitals.size())
		{
			int digital = digitals.get(index);
			digitals.remove(index);

			int newFirstNumber = 10 * firstNumber + digital;

			getNumberOfExpressionWith2NumbersAre(newFirstNumber, 0);
			getNumberOfExpressionWith1stNumberIs(newFirstNumber);

			digitals.add(index, digital);
			index++;
		}
	}

	public static void getNumberOfExpressionWith2NumbersAre(int firstNumber,
			int secondNumber)
	{
		int index = 0;
		int newSecondNumber = 10 * secondNumber;

		while (index < digitals.size() && newSecondNumber < firstNumber)
		{
			int digital = digitals.get(index);
			digitals.remove(index);

            newSecondNumber = 10 * secondNumber + digital;
			
			int product = firstNumber * newSecondNumber;
			if (is3Pandigital(product))
			{
				if(!uniqProducts.contains(product))
					uniqProducts.add(product);
			}
			
			getNumberOfExpressionWith2NumbersAre(firstNumber, newSecondNumber);

			digitals.add(index, digital);
			index++;
		}
	}

	
	public static boolean is3Pandigital(int product)
	{
		int thirdNumber = product;
		int numberOfDig = 0;

		List<Integer> thirdNumberDigit = new ArrayList<Integer>();

		while (thirdNumber > 0)
		{
			int digital = thirdNumber % 10;
			thirdNumber /= 10;
			numberOfDig++;

			if (!thirdNumberDigit.contains(digital))
			{
				thirdNumberDigit.add(digital);
			} else
			{
				return false;
			}

			if (!digitals.contains(digital))
				return false;
		}

		if (numberOfDig == digitals.size())
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
}

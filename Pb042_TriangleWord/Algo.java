package Q042_TriangleWord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import InterestingNumber.InterestingNumber;

public class Algo
{

	
	public static int getStringValue(String string)
	{
		int value = 0;
		for (char ch : string.toCharArray()) 
			value += ch - 'A' + 1;
		
		return value;
	}
	
	public static void answer()
	{
		try
		{
			FileReader inputFile = new FileReader("d:\\words.txt");
			BufferedReader inputBuffer = new BufferedReader(inputFile);
			String line = inputBuffer.readLine();
			String [] strs = line.split(",|\"");
			line.split(",", 3);
			
			int count = 0;
			for (String str : strs)
			{
				if (str.length() > 0)
				{
				int value = getStringValue(str);
				if (InterestingNumber.isTriangleNumber(value)) count ++;
				}
			}
			
			System.out.print("the answer is: ");
			System.out.println(count);


		} catch (IOException e)
		{
			System.out.println("file not found!");
		}
	}
	}


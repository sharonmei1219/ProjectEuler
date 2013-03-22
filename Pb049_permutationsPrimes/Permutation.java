package Q049_permutationsPrimes;

public class Permutation
{
	public static class BitMap
	{
		int bitMap[];
		
		public BitMap (int number)
		{
			bitMap = new int [3];
			int index = 0;
			
			while (number > 0)
			{
				int bit = (1 << number%10);
				setBit(bit, index);
				number /= 10;
			}
		}
		
		public boolean equals(BitMap bitMap)
		{
			for(int i = 0; i < 3; i ++)
			{
				if (this.bitMap[i] != bitMap.bitMap[i]) return false;
			}
			
			return true;
		}
		
		private void setBit(int bit, int index)
		{
			if (bit == (bit & bitMap[index])) 
			{
				setBit(bit, index + 1);
			}
			else
			{
				bitMap[index] |= bit;
			}
		}
	}
	
	static public boolean isPermutation(int numberA, int numberB)
	{
		BitMap bitMapA = new BitMap(numberA);
		BitMap bitMapB = new BitMap(numberB);
		return bitMapA.equals(bitMapB);
	}
}

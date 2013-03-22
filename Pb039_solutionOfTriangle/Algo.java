package Q039_solutionOfTriangle;

public class Algo
{
	public static void answer()
	{
		int maxNumberOfSolutions = 0;
		int perimeterWithMaxSoltuions = 0;
		for (int perimeter = 1; perimeter < 1000; perimeter++)
		{
			int numberOfSolution = 0;
			for (int shortEdge = 1; shortEdge < perimeter / 3; shortEdge++)
			{
				int longEdge = shortEdge;
				int bevelEdge = perimeter - shortEdge - longEdge;
				while (shortEdge * shortEdge + longEdge * longEdge < bevelEdge
						* bevelEdge)
				{
					longEdge++;
					bevelEdge = perimeter - shortEdge - longEdge;
				}
				if (shortEdge * shortEdge + longEdge * longEdge == bevelEdge
						* bevelEdge)
				{
					numberOfSolution++;
					if (maxNumberOfSolutions < numberOfSolution)
					{
						maxNumberOfSolutions = numberOfSolution;
						perimeterWithMaxSoltuions = perimeter;
					}
				}
			}
		}
		
		System.out.print("the answer is: ");
		System.out.print(perimeterWithMaxSoltuions);
	}
}

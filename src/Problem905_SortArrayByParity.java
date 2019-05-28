import java.util.Arrays;
import java.util.Scanner;

public class Problem905_SortArrayByParity
{
	private static int[] sortArrayByParity(int[] A)
	{
		int i = 0;
		int j = A.length - 1;
		
		while (i < j)
		{
			while (i < A.length && 0 == A[i] % 2) i++;
			while (j >= 0 && 0 != A[j] % 2) j--;
			if (i < j)
			{
				A[i] += A[j];
				A[j] = A[i] - A[j];
				A[i] -= A[j];
			}
		}
		return A;
	}
	
	public static void main(String[] arg)
	{
		Scanner inputScanner = new Scanner(System.in);
		String inputString = inputScanner.nextLine();
		inputScanner.close();
		
		String[] inputStringNumbers = inputString.substring(1, inputString.length() - 1).split(",");
		int[] inputNumbers = Arrays.stream(inputStringNumbers).mapToInt(Integer::parseInt).toArray();
		
		System.out.println(Arrays.toString(sortArrayByParity(inputNumbers)));
	}
}

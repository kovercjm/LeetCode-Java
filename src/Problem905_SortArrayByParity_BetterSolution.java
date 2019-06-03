import java.util.Arrays;
import java.util.Comparator;

public class Problem905_SortArrayByParity_BetterSolution
{
	
	public int[] sortArrayByParity_1(int[] A)
	{
		Integer[] B = new Integer[A.length];
		for (int t = 0; t < A.length; ++ t)
			B[t] = A[t];
		
		Arrays.sort(B, Comparator.comparingInt(a -> a % 2));
		
		
		for (int t = 0; t < A.length; ++ t)
			A[t] = B[t];
		return A;
	}
	
	public int[] sortArrayByParity_2(int[] A)
	{
		return Arrays.stream(A)
				.boxed()
				.sorted(Comparator.comparingInt(a -> a % 2))        // .sorted((a, b) -> Integer.compare(a % 2, b % 2))
				.mapToInt(i -> i)
				.toArray();
	}
	
	public int[] sortArrayByParity_3(int[] A)
	{
		int n = A.length;
		int []b = new int[n];
		int j = 0, k = n - 1;
		
		for (int a : A)
			if (a % 2 == 0)
				b[j++] = a;
			else
				b[k--] = a;
		return b;
	}
}

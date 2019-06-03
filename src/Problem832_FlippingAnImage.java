import java.util.Arrays;
import java.util.Scanner;

public class Problem832_FlippingAnImage
{
	private static int[][] flipAndInvertImage(int[][] A)
	{
		for (int[] row : A)
		{
			for (int start = 0, end = row.length - 1; start < end; ++start, --end)
			{
				if (row[start] == row[end])
					row[start] = row[end] = row[start] ^ 1;         // 'row[start] ^ 1' is better than the original '(row[start] == 0) ? 1 : 0'.
			}
			if (0 != row.length % 2)
				row[row.length / 2] = row[row.length / 2] ^ 1;
		}
		
		return A;
	}
	
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		String inputString = inputScanner.nextLine();
		inputScanner.close();
		
		String[] inputRows = inputString.replace("[", "").replace(",", " ").split("]");
		int[][] inputNumbers = new int[inputRows.length][];
		for (int i = 0; i < inputRows.length; ++i)
		{
			inputNumbers[i] = Arrays.stream(inputRows[i].trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		System.out.println(Arrays.deepToString(flipAndInvertImage(inputNumbers)));
	}
}

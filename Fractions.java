package BetterShiz;
public class Fractions 
{
	public static void main(String args[]) 
	{
		double decimal=3.14;
		double originalDecimal;
		int LIMIT = 5;
		int denominators[] = new int[LIMIT + 1];
		int numerator, denominator, temp;
		int MAX_GOODNESS = 100;

		originalDecimal = decimal;

		// Display the header information
		System.out.println("Input decimal number to be converted: " + decimal);
		System.out.println();

		// Compute all the denominators
		System.out.println("All computed denominators:");
		int i = 0;
		while (i < LIMIT + 1) 
		{
			denominators[i] = (int)decimal;
			System.out.print(denominators[i] + "  ");
			decimal = 1.0 / (decimal - denominators[i]);
			i = i + 1;
		}
		System.out.println("\n");

		// Compute the i-th approximation
		int last = 0;
		while (last < LIMIT) 
		{
			// Print out the denominators used in this computation
			System.out.print("Using these " + (last + 1) + " denominators: ");
			for (int j = 0; j <= last; j++) 
				System.out.print(denominators[j] + "  ");
			System.out.println();
			
			// Initialize variables used in computation
			numerator = 1;
			denominator = 1;
			temp = 0;

			// Do the computation
			int current = last;
			while (current >= 0) 
			{
				denominator = numerator;
				numerator = (numerator * denominators[current]) + temp;
				temp = denominator;
				current = current - 1;
			}
			last = last + 1;

			// Display results
			double value = (double)numerator/denominator;
			int goodness = denominators[last];
			double error = 100 * Math.abs(value - originalDecimal) / originalDecimal;

			System.out.print("fraction = " + (int)numerator + "/" +(int)denominator);
			System.out.print(", value = " + value);
			System.out.print(", goodness = " + goodness);
			System.out.println(", error = " + (int)error + "%");
			System.out.println();

			// Exit early if we have reached our goodness criterion
			if (Math.abs(goodness) > MAX_GOODNESS) break;
		}        
	}
}
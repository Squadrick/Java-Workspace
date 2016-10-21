package BetterShiz;
public class Rooter 
{
	public static void main(String[] args)
	{
		double s = System.nanoTime();
		double x = findSquareRoot(2);
		double e = System.nanoTime();
		System.out.println("Result: "+x+"\tTime Taken: "+(e-s)+"\tResult: "+x*x);
	}
	public static double findSquareRoot(double number)
	{
		double g1, squareRoot = number/2;
		for(int i=0;i<5;i++){
			g1 = squareRoot;
			squareRoot = (g1 + (number/g1))/2;}
		
		return squareRoot;
	}
}


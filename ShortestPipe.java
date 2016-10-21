package BasicShiz;
/*
 * What is the length of the shortest pipe, of internal radius 50mm, that can fully contain 21 balls of radii 30mm, 31mm, ..., 50mm?
 * *Give your answer in micrometres (10-6 m) rounded to the nearest integer.
 */
public class ShortestPipe 
{
	public static void main(String args[])
	{
		double totalVolume=0;
		for(double r=30;r<=50;r++)
			totalVolume+=4/3*Math.PI*r*r*r;
		double finalVol=totalVolume/(50*50*Math.PI);
		System.out.println(Math.rint(finalVol*100));	
	}
}

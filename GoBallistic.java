package hp.code.thirteen;
import java.util.Scanner;
public class GoBallistic 
{
	private static Scanner sc;
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		float v = sc.nextFloat();
		float w = sc.nextFloat();
		float distance = (float) (Math.pow(v, 2)*Math.sin(2*w*3.14159265/180)/9.80665);
		System.out.println(distance);
	}

}

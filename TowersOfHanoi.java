package BetterShiz;
class TowersOfHanoi
{
	static void tower(int n,String sourceRod,String destinationRod,String auxiliaryRod)
	{
		if(n==0)return;
		tower(n-1,sourceRod,auxiliaryRod,destinationRod);
		System.out.println(n+" from "+sourceRod+" to "+destinationRod);
		tower(n-1,auxiliaryRod,destinationRod,sourceRod);
	}
	public static void main(String arg[])
	{
		tower(5,"Source","Destination","Aux");
	}
}
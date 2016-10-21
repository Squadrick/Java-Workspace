class biasedRandom //5.1-3
{
	public static void main(String args[])
	{

	}
	public static int BIASED_ONE_OR_ZERO()
	{
		//return 0 with a probability of p
		//return 1 with a probability of 1-p
	}
	public static int RANDOM_ZERO_OR_ONE()
	{
		int x = BIASED_ONE_OR_ZERO();
		int y = BIASED_ONE_OR_ZERO();
		if(x!=y)
			return x;
		retutn RANDOM_ZERO_OR_ONE();
	}
}
//Probability of a succesful return is 2p(p-1)
//Expected number of trials if 1/(2p(p-1))
//Running time is O(1/(2p(p-1)))
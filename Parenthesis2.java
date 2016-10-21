package BetterShiz;
public class Parenthesis2 
{
    public static void main(String[] args) 
    {
        brackets(4, 0 , 0, new char[4*2]);
    }
    static void brackets(int open, int close, int index, char[] arr) 
    {
        while (close >= 0) 
        {
            if (open > 0) 
            {
                arr[index] = '(';
                brackets(open-1, close+1, index+1, arr);
            }
            if (close-- > 0) 
            {
                arr[index++] = ')';
                if (index == arr.length) 
                    System.out.println(arr);
            }
        }
    }
}
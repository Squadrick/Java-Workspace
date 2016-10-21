public class reverseLinkedList
{
	static Node head;
	public static void main(String args[])
	{
		Node start = new Node(1);
		initialize(start,8);
		printList(start);
		reverseUtil(start,null);
		printList(head);
	}
	private static void reverseUtil(Node curr, Node prev) 
	{
		if(curr == null)
		{
			head = prev;
			return;
		}
		Node next = curr.next;
		curr.next = prev;
		reverseUtil(next,curr);
    }
	private static void initialize(Node start, int limit)
	{
		Node temp = start;
		for(int i = 2; i <= limit;i++)
		{
			Node s = new Node(i);
			temp.next = s;
			temp = s;
		}
	}
	private static void printList(Node start)
	{
		Node node = start;
		while(node!=null)
		{
			node.show();
			node = node.next;
		}
		System.out.println("");
	}	
}
class Node
{
	int data;
	Node next;
	public Node(int d)
	{
		data = d;
		next = null;
	}
	void show()
	{
		System.out.print(data+" ");
	}
}
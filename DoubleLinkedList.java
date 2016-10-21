class DoubleLinkedList
{
	public static void main(String args[])
	{
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		one.connectAfter(two);
		one.connectAfter(three);
	}
}
class Node
{
	int data;
	Node prev;
	Node next;
	Node(int d)
	{
		data = d;
		prev = null;
		next = null;
	}
	void connectAfter(Node node)
	{
		if(this.next == null)
		{
			this.next = node;
			node.prev = this;
		}
		else
		{
			Node temp = this.next;
			this.next = node;
			node.prev = this;
			node.next = temp;
			temp.prev = node;
		}
	}
	void connectBefore(Node node)
	{
		if(this.prev == null)
		{
			node.next = this;
			this.prev = node;
		}
		else
		{
			Node temp = this.prev;
			this.prev = node;
			node.next = this;
			temp.next = node;
			node.prev = temp;
		}
	}
}
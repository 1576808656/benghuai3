package mazeSolve;

public class LinkedListQueue<E> implements Queue<E> {
	
	private class Node {
		public E e;
		public Node next;
		public Node(E e) {
			this.e = e;
			this.next = null;
		}
		public Node(E e,Node next) {
			this.e = e;
			this.next = next;
		}
		public Node() {
			this.e = null;
			this.next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if(tail == null) {
			tail = new Node(e,tail);
			head = tail;
		}else {
			tail.next = new Node(e,null);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Dequeue failed. Queue is empty");
		}
		Node resNode = head;
		head = head.next;
		resNode.next = null;
		if(head == null) {
			tail = null;
		}
		size--;
		return resNode.e;
	}

	@Override
	public E getFront() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Dequeue failed. Queue is empty");
		}
		return head.e;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	@Override
	public String toString() {
		Node cur = head;
		StringBuilder res = new StringBuilder();
		res.append(String.format("LinkedListQueue. size = %d\n front[", size));
		for(int i=0;i<size;i++) {
			res.append(cur.e);
			if(i < size-1)
				res.append(", ");
			cur = cur.next;
		}
		res.append("] tail");
		return res.toString();
	}
	
}

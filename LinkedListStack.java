package mazeSolve;

public class LinkedListStack<E> implements Stack<E> {

	private LinkedList<E>list;
	
	public LinkedListStack() {
		list = new LinkedList<>();
	}
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack: top[");
		for(int i=0;i<getSize();i++) {
			res.append(list.get(i));
			if(i < getSize()-1) {
				res.append(", ");
			}
		}
		res.append("] tail");
		return res.toString();
	}

}

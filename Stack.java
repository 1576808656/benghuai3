package mazeSolve;

public interface Stack<E> {
	
	/**
	 * 
	 * @param e
	 */
	void push(E e);
	
	E pop();
	
	E peek();
	
	int getSize();
	
	boolean isEmpty();
	
	int length();
	
}

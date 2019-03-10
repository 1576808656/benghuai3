package mazeSolve;

public interface Queue<E> {
	void enqueue(E e);
	E dequeue();
	//查看队首元素
	E getFront();
	int getSize();
	boolean isEmpty();
}

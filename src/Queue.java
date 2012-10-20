import java.util.LinkedList;
import java.util.List;


public class Queue<T> {

	private List<T> queue;
	
	public Queue() {
		queue = new LinkedList<T>();
	}
	
	public void insert(T elem) {
		queue.add(elem);
	}
	
	public T front() {
		return queue.get(0);
	}
	
	public T remove() {
		return queue.remove(0);
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
}

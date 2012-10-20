import java.util.LinkedList;
import java.util.List;


public class Stack<T> {
	
	private List<T> stack;
	
	public Stack() {
		stack = new LinkedList<T>();
	}
	
	public void push(T elem) {
		stack.add(elem);
	}
	
	public T peek() {
		return stack.get(0);
	}
	
	public T pop() {
		return stack.remove(0);
	}
	
	public int size() {
		return stack.size();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
}

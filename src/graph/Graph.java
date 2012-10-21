package graph;

import java.util.List;
import java.util.Set;

public interface Graph<T> {

	public void addNode(T elem);
	public void addEdge(T from, T to);
	public Set<T> nodeSet();
	public boolean hasNode(T elem);
	public boolean isEdge(T from, T to);
	public int size();
	public boolean isEmpty();
	public void removeNode(T elem);
	public void removeEdge(T from, T to);
	public List<T> getConnected(T elem);
	
}

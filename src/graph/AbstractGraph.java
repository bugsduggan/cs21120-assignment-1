package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class AbstractGraph<T> implements Graph<T> {

	protected HashMap<T, List<T>> map;
	
	public AbstractGraph() {
		map = new HashMap<T, List<T>>();
	}
	
	@Override
	public void addNode(T elem) {
		map.put(elem, new LinkedList<T>());
	}

	@Override
	public Set<T> nodeSet() {
		return map.keySet();
	}

	@Override
	public boolean hasNode(T elem) {
		return map.containsKey(elem);
	}

	@Override
	public boolean isEdge(T from, T to) {
		if (!map.containsKey(from) || !map.containsKey(to))
			return false;
		return map.get(from).contains(to);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public void removeNode(T elem) {
		map.remove(elem);
	}
	
	@Override
	public List<T> getConnected(T elem) {
		return map.get(elem);
	}

}

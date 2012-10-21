package graph;

public class UndirectedGraph<T> extends AbstractGraph<T> {

	@Override
	public void addEdge(T from, T to) {
		if (!map.containsKey(from))
			addNode(from);
		if (!map.containsKey(to))
			addNode(to);
		map.get(from).add(to);
		map.get(to).add(from);
	}

	@Override
	public void removeEdge(T from, T to) {
		map.get(from).remove(to);
		map.get(to).remove(from);
	}
	
}

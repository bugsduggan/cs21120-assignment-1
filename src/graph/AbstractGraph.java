package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractGraph<T> implements Graph<T> {

  protected Map<T, List<T>> map;

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

  @Override
  public void removeEdge(T from, T to) {
    if (!map.containsKey(from))
      addNode(from);
    if (!map.containsKey(to))
      addNode(to);
    map.get(from).remove(to);
    map.get(to).remove(from);
  }

  @Override
  public void addEdge(T from, T to) {
    map.get(from).add(to);
    map.get(to).add(from);
  }

}

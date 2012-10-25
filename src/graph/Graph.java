package graph;

import java.util.List;
import java.util.Set;

/**
 * A graph interface
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public interface Graph<T> {

  /**
   * Adds a node to the graph with no connections
   *
   * @param elem
   */
  public void addNode(T elem);

  /**
   * Adds a connection from one node to another
   *
   * @param from
   * @param to
   */
  public void addEdge(T from, T to);

  /**
   * Returns all nodes in the graph
   *
   * @return a set of all nodes
   */
  public Set<T> nodeSet();

  /**
   * Returns true if elem is a node in this graph
   *
   * @param elem
   * @return     true if graph contains <code>elem</code>
   */
  public boolean hasNode(T elem);

  /**
   * Returns true if there is a connection from <code>from</code> to <code>to</code>
   *
   * @param from
   * @param to
   * @return     true is <code>from</code> is connected to <code>to</code>
   */
  public boolean isEdge(T from, T to);

  /**
   * The number of nodes in this graph
   *
   * @return the number of nodes
   */
  public int size();

  /**
   * Returns true if there are no nodes in the graph
   *
   * @return true if empty
   */
  public boolean isEmpty();

  /**
   * Removes a node from the graph (if it exists)
   *
   * @param elem
   */
  public void removeNode(T elem);

  /**
   * Removes a connection from the graph (if it exists)
   *
   * @param from
   * @param to
   */
  public void removeEdge(T from, T to);

  /**
   * Returns the elements connected from <code>elem</code>
   *
   * @param elem
   * @return     elements referenced by <code>elem</code>
   */
  public List<T> getConnected(T elem);

}

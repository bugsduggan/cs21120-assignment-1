import graph.WordGraph;

import java.util.LinkedList;
import java.util.List;


public class Generator {
	
	private WordGraph graph;
	private int depth;
	private List<String> visited;
	
	public List<String> generateLadder(String start, int depth) {
		List<String> ladder = new LinkedList<String>();
		graph = new WordGraph(start.length());
		if (depth <= 0 || !graph.hasNode(start))
			return ladder;
		
		ladder.add(start);
		this.depth = depth;
		visited = new LinkedList<String>();
		visited.add(start);
		
		ladder = findLadder(ladder, depth - 1);
		if (ladder.size() == 1 && depth != 1) {
			return new LinkedList<String>();
		}
		return ladder;
	}
	
	private List<String> findLadder(List<String> ladder, int toFind) {
		if (toFind <= 0)
			return ladder;
		
		String current = ladder.get(ladder.size() - 1);
		List<String> search = graph.getConnected(current);
		search.removeAll(ladder);
		search.removeAll(visited);
		
		for (String s : search) {
			ladder.add(s);
			visited.add(s);
			findLadder(ladder, toFind - 1);
			if (ladder.size() == depth)
				break;
			ladder.remove(ladder.size() - 1);
		}
		
		return ladder;
	}
	
}

import graph.WordGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Discoverer {

	private WordGraph graph;
	
	public List<String> discoverLadder(String start, String end) {
		
		List<String> ladder = new LinkedList<String>();
		if (start.length() != end.length())
			return ladder;
		
		graph = new WordGraph(start.length());
		if (!graph.hasNode(start) || !graph.hasNode(end))
			return ladder;
		
		// end of variable declarations and sanity-checks
		
		Queue<String> search = new LinkedList<String>();
		Map<String, Integer> cost = new HashMap<String, Integer>();		
		
		search.add(start);
		cost.put(start, 0);
		while (!search.isEmpty()) {
			String current = search.remove();
			if (end.equals(current)) {
				ladder.add(current);
				return ladder;
			}
			List<String> next = graph.getConnected(current);
			next.removeAll(cost.keySet());
			search.addAll(next);
			
			for (String s : next) {
				cost.put(s, cost.get(current) + 1);
			}
		}
		
		return ladder;
	}
	
	public static void main(String[] args) {
		Discoverer d = new Discoverer();
		List<String> ladder = d.discoverLadder("head", "foot");
		for (String s : ladder)
			System.out.println(s);
	}
	
}

import graph.WordGraph;

import java.util.LinkedList;
import java.util.List;


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
		
		ladder.add(start);
		ladder = findLadder(ladder, end);
		
		return ladder;
	}

	private List<String> findLadder(List<String> ladder, String end) {
		String current = ladder.get(ladder.size() - 1);
		if (end.equals(current))
			return ladder; // job done
		
		List<String> search = graph.getConnected(current);
		search.removeAll(ladder);
		for (String s : search) {
			ladder.add(s);
			findLadder(ladder, end);
			if (ladder.contains(end))
				break;
			ladder.remove(ladder.size() - 1);
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

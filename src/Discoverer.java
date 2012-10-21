import graph.WordGraph;

import java.util.LinkedList;
import java.util.List;


public class Discoverer {

	public List<String> discoverLadder(String start, String end) {
		
		List<String> ladder = new LinkedList<String>();
		if (start.length() != end.length())
			return ladder;
		
		WordGraph graph = new WordGraph(start.length());
		if (!graph.hasNode(start) || !graph.hasNode(end))
			return ladder;
		
		// end of variable declarations and sanity-checks
		
		return null;
	}
	
}

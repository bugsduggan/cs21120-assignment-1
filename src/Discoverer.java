import java.util.LinkedList;
import java.util.List;


public class Discoverer {

	public List<String> discoverLadder(String start, String end) {
		
		List<String> ladder = new LinkedList<String>();
		if (start.length() != end.length())
			return ladder;
		
		Graph graph = new Graph("dict" + start.length() + ".dat");
		if (!graph.contains(start) || !graph.contains(end))
			return ladder;
		
		// end of variable declarations and sanity-checks
		
		return null;
	}
	
}

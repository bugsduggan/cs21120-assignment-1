import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Generator {
	
	private Graph graph;
	
	public List<String> generateLadder(String start, int depth) {
		graph = new Graph("dict" + start.length() + ".dat");
		return findLadder(start, depth);
	}
	
	private List<String> findLadder(String start, int depth) {
		List<String> ladder = new LinkedList<String>();
		if (depth <= 0)
			return ladder;
		
		ladder.add(start);
		if (ladder.size() == depth)
			return ladder;
		
		// MOAR CODEZ HERE PLOX
		
		return ladder;
	}
	
	public static void main(String[] args) {
		Generator g = new Generator();
		List<String> ladder = g.generateLadder("click", 100);
		for (int i = 0; i < ladder.size(); i++) {
			System.out.println((i + 1) + " - " + ladder.get(i));
		}
	}
	
}

import static org.junit.Assert.*;

import org.junit.Test;


public class GraphTest {

	private Graph graph = new Graph("dict5.dat");
	
	@Test
	public void testGetAdjacentWords() {
		if(!graph.getAdjacentWords("clock").contains("click"))
			fail("click not adjacent to clock");
		if(!graph.getAdjacentWords("click").contains("clock"))
			fail("clock not adjacent to click");
		if(graph.getAdjacentWords("clock").contains("clock"))
			fail("clock is adjacent to clock");
		if(graph.getAdjacentWords("clock").contains("shock"))
			fail("shock is adjacent to clock");
	}

}

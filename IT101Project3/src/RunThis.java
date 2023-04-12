import java.util.ArrayList;
import java.util.List;

public class RunThis {
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		s.add(4);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(1);
		s.add(2);
		s.add(4);
		s.add(1);
		s.add(2);
		s.add(0);
		List<Integer> v = new ArrayList<Integer>();
		if(isSolvable(0,s,v)) {
			System.out.println("SUCCESS");
		}
		else {
			System.out.println("FAIL");
		}
	}
	public static boolean isSolvable(int x, List<Integer> board, List<Integer> visitedIndices) {
	    int lastx = board.size() - 1;
	    if (x == lastx) {
	        // Last index. solved
	        return true;
	    }

	    if (x > lastx || x < 0 || visitedIndices.contains(x)) {
	        // Outside list or previously vistied, failed to solve
	        return false;
	    }

	    visitedIndices.add(x);
	    int nextxF = x + board.get(x);
	    int nextxB = x - board.get(x);

	    return isSolvable(nextxF, board, visitedIndices)
	           || isSolvable(nextxB, board, visitedIndices);
	}
}

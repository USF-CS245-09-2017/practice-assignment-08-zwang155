import java.util.ArrayList;
import java.util.Stack;

public class GraphAdjMatrix implements Graph {
	private int[][] matrix;
	private int vertices;

	public GraphAdjMatrix() {
		matrix = new int[0][0];
		vertices = 0;
	}

	public GraphAdjMatrix(int v) {
		matrix = new int[v][v];
		vertices = v;
	}

	public void addEdge(int v1, int v2) {
		matrix[v1][v2] = 1;

	}

	public void topologicalSort() {
		if (vertices == 0) {
			System.out.println("No vertex in the graph!");
			return;
		}
		Stack<Integer> s = new Stack<Integer>();
		int[] indegree = new int[vertices];
		int count = 0;
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (matrix[j][i] > 0) {
					if (i == j) {
						System.out.println("There is a circle.");
						return;
					}
					indegree[i] += 1;
				}
			}
			if (indegree[i] == 0)
				s.push(i);
		}
		while (!s.isEmpty()) {
			int v = s.pop(); // the next vertex
			System.out.print(v + " ");
			count += 1;
			for (int i = 0; i < vertices; i++) {
				if (matrix[v][i] > 0 && --indegree[i] == 0)
					s.push(i);
			}
		}
		System.out.println();
		if (count != vertices)
			System.out.println("There is a circle.");
	}

	public int[] neighbors(int vertex) {
		// return null if there is no such vertex
		if (vertex >= vertices)
			return null;
		ArrayList<Integer> n = new ArrayList<Integer>();
		for (int i = 0; i < vertices; i++) {
			if (i != vertex && matrix[vertex][i] != 0) {
				n.add(i);
			}
		}
		int[] neighbor = new int[n.size()];
		for (int i = 0; i < n.size(); i++) {
			neighbor[i] = n.get(i);
		}
		return neighbor;
	}

}

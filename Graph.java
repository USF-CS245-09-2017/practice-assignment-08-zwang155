
public interface Graph {
	
	// Eventually, our graphs will include more functions than this
	// ... but let's start here.
	public void addEdge(int v1, int v2);
	public void topologicalSort();
	public int[] neighbors(int vertex);

}

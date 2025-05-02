package algstudent.s7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NullPathNode extends Node {

	 private int[][] matrix;
	    private int n;
	    private int currentNode;
	    private int targetCost;
	    private int tolerance;
	    private int pathCost;
	    private boolean[] visited;
	    private List<Integer> path;

	    public NullPathNode(int startNode, int n, int[][] matrix, int targetCost, int tolerance) {
	        super();
	        this.n = n;
	        this.matrix = matrix;
	        this.targetCost = targetCost;
	        this.tolerance = tolerance;
	        this.currentNode = startNode;
	        this.pathCost = 0;
	        this.visited = new boolean[n];
	        this.visited[startNode] = true;
	        this.path = new ArrayList<>();
	        this.path.add(startNode);
	        calculateHeuristicValue();
	    }

	    private NullPathNode(NullPathNode parent, int nextNode) {
	        super();
	        this.n = parent.n;
	        this.matrix = parent.matrix;
	        this.targetCost = parent.targetCost;
	        this.tolerance = parent.tolerance;
	        this.pathCost = parent.pathCost + matrix[parent.currentNode][nextNode];
	        this.currentNode = nextNode;
	        this.visited = Arrays.copyOf(parent.visited, n);
	        this.visited[nextNode] = true;
	        this.path = new ArrayList<>(parent.path);
	        this.path.add(nextNode);
	        this.depth = parent.depth + 1;
	        this.parentID = parent.getID();
	        calculateHeuristicValue();
	    }

	    @Override
	    public void calculateHeuristicValue() {
	        int unvisitedCount = 0;
	        for (boolean v : visited) {
	            if (!v) unvisitedCount++;
	        }
	        this.heuristicValue = Math.abs(targetCost - pathCost) + unvisitedCount * 10;
	    }

	    @Override
	    public ArrayList<Node> expand() {
	        ArrayList<Node> children = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            if (!visited[i] && matrix[currentNode][i] != Integer.MAX_VALUE) {
	                children.add(new NullPathNode(this, i));
	            }
	        }
	        return children;
	    }

	    @Override
	    public boolean isSolution() {
	        return path.size() == n && currentNode == n - 1 && Math.abs(pathCost - targetCost) <= tolerance;
	    }

	    @Override
	    public String toString() {
	        return "Path: " + path.toString() + ", Cost: " + pathCost+" ";
	    }

	    @Override
	    public int initialValuePruneLimit() {
	        return targetCost + tolerance;
	    }
}

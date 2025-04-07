package algstudent.s6;

import java.util.ArrayList;
import java.util.List;

public class NullPath {
	
	public static final int MIN_WEIGHT=10;
	public static final int MAX_WEIGHT=99; 
	public static final int OBJECTIVE_COST=0;
//	public static final int MAX_COST=99;
//	public static final int MIN_COST=-99;
	
	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int numEdges;
	static boolean solutionFound;
	static int n;
	
	
	public NullPath(int n) {
//n=Integer.parseInt(args[0]);
		
		v=new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;
		weights=new int[n][n];
		
		fillInWeights(weights);
//		printMatrix(weights);

		List<Integer> path = new ArrayList<>();
		boolean[] visited= new boolean[n];
		
		
		path.add(0);
		visited[0]=true;
		int sum=0;
		solutionFound=false;
		findSolution(visited, sum, 0, path);
		
//		if(!solutionFound)
//			System.out.println("THERE IS NO SOLUTION FOR THIS WEIGHTS MATRIX.");
	}
	
	
	
	public static void main(String args[]) {
		
		
	}
	
	
	
	
	static void findSolution(boolean[] visitedState, int sum, int currentNode, List<Integer> path) {
		if(solutionFound)
			return;
		if(path.size()==n-1) {// END
			if(!visitedState[n-1]) {
				int finalCost = sum + weights[currentNode][n-1];
				if(Math.abs(finalCost)<=MAX_WEIGHT) {
					path.add(n-1);
					visitedState[n-1]=true;
//					printVisited(visitedState);
//					System.out.println("NullPath found: " + path);
//	                System.out.println("Total cost: " + finalCost);
	                solutionFound=true;
				}
			}
			
			return;
		}
		
		for(int i=0;i<n-1;i++) {
			if(!visitedState[i]) {
				visitedState[i]=true;
				path.add(i);
				findSolution(visitedState, sum+weights[currentNode][i], i,	path);//BACKTRACKING
				path.remove(path.size()-1);
				visitedState[i]=false;
			}
		}
	}

	private static boolean allVisited(boolean[] visited) {
		for(int i=0;i<visited.length;i++)
			if(!visited[i])
				return false;
		return true;
	}
	

	static void fillInWeights(int[][] w) {
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length; j++) {
				int edge = (int) (Math.random() * 2);
				if(edge==1) {//there is an edge
					numEdges++;
					int neg = (int) (Math.random() * 2);
					w[i][j]=(int) (Math.random() * (MAX_WEIGHT-9)) + MIN_WEIGHT;
					if(neg==1)
						w[i][j]=-w[i][j];
				}
					
				else
					w[i][j] = 10000000;
			}
				
		}
	}
	
	static void printVisited(boolean[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if(a[i])
				System.out.print(v[i]+": VISITED\t");
			else
				System.out.print(v[i]+": NOT VISITED\t");
		}
		System.out.println();
	}
	
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}

}

package algstudent.s5;

import java.util.Random;

public class MinimumPathsTimes {
	
	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths

	public static void main(String arg[]) {
		System.out.println("TIME MEASUREMENTS:");
		long t1,t2;
		for(int n=200;n<100000000;n*=2) {
			t1=System.currentTimeMillis();
			v = new String[n];
			for (int i = 0; i < n; i++)
				v[i] = "NODE" + i;

			weights = new int[n][n];
			costs = new int[n][n];
			p = new int[n][n];

			fillInWeights(weights); //weights for the example
//			System.out.println("WEIGHT MATRIX IS:");
//			printMatrix(weights);

			floyd(weights, costs, p);

//			System.out.println("MINIMUM COST MATRIX IS:");
//			printMatrix(costs);

//			System.out.println("P MATRIX IS:");
//			printMatrix(p);

//			System.out.println();
//			System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
//			System.out.println();
			for (int source = 0; source <= n-1; source++)
				for (int target = 0; target <= n-1; target++)
					if (source != target) {
//						System.out.print("FROM " + v[source] + " TO " + v[target] + " = ");
						minimumPath(v, weights, costs, p, source, target);
//						if (costs[source][target] < 10000000)
//							System.out.println("MINIMUM COST=" + costs[source][target]);
//						System.out.println("**************");
					}
			
			t2=System.currentTimeMillis();
			System.out.println("n="+n+"\tTime: "+(t2-t1)+" miliseconds");
		} //end loop
	}
	
	static void fillInWeights(int[][] w) {
		Random r = new Random();
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length; j++) {
				int edge = (int) (Math.random() * 2);
				if(edge==1)  //there is an edge
					w[i][j]=(int) (Math.random() * 90) + 10;
				else
					w[i][j] = 10000000;
			}
				
		}
	}
	
private static void initsFloyd(int[][] weights, int[][] costs, int[][] p) {
		
		for(int i=0; i<weights.length;i++) {
			for(int j=0; j<weights.length;j++) {

				p[i][j] = -1;
				
				if(i!=j && weights[i][j]==0) {
					costs[i][j] = 10000000;
				}
				else {
					costs[i][j] = weights[i][j];
				}
			}
		}
		
	}

	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
//		System.out.println("COMPLETE THIS METHOD");
		initsFloyd(weights, costs, p);
		
		for(int pivot=0; pivot<n; pivot++) {
			for(int source=0; source<n; source++) {
				for(int dest=0; dest<n; dest++) {
					if(source!=dest) {
						//Get new value passing from pivot
						int newValue = costs[source][pivot] + costs[pivot][dest];
						//Compare to value stored in the A matrix
						if(newValue < costs[source][dest]) {
							costs[source][dest]=newValue;
							p[source][dest]=pivot;
						}
					}
				}
			}
		}
	}

	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
//		if(costs[source][target]>=10000000)
//			System.out.println("THERE IS NO PATH");
//		System.out.print(v[source]+"-->");
		path(v,steps,source,steps[source][target]);
//		System.out.println(v[target]);
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if(j==-1)
			return;
		path(v,steps,i,steps[i][j]);
//		System.out.print(v[j]+"-->");
	}
	
	
	
}

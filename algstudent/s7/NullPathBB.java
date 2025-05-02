package algstudent.s7;

import java.util.ArrayList;
import java.util.List;

public class NullPathBB {
	
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
	
	
	
	public NullPathBB(int n) {
		weights = new int[n][n];
        fillInWeights(weights);
//        printMatrix(weights);
        int target = 0;
        int tolerance = 99;

        NullPathNode root = new NullPathNode(0, n, weights, target, tolerance);
        BranchAndBound bb = new BranchAndBound();
        bb.branchAndBound(root);
//      bb.printSolutionTrace();
	}
	
	
	
	
//	public static void main(String args[]) {
//		
//		int n = Integer.parseInt(args[0]);
//		weights = new int[n][n];
//        fillInWeights(weights);
//        printMatrix(weights);
//        int target = 0;
//        int tolerance = 99;
//
//        NullPathNode root = new NullPathNode(0, n, weights, target, tolerance);
//        BranchAndBound bb = new BranchAndBound();
//        bb.branchAndBound(root);
//        bb.printSolutionTrace();
//		
//	}
	
	
	
	
	
	

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

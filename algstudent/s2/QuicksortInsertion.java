package algstudent.s2;

import java.util.Arrays;

/* This program is used to sort n elements with a quadratic algorithm
except if the vector is initially ordered or nearly ordered,
which is of linear complexity (INSERTION) */
public class QuicksortInsertion {
	static int[] v;

	/* Sorting by the Insertion method */
	public static void quicksortInsertion(int[] a, int left, int right, int k) {
		if(right<=left)
			return;
		
		 if((right-left)<=k)
			 Insertion.insertion(a, left, right);
		 else
			 Quicksort.quicksortK(a, left, right,k);
	}
	
	public static void quicksortInsertion(int[] a, int k) {
		
		
		 if(a.length<=k)
			 Insertion.insertion(a);
		 else
			 Quicksort.quicksortK(a,k);
	}

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v,5,15,5);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v,5,15,10);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v,5,15,20);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 

}

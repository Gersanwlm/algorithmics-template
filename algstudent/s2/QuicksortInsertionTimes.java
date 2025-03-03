package algstudent.s2;

/* This class measures times for the Bubble method
for the 3 assumptions: (already ordered, reverse ordered and random ordered) */
public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		int n=16000000;
		
		int[] kVals = {5, 10, 20, 30, 50, 100, 200, 500, 1000};

		for (int k:kVals) {
			v = new int[n];
			
			Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			QuicksortInsertion.quicksortInsertion(v, k);

			t2 = System.currentTimeMillis();

			System.out.println(k + "\t" + (t2 - t1));
		}
	}
}

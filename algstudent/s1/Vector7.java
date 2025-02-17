package algstudent.s11;

public class Vector7 {
	
	static int[]v;
	static int[] u;
		
		public static void main(String arg []) {
			int repetitions = Integer.parseInt(arg[0]);
			long t1,t2;
			int matches = 0;
			
			for (int n=10000; n<=81920000; n*=2){ //n is increased *5   
				  v = new int[n];
				  u=new int[n];
				  Vector1.fillIn(v);
				  Vector1.fillIn(u);
				  
				  t1 = System.currentTimeMillis();
				  //We have to repeat the whole process to be measured
				  for (int repetition=1; repetition<=repetitions; repetition++){    	
				     matches = Vector1.matches2(v, u);
				  }
				  t2 = System.currentTimeMillis();
				  System.out.printf("SIZE=%d TIME=%d milliseconds MATCHES=%d NTIMES=%d\n", n, t2-t1, matches, repetitions);	
			}//for 
			
		}//main

}

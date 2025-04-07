package algstudent.s6;

public class NullPathTimes {

	public static void main(String arg[]) {
		long t1, t2;
		
		for (int n=20;n<100000000;n+=5) {
			NullPath np;
			long t_accumulated=0;
			for(int m=0;m<100;m++) {
				t1=System.currentTimeMillis();
				np=new NullPath(n);
				t2=System.currentTimeMillis();
				t_accumulated+=(t2-t1);
//				System.out.println("Null path "+n+"."+m);
			}
			System.out.println("AVERAGE TIME FOR N="+n+": "+t_accumulated/100.0+" ms");
		}
	}
	
}

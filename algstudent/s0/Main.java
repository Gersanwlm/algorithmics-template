package session0;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int n = 10000;
		for(int i=0; i<7;i++) {
			long startTime = System.currentTimeMillis();
			List<Integer> primes = new JavaA1v1().listadoPrimos(n);
			long endTime = System.currentTimeMillis();
			System.out.println("n = "+n+" *** "+"time = "+(endTime-startTime)+" milliseconds");
			n=n*2;
		}
		
		
		

	}

}

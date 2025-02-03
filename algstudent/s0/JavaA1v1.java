package session0;

import java.util.ArrayList;
import java.util.List;

public class JavaA1v1 {
	
	public List<Integer> listadoPrimos(int n){
		List<Integer> primes = new ArrayList<>();
		for(int i=2;i<n+1;i++) {
			if(new JavaA1v0().primmoA1(i)) 
				primes.add(i);
		}
		return primes;
	}

}

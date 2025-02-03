package session0;

public class JavaA1v0 {

	public boolean primmoA1(int m) {
		boolean prime = true;
		for (int i=2;i<m;i++) {
			if(m%i == 0)
				prime = false;
		}
		return prime;
	}

}

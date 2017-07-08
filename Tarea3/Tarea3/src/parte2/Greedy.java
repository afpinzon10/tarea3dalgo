package parte2;


public class Greedy implements CoinChangeCalculator {

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int[] m = new int[denominations.length];
		int p = totalValue;
		
		for (int i = denominations.length-1 ; i >= 0 && p>0; i--) {
			
			/*if(denominations[i]<=p)
			{*/
				
				m[i]= p/denominations[i];
				p = p - (denominations[i]*m[i]);
			/*}
			/*
			int d = denominations[i];
			int r = p % d;
			int pa = totalValue - r;
			int a = pa/d;
			m[i] = a;
			p = p - (d*a);*/
		}
		
		return m;
	}

}

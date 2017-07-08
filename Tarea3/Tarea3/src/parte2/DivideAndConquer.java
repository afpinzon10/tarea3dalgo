package parte2;

import java.util.stream.IntStream;

public class DivideAndConquer implements CoinChangeCalculator {

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int l = denominations.length;
		int[] m = new int[l];
		for (int i = 0; i<m.length; i++) {
			m[i]=0;
		}
		int[] subDenominations = new int[l-1];
		for (int i = 0; i < subDenominations.length; i++) {
			subDenominations[i] = denominations[i];
		}
		if(totalValue == 0)
		{
			return m;
		}
		else if(l == 1){
			m[0]=totalValue;
			return m;
		}
		else if(denominations[l -1]>totalValue)
		{
			int[] t = calculateOptimalChange(totalValue, subDenominations);
			for (int i = 0; i < t.length; i++) {
				m[i] = m[i] +t[i];
			}
			return m;
		}
		else
		{
			int[] greedy = calculateOptimalChange(totalValue - (denominations[l-1]), denominations);
			int[] notGreedy = calculateOptimalChange(totalValue, subDenominations);
			int[] semiGreedy = calculateOptimalChange(totalValue - (denominations[l-1]), subDenominations);
			int min = min(1 + IntStream.of(greedy).sum(), IntStream.of(notGreedy).sum(), 1 + IntStream.of(semiGreedy).sum());
			if(min==1){
				m[l-1]++;
				for (int i = 0; i < greedy.length; i++) {
					m[i] = m[i] + greedy[i];
				}
				return m;
			}else if(min==3){
				m[l-1]++;
				for (int i = 0; i < semiGreedy.length; i++) {
					m[i] = m[i] + semiGreedy[i];
				}
				return m;
			}else{
				for (int i = 0; i < notGreedy.length; i++) {
					m[i] = m[i] + notGreedy[i];
				}
				return m;
			}
		}
	}
	
	public int min(int a, int b, int c){
		int m = Math.min(Math.min(a, b),c);
		if(m==a){
			return 1;
		}else if (m==b) {
			return 2;
		}else{
			return 3;
		}
	}

}

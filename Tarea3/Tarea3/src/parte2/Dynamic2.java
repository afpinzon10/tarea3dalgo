package parte2;

import java.util.stream.IntStream;

public class Dynamic2 implements CoinChangeCalculator{

	Object[][] answers;
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		try{
			int a = answers.length;
		}catch (NullPointerException e) {
			answers = new Object[denominations.length][3];
			for (int i = 0; i < answers.length; i++) {
				for (int j = 0; j < answers[i].length; j++) {
					answers[i][j] = 0;
				}
			}
		}
		for (Object[] objects : answers) {
			for (Object object : objects) {
				if(object.getClass().equals(Integer.class)){
					System.out.print(object);
				}else if(object.getClass().equals(int[].class)){
					System.out.print("[");
					for (int o : (int[]) object) {
						System.out.print(o+",");
					}
					System.out.print("]");
				}
				System.out.print("  |  ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
			answers[l-1][0] = totalValue;
			answers[l-1][1] = denominations;
			answers[l-1][2] = m;
			return m;
		}
		else if(denominations[l -1]>totalValue)
		{
			int[] t = calculateOptimalChange(totalValue, subDenominations);
			for (int i = 0; i < t.length; i++) {
				m[i] = t[i];
			}
			answers[l-1][0] = totalValue;
			answers[l-1][1] = denominations;
			answers[l-1][2] = m;
			return m;
		}
		else if((totalValue%denominations[l-1])==0)
		{
			m[l-1] = totalValue/denominations[l-1];
			answers[l-1][0] = totalValue;
			answers[l-1][1] = denominations;
			answers[l-1][2] = m;
			return m;
		}
		
		else
		{
			int k = totalValue/denominations[l-1];
			int[] greedy = calculateOptimalChange(totalValue - (k * denominations[l-1]), subDenominations);
			int[] notGreedy = calculateOptimalChange(totalValue, subDenominations);
			if(k + IntStream.of(greedy).sum()<=IntStream.of(notGreedy).sum()){
				m[l-1] = k;
				for (int i = 0; i < greedy.length; i++) {
					m[i] = greedy[i];
				}
				answers[l-1][0] = totalValue;
				answers[l-1][1] = denominations;
				answers[l-1][2] = m;
				return m;
			}else{
				for (int i = 0; i < notGreedy.length; i++) {
					m[i] = notGreedy[i];
				}
				answers[l-1][0] = totalValue;
				answers[l-1][1] = denominations;
				answers[l-1][2] = m;
				return m;
			}
		}
	}

}

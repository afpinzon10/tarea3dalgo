package parte2;

import java.util.stream.IntStream;

public class Dynamic implements CoinChangeCalculator{

	int[][] dynamicMatrix;
	boolean initialized = false;

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		if(!initialized){
			dynamicMatrix = new int[denominations.length][totalValue+1];
			for (int i = 0; i < totalValue+1; i++) {
				dynamicMatrix[0][i] = i;
				/*System.out.print(i + "  |  ");*/
			}
			/*System.out.println();*/
			for (int i = 1; i < denominations.length; i++) {
				for (int j = 0; j < totalValue+1; j++) {
					if(denominations[i]>j){
						dynamicMatrix[i][j] = dynamicMatrix[i-1][j];
					}else{
						dynamicMatrix[i][j] = Math.min(dynamicMatrix[i-1][j], dynamicMatrix[i][j-denominations[i]]+1);
					}
					
					/*System.out.print(dynamicMatrix[i][j] + "  |  ");*/
				}
				/*System.out.println();*/
			}
			/*System.out.println("END");*/
		}
		int[] m = new int[denominations.length];
		int i = denominations.length-1;
		int j = totalValue;
		while (j!=0) {
			if(i==0||dynamicMatrix[i][j]!=dynamicMatrix[i-1][j]){
				m[i]++;
				j = j-denominations[i];
			}else{
				i--;
			}
			
		}
		return m;
	}

}

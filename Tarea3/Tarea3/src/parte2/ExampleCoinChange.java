package parte2;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class ExampleCoinChange {

		/**
		 * Main method for the coin change example. It requires three parameters:
		 * args[0]: Fully qualified class name of the algorithm to run
		 * args[1]: Total value to break in coins
		 * args[2]: Comma-separated list of denominations
		 * @param args Array with the arguments described above 
		 * @throws Exception If the algorithm class can not be loaded
		 * @throws Exception If the list of denominations does not include the denomination 1 
		 */
		public static void main(String[] args) throws Exception {
			
			//Load algorithm class
			String algorithmClassName = args[0];
			CoinChangeCalculator calculator = (CoinChangeCalculator)Class.forName(algorithmClassName).newInstance();
			//Load input data
			int totalValue = Integer.parseInt(args[1]);
			String [] strDenominations = args[2].split(",");
			List<Integer> denominationsList = new ArrayList<>();
			for(int i=0;i<strDenominations.length;i++) denominationsList.add(Integer.parseInt(strDenominations[i]));
			Collections.sort(denominationsList);
			if(denominationsList.get(0)!=1) throw new Exception("The smallest denomination should be 1");
			int [] denominations = new int [denominationsList.size()];
			for(int i=0;i<denominations.length;i++) denominations[i] = denominationsList.get(i);
			
			//Run the coin change algorithm
			long startTime = System.currentTimeMillis();
			int [] numCoins = calculator.calculateOptimalChange(totalValue, denominations);
			long endTime = System.currentTimeMillis();
			
			//Output results
			int calculatedTotal = 0;
			int totalCoins=0;
			System.out.println("Coin\tNumber");
			for(int i=0;i<numCoins.length;i++) {
				System.out.println(""+denominations[i]+"\t"+numCoins[i]);
				calculatedTotal += denominations[i]*numCoins[i];
				totalCoins+=numCoins[i];
			}
			System.out.println("Total coins:\t"+totalCoins);
			System.out.println("Total value:\t"+calculatedTotal);
			System.out.println("Total time spent (milliseconds): "+(endTime-startTime));
			if(calculatedTotal!=totalValue) throw new RuntimeException("ERROR: The total of the solution: "+calculatedTotal+" does not coincide with the expected total: "+totalValue);
		}
	}


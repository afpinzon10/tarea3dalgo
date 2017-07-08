package parte1;

public class BubbleSort implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		
		for (int i = numbers.length-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if(numbers[j]>numbers[j+1]){
					double t = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = t;
				}
			}
		}
	}
}

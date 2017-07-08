package parte1;

public class MergeSort implements NumbersArraySorter{

	
	public void merge(int first, int mid, int last, double[] numbers){
		double[] mergedList = new double[last-first+1];
		int indexM = 0;
		int index1 = first;
		int index2 = mid+1;
		while (index1<mid+1 && index2<last+1) {
			double n1 = numbers[index1];
			double n2 = numbers[index2];
			if(n1<=n2){
				mergedList[indexM] = n1;
				index1++;
				indexM++;
			}
			if (n1>=n2) {
				mergedList[indexM] = n2;
				index2++;
				indexM++;
			}
		}
		while (index1<mid+1) {
			mergedList[indexM] = numbers[index1];
			index1++;
			indexM++;
		}
		while (index2<last+1) {
			mergedList[indexM] = numbers[index2];
			index2++;
			indexM++;
		}
		int i = 0;
		int j = first;
		while (i<mergedList.length) {
			numbers[j] = mergedList[i];
			i++;
			j++;
		}
	}
	public void mergeSort(int first, int last, double[] numbers){
		int mid = (first+last)/2;
		if(first<last-1){
			mergeSort(first, mid, numbers);
			mergeSort(mid+1, last, numbers);
		}
		merge(first, mid, last, numbers);
	}
	
	@Override
	public void sort(double[] numbers) {
		mergeSort(0, numbers.length-1, numbers);		
	}

}

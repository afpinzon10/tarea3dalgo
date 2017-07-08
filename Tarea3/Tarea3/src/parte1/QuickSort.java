package parte1;


import java.util.Random;

public class QuickSort implements NumbersArraySorter {

	public void swap(int a, int b, double[] numbers){
		double t = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = t;
	}

	public void quickSort(int first, int last, double[] numbers){
		//double r = Math.random();
		Random r = new Random();
		//int iPivot = r.nextInt(last-first)+first;
		//int iPivot = (int) (r * last) + first;
		int iPivot = last;
		//System.out.println(r + " "+iPivot+ " " + last + " " +  first);
		double pivot = numbers[iPivot];
		int firstBig = -1;
		for (int i = first; i <= last; i++) {
			if(iPivot!=i){
				if(numbers[i]<pivot){
					if(firstBig>-1){
						swap(firstBig, i, numbers);
						firstBig++;
					}
				}else if(firstBig==-1){
					firstBig = i;
				}
			}

		}
		if (firstBig>-1) {
			if(iPivot>firstBig){
				swap(iPivot, firstBig, numbers);
				iPivot = firstBig;
			}else if(iPivot<firstBig-1){
				swap(iPivot, firstBig-1, numbers);
				iPivot = firstBig-1;
			}
		}else{
			swap(iPivot, last, numbers);
			iPivot = last;
		}

		if(iPivot-1>first){
			quickSort(first, iPivot-1, numbers);
		}
		if(iPivot+1<last){
			quickSort(iPivot+1, last, numbers);
		}
		


	}
	@Override
	public void sort(double[] numbers) {
		quickSort(0, numbers.length-1, numbers);

	}

}

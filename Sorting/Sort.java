public class Sort {
	
	/*
	 * Selection sort
	 */
	public static int[] selectionSort(int[] input) {
		//In-place sorting
		//Selection sort, pick up the minimum and put it in front
		int n = input.length;
		int min;
		int minIdx;
		//Check from i = 0 to n-1 (no swapping for last one element)
		for (int i = 0; i < n-1 ; i++) {
			//Find the min in [i, n-1]
			min = input[i];
			minIdx = i;
			for (int j = i + 1; j < n ; j ++) {
				if (input[j] < min) {
					min = input[j];
					minIdx = j;
				}
			}
			//Move to front
			input[minIdx] = input[i];	//Swap initial one to back
			input[i] = min;
		}
		
		return input;
	}
	
	/*
	 * Merge sort
	 */
	public static int[] mergeSort(int[] input) {
		//null input or empty array
		if (input == null || input.length == 0) return input;

		int start = 0;
		int end = input.length - 1;
		return mergeSortAux(input, start, end);
	}
	
	//Auxillary function with more inputs (position indices)
	private static int[] mergeSortAux(int[] input, int start, int end) {
		//Base case for the recursion, one element left
		if (start == end) {
			//Not in-place sorting, create a new one-element array for returning
			int[] output = {input[start]};
			return output;
		}
		
		int mid = (start + end) / 2;
		//Recursive function call
		int[] firstHf = mergeSortAux(input, start, mid);
		int[] secondHf = mergeSortAux(input, mid + 1, end);
		
		//Combine two array together
		int len = firstHf.length + secondHf.length;
		//Create an array
		int[] output = new int[len];
		//Two pointers starting from index=0
		int i = 0;
		int j = 0;
		//Loop to store ordered elements into result
		for (int k = 0; k < len; k++) {
			if (i == firstHf.length) {
				output[k] = secondHf[j];
				j++;
				continue;
			}
			if (j == secondHf.length) {
				output[k] = firstHf[i];
				i++;
				continue;
			}
			if (firstHf[i] < secondHf[j]) {
				output[k] = firstHf[i];
				i++;
			} else {
				output[k] = secondHf[j];
				j++; 
			}
		}
		return output;
	}
	
	/*
	 * Quick sort
	 */
	public static int[] quickSort(int[] input) {
		//Special cases
		if (input == null || input.length == 0) {
			return input;
		}
		int start = 0;
		int end = input.length - 1;
		
		quickSortAux(input, start, end);
		return input;
	}
	
	//Auxillary function with more inputs
	//In-place sorting, no return value
	private static void quickSortAux(int[] input, int start, int end) {
		//Base case for the recursion, if there is no or one element, do nothing
		if (start >= end) {
			return;
		}
		
		//Pick up the last element as pivot
		int pivot = input[end];
		//Two pointers starting from very begining or second last
		int i = start;
		int j = end - 1;
		//Variable for storing value in swapping
		int temp;
		
		while (j >= i) {
			//Find the value bigger than pivot
			if (input[i] <= pivot) {
				i++;
				continue;
			}
			//Find the value smaller than pivot
			if (input[j] >= pivot) {
				j--;
				continue;
			}
			//Swapping the two values
			temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
		
		//when j=i-1, now input[j] <= pivot and input[i] >= pivot
		//Swapping input[i] and pivot
		input[end] = input[i];
		input[i] = pivot;
		
		//Recursive call
		quickSortAux(input, start, i-1);
		quickSortAux(input, i+1, end);
		
	}
	
	//Testing in-place change of element
	public static void changeElement(int[] in) {
		in[0] = 100;
	}
	
	public static void main(String[] args) {
		int[] aa = {};
		int[] a = {4,3,2,6,2,1};
		int[] b = Sort.selectionSort(a);
		int[] c = Sort.mergeSort(a);
		int[] d = Sort.quickSort(a);
		
		for (int i = 0; i < a.length; i++) {
//			System.out.print(b[i] + " ");
//			System.out.print(c[i] + " ");
			System.out.print(d[i] + " ");
		}
		
//		changeElement(a);
//		System.out.print(a[0] + " ");
		
	}
}

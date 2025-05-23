import java.util.Arrays;
public class Main{
	
	public static void swap(int arr[],int i, int j) {
		int temp = arr[i];
		arr[i] =arr[j];
		arr[j] = temp;
	}
	public static int partition(int arr[], int low, int high) {
		int mid = (low+high)/2;
		int pivot = arr[mid];
		int i = low;
		int j = high;
		
		return i-1;
	}
	
	public static int partitionFirstPivot(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low+1;
		
		for(int j=low+1; j<=high; j++) {
			if(arr[j] < high) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr,low, i-1);
		return i-1;
	}
	
	public static void quicksort(int[] arr, int low, int high) {
		if (low<high)
		{
			int pi = partitionFirstPivot(arr, low, high);
			quicksort(arr, 0, pi-1);
			quicksort(arr, pi+1, high);
		}
	}
	
	public static void main(String[] args) {
	    int[] arr = {9, 4, 8, 3, 1, 2};
	    quicksort(arr, 0, arr.length - 1);
	    System.out.println(Arrays.toString(arr));
	}

	
}
	
	
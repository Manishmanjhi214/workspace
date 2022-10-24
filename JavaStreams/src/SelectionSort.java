
public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = {22,5,8,6,74,23,54};
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			int min =i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min]){
					min=j;
					}
			}
			if(min!=i) {
				int temp =arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
		for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
		}
	}
}

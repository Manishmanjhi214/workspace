package APITestingDemo.APITestingDemo;

public class AlternateThreeNumbersSwap {
	public void alternateThreeNumbersSwap(int[] num, int k) {
		int len = num.length;
		
		for (int i = 0; i < len; i=i+k-1) {
			int j = i + k;
			if (j <= len) {
				num[i] = num[j] + num[i];
				num[j] = num[i] - num[j];
				num[i] = num[i] - num[j];
				i = j;
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(num[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
				int[] num = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < num.length; i++) {
					System.out.print(num[i] + " ");
				}
				System.out.print("-------------------------------");
				AlternateThreeNumbersSwap atns = new AlternateThreeNumbersSwap();
				atns.alternateThreeNumbersSwap(num,2);
	}

}

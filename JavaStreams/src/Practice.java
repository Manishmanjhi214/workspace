import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

public class Practice {
	public static void main(String[] args) {
		int ar1[]= {7,92,99,14,64,95};
		int ar2[]= {11,52,19,95,92,62};
		//sort array 1;
//		for(int i=0;i<ar1.length;i++) {
//			for(int j=i+1;j<ar1.length;j++) {
//				if(ar1[i]>ar1[j]) {
//					int temp = ar1[i];
//					ar1[i]= ar1[j];
//					ar1[j]=temp;
//				}
//			}
//		}
//		//sort array 2;
//				for(int i=0;i<ar2.length;i++) {
//					for(int j=i+1;j<ar2.length;j++) {
//						if(ar2[i]>ar2[j]) {
//							int temp = ar2[i];
//							ar2[i]= ar2[j];
//							ar2[j]=temp;
//						}
//					}
//				}
		int ar3[]= new int[100];
		
		for(int i=0;i<ar3.length;i++) {
			if(i<=ar1.length) {
				ar3[i]= ar1[i];
			}
			if(i>ar1.length) {
				for(int j=0;j<ar2.length;j++) {
					ar3[i]= ar2[j];
					j=j+1;
				}
			}
			System.out.println(ar3[i]);
		}
		
		System.out.println("2nd lowest number is"+ ar3[ar3.length-1]);
	}
}

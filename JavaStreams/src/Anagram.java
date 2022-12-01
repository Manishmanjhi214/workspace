import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Strings");
		String str1= sc.nextLine();
		String str2= sc.nextLine();
		Anagram a= new Anagram();
		System.out.println(a.areAnagram(str1, str2));
		sc.close();
	}
	
	public boolean areAnagram(String str1, String str2) {
		char ar1[]= str1.toCharArray();
		char ar2[]= str2.toCharArray();
		
		if(ar1.length != ar2.length) {
			return false;
		}
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		
		for(int i=0;i<ar1.length;i++) 
				if(ar1[i]!=ar2[i]) 
					return false;
		
		return true;
	}

}

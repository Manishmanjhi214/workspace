package ManishTestPractice2.TDDProj;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumberInArrayUsingHashMap {
	
	private static void findDuplicatesUsingJava8(int[] inputArray) 
    {   
        Set<Integer> uniqueElements = new HashSet<>();
         
        Set<Integer> duplicateElements =  Arrays.stream(inputArray).filter(i -> ! uniqueElements.add(i)).boxed().collect(Collectors.toSet());
        System.out.println(duplicateElements);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,2,4,6,8,1,2,6,9};
		findDuplicatesUsingJava8(arr);
	}

}
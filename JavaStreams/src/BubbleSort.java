import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BubbleSort {
	public static void main(String[] args) {
		Integer arr[] = {8,22,5,5,8,6,74,23,54};
		Integer arr2[] = {5,1,2,9,63,75,91,12};
		List<Integer> se =Stream.of(arr, arr2).flatMap(Stream::of).collect(Collectors.toList());
		System.out.println(se.stream().distinct().sorted().collect(Collectors.toList()));
	}
}

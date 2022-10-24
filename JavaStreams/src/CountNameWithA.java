import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class CountNameWithA {
	@Test
	public void streamMatch() {
		Boolean f=Stream.of("Rahul","Manish","Guddi","Rohit","Reena","Anima").anyMatch(s->s.equalsIgnoreCase("Manish"));
		System.out.println(f);
	}
	@Test
	public void streamCollect() {
		List<String> st=Stream.of("Rahul","Manish","Guddi","Rohit","Reena","Anima").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).sorted().collect(Collectors.toList());
		System.out.println(st.get(0));
	}
	@Test
	public void uniqueNumber() {
		List<Integer> val= Arrays.asList(3,2,2,7,5,1,9,7);
		val.stream().distinct().sorted().forEach(s->System.out.println(s));
		
	}
	
}


public class VowelSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="I am a boy";
		if(vowelPresent(str1)) {
			System.out.println("String contains vowel");
		}
		
	}
	public static boolean vowelPresent(String str) {
		if(str.contains("a")||str.contains("e")||str.contains("i")||str.contains("o")||str.contains("u")) {
			return true;
		}
		else {
			return false;
		}
	}

}

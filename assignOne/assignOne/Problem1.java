package assignOne;

public class Problem1{

	public static void main(String[] args) {
		int value;
		value = stringToInt("-12345");
		System.out.println(value);

		}
		public static int stringToInt(String str) {
		int number = 0;
		char zero = '0';
		int index = 0;
		int initial;
		char sign = ' ';
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
		sign = str.charAt(0);
		index++;
		}else {
		number = str.charAt(index) - zero ;
		index++;
		}
		for( initial = 0; initial < str.length() - 1 ; initial++) {
		number = 10 * number;
		number += str.charAt(index ) - zero;
		index++;
		}
		if(sign == '-') {
		number = number * -1;
		}
		return number;
		}

}

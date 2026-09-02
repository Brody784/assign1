package assignOne;

public class Problem2 {

	public static void main(String[] args) {

		int value = 123456;

		String result = intToString(value);

		System.out.println(result);
		}

		public static String intToString(int value) {

		int num = 0;
		int length = 0;
		String result = "";
		int percent = 10;
		int digit;
		int index;

		while (num != value) {
		length += 1;
		percent *= 10;
		num = value % percent;
		}

		percent = percent / 10;

		for ( index = 0; index <= length; index++) {

		digit = value / percent;
		value = value % percent;

		result += digit;

		percent = percent / 10;
		}

		return result;
		}

}

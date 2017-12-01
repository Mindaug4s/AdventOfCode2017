package utils;

public class Utils {
	
	public static int[] getArrayFilledWithNumbers(String puzzleInput) {
		int[] numbers = new int[puzzleInput.length()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(puzzleInput.charAt(i)));

		}

		return numbers;
	}

}

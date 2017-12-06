package day.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import day.Solver;
import utils.Utils;

public class Day6_Solver implements Solver {

	private String[][] blockNumbers;
	List<String> variationList = new ArrayList<>();

	public Day6_Solver(String fileName) {
		blockNumbers = (String[][]) Utils.fillArrayWithDataFromFile(fileName, "\\t");
	}

	@Override
	public void solveFirstPuzzle() {
		int[] numbers = string1DArrayToIntArray(blockNumbers[0]);
		variationList.add(int1DArraytoString(numbers));
		int biggestValue;
		int position;

		main:
		while (true) {

			biggestValue = Arrays.stream(numbers).max().getAsInt();
			position = indexOfBiggestValueInArray(numbers, biggestValue);

			while (biggestValue > 0) {
				if (position == numbers.length - 1) {
					position = 0;
				}
				numbers[position]++;
				biggestValue--;
				position++;

			}

			if (variationList.contains(int1DArraytoString(numbers))) {
				System.out.println(variationList.size());
				break main;

			} else {
				variationList.add(int1DArraytoString(numbers));
			}

		}
	}

	@Override
	public void solveSecondPuzzle() {
		// TODO Auto-generated method stub

	}

	private int[] string1DArrayToIntArray(String[] stringArray) {

		return Stream.of(stringArray).mapToInt(Integer::parseInt).toArray();
	}

	private String int1DArraytoString(int[] intArray) {

		StringBuilder concatedInt = new StringBuilder();
		for (int i = 0; i < intArray.length; i++) {
			concatedInt.append(intArray[i]);
		}
		return concatedInt.toString();
	}

	private int indexOfBiggestValueInArray(int[] intArray, int biggestValue) {

		Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

		return Arrays.asList(integerArray).indexOf(biggestValue);

	}

}

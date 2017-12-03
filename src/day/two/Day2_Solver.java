package day.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import day.Solver;
import utils.Utils;

public class Day2_Solver implements Solver {

	private String[][] numbers;
	private List<Integer> numberList;

	public Day2_Solver(String fileName) {

		numbers = (String[][]) Utils.fillArrayWithDataFromFile(fileName);
	}

	@Override
	public void solveFirstPuzzle() {

		numberList = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			int minValue = Stream.of(numbers[i]).mapToInt(Integer::parseInt).min().getAsInt();
			int maxValue = Stream.of(numbers[i]).mapToInt(Integer::parseInt).max().getAsInt();
			numberList.add(maxValue - minValue);
		}

		System.out.println("Day 2 First puzzle answer is: " + numberList.stream().mapToInt(x -> x.intValue()).sum());

	}

	@Override
	public void solveSecondPuzzle() {

		numberList = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {

			int[] currentArray = Stream.of(numbers[i]).mapToInt(Integer::parseInt).toArray();

			for (int k = 0; k < numbers[i].length; k++) {
				
				for (int m = k + 1; m < numbers[i].length; m++) {

					if ((currentArray[k] < currentArray[m]) && (currentArray[m] % currentArray[k] == 0)) {
						numberList.add(currentArray[m] / currentArray[k]);
					}
					if ((currentArray[k] >= currentArray[m]) && (currentArray[k] % currentArray[m] == 0)) {

						numberList.add(currentArray[k] / currentArray[m]);
					}

				}

			}

		}

		System.out.println("Day 2 Second puzzle answer is: " + numberList.stream().mapToInt(x -> x.intValue()).sum());

	}

}

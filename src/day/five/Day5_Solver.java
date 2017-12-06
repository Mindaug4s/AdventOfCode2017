package day.five;

import day.Solver;
import utils.Utils;

public class Day5_Solver implements Solver {

	private String[][] numberList;

	public Day5_Solver(String fileName) {
		numberList = (String[][]) Utils.fillArrayWithDataFromFile(fileName, " ");
	}

	@Override
	public void solveFirstPuzzle() {
		int[] numbers = Utils.convertStringArrayToInt(numberList);

		int currentPosition = 0;
		int jumpsMade = 0;
		try {
			while (true) {

				int lastPosition = currentPosition;

				currentPosition = currentPosition + numbers[currentPosition];

				numbers[lastPosition]++;
				jumpsMade++;

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Day 5 First puzzle answer is: " + jumpsMade);
		}
	}

	@Override
	public void solveSecondPuzzle() {
		int[] numbers = Utils.convertStringArrayToInt(numberList);

		int currentPosition = 0;
		int jumpsMade = 0;
		try {
			while (true) {

				int lastPosition = currentPosition;
				int lastPositionValue = numbers[lastPosition];

				currentPosition = currentPosition + numbers[currentPosition];

				if (numbers[lastPosition] > 2) {
					numbers[lastPosition] = lastPositionValue - 1;
				} else {
					numbers[lastPosition] = lastPositionValue + 1;
				}

				jumpsMade++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Day 5 Second puzzle answer is: " + jumpsMade);
		}
	}

}

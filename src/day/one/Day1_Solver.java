package day.one;

import java.util.ArrayList;
import java.util.List;

import solver.tester.Solver;
import utils.Utils;

public class Day1_Solver implements Solver {

	private List<Integer> numberList;
	private final int[] numbers;

	public Day1_Solver(String puzzleInput) {

		numbers = Utils.getArrayFilledWithNumbers(puzzleInput);
	}

	public void solveFirstPuzzle() {

		this.numberList = new ArrayList<Integer>();

		for (int i = 0; i < numbers.length; i++) {

			try {

				if (numbers[i] == numbers[i + 1]) {
					numberList.add(numbers[i]);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				if (numbers[0] == numbers[numbers.length - 1]) {
					numberList.add(numbers[i]);
				}

			}
		}

		System.out.println("Day 1 First puzzle answer is: " + numberList.stream().mapToInt(x -> x.intValue()).sum());
	}

	public void solveSecondPuzzle() {

		this.numberList = new ArrayList<Integer>();
		int numberOfSteps = numbers.length / 2;

		for (int i = 0; i < numbers.length; i++) {

			try {
				if (numbers[i] == numbers[i + numberOfSteps]) {
					numberList.add(numbers[i]);
				}

			} catch (ArrayIndexOutOfBoundsException e) {

				if (numbers[i] == numbers[i - numberOfSteps]) {
					numberList.add(numbers[i]);
				}

			}

		}

		System.out.println("Day 1 Second puzzle answer is: " + numberList.stream().mapToInt(x -> x.intValue()).sum());
	}

}

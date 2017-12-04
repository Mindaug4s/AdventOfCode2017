package day.three;

import java.util.ArrayList;
import java.util.List;

import day.Solver;
import utils.NeighbourCellCoordinates;
//import utils.ArrayScreenRenderer;
import utils.Coordinates;
//import utils.Renderer;
import utils.Utils;

public class Day3_Solver implements Solver {

	private final int puzzlePosition;
	private double positionRoot;
	private int arrayLength;

	private boolean wasRounded = false;
	private int positionDifference;
	private boolean isInSecondPart = false;

	public Coordinates positionOfOne;
	public Coordinates positionOfPuzzle;
	private int firstLargerPuzzleValue;

	public Day3_Solver(String puzzleInput) {

		this.puzzlePosition = Integer.parseInt(puzzleInput);

	}

	@Override
	public void solveFirstPuzzle() {

		this.positionRoot = Math.sqrt(puzzlePosition);

		if (Math.pow((int) positionRoot, 2) != puzzlePosition) {

			arrayLength = (int) positionRoot + 1;

			wasRounded = true;
			positionDifference = (int) (puzzlePosition - Math.pow(arrayLength - 1, 2));

			isInSecondPart = (positionDifference - arrayLength) >= 0;

		} else {
			arrayLength = (int) positionRoot;
		}

		positionOfOne = setPositionOfOne(arrayLength);

		if (!wasRounded && arrayLength % 2 == 0) {
			positionOfPuzzle = new Coordinates(0, 0);
		}
		if (!wasRounded && arrayLength % 2 != 0) {
			positionOfPuzzle = new Coordinates(arrayLength - 1, arrayLength - 1);
		}

		if (!isInSecondPart && arrayLength % 2 == 0) {

			positionOfPuzzle = new Coordinates(arrayLength - 1, arrayLength - positionDifference);
		}
		if (isInSecondPart && arrayLength % 2 == 0) {

			positionOfPuzzle = new Coordinates(0, 2 * arrayLength - positionDifference - 1);
		}

		if (!isInSecondPart && arrayLength % 2 != 0) {

			positionOfPuzzle = new Coordinates(positionDifference - 1, 0);
		}
		if (isInSecondPart && arrayLength % 2 != 0) {

			positionOfPuzzle = new Coordinates(arrayLength - 1, positionDifference - arrayLength);
		}

		int rowDiff = Math.abs(positionOfOne.getRow() - positionOfPuzzle.getRow());
		int columnDiff = Math.abs(positionOfOne.getColumn() - positionOfPuzzle.getColumn());
		int diffSum = rowDiff + columnDiff;

		System.out.println("Day 3 First puzzle answer is: " + diffSum);

	}

	@Override
	public void solveSecondPuzzle() {

		int[][] puzzleArray = new int[10][10];
		//Renderer renderer = new ArrayScreenRenderer(puzzleArray);

		Utils.initialize2DArrayWithZeroValues(puzzleArray);
		positionOfOne = setPositionOfOne(puzzleArray.length);

		puzzleArray[positionOfOne.getRow()][positionOfOne.getColumn()] = 1;

		Coordinates currentPosition = new Coordinates(positionOfOne.getRow(), positionOfOne.getColumn());

		mainIteration: for (int i = 1; i < puzzleArray.length; i++) {

			int firstHalf = 0;
			int secondHalf = 0;

			if (i % 2 != 0 || i == 1) {
				while (firstHalf < i) {

					currentPosition.setRow(currentPosition.getRow());
					currentPosition.setColumn(currentPosition.getColumn() + 1);
					int currentCount = countCellSum(currentPosition, puzzleArray);
					puzzleArray[currentPosition.getRow()][currentPosition.getColumn()] = currentCount;

					if (currentCount > puzzlePosition) {
						firstLargerPuzzleValue = currentCount;
						break mainIteration;
					}

					firstHalf++;
				}
				while (secondHalf < i) {
					currentPosition.setRow(currentPosition.getRow() - 1);
					currentPosition.setColumn(currentPosition.getColumn() + 0);
					int currentCount = countCellSum(currentPosition, puzzleArray);
					puzzleArray[currentPosition.getRow()][currentPosition.getColumn()] = currentCount;
					if (currentCount > puzzlePosition) {
						firstLargerPuzzleValue = currentCount;
						break mainIteration;
					}
					secondHalf++;
				}
			}

			if (i % 2 == 0) {
				while (firstHalf < i) {
					currentPosition.setRow(currentPosition.getRow() + 0);
					currentPosition.setColumn(currentPosition.getColumn() - 1);
					int currentCount = countCellSum(currentPosition, puzzleArray);
					puzzleArray[currentPosition.getRow()][currentPosition.getColumn()] = currentCount;
					if (currentCount > puzzlePosition) {
						firstLargerPuzzleValue = currentCount;
						break mainIteration;
					}
					firstHalf++;
				}
				while (secondHalf < i) {
					currentPosition.setRow(currentPosition.getRow() + 1);
					currentPosition.setColumn(currentPosition.getColumn() + 0);
					int currentCount = countCellSum(currentPosition, puzzleArray);
					puzzleArray[currentPosition.getRow()][currentPosition.getColumn()] = currentCount;
					if (currentCount > puzzlePosition) {
						firstLargerPuzzleValue = currentCount;
						break mainIteration;
					}
					secondHalf++;
				}
			}

		}

		/**
		 * Draws the array with filled values;
		 */
		// renderer.rend();

		System.out.println("Day 3 Second puzzle answer is: " + firstLargerPuzzleValue);

	}

	private Coordinates setPositionOfOne(int arrayLength) {

		Coordinates positionOfOne = null;
		if (arrayLength % 2 == 0) {

			positionOfOne = new Coordinates(arrayLength / 2, arrayLength / 2 - 1);

		}

		if (arrayLength % 2 != 0) {
			positionOfOne = new Coordinates(arrayLength / 2, arrayLength / 2);
		}
		return positionOfOne;
	}

	private int countCellSum(Coordinates currentCoordinates, int[][] puzzleArray) {

		List<Integer> neighbourCellValues = new ArrayList<>();

		for (Coordinates neighbour : NeighbourCellCoordinates.listOfCoordinates) {

			int currentCellValue = 0;

			try {
				currentCellValue = puzzleArray[currentCoordinates.getRow() + neighbour.getColumn()][currentCoordinates
						.getColumn() + neighbour.getRow()];
			} catch (IndexOutOfBoundsException e) {

			}

			neighbourCellValues.add(currentCellValue);

		}

		return neighbourCellValues.stream().mapToInt(x -> x.intValue()).sum();
	}

}

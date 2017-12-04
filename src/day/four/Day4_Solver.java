package day.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import day.Solver;
import utils.Utils;

public class Day4_Solver implements Solver {

	private String[][] passList;
	private List<String[]> validPassPharases;
	private List<String[]> secondValidPassPhrases;

	public Day4_Solver(String day4Puzzleinput) {
		passList = (String[][]) Utils.fillArrayWithDataFromFile(day4Puzzleinput, " ");
	}

	@Override
	public void solveFirstPuzzle() {
		validPassPharases = new ArrayList<>();
		for (int i = 0; i < passList.length; i++) {
			if (Arrays.stream(passList[i]).count() == Arrays.stream(passList[i]).distinct().count()) {
				validPassPharases.add(passList[i]);
			}

		}
		System.out.println("Day 4 First puzzle answer is: " + validPassPharases.size());
	}

	@Override

	public void solveSecondPuzzle() {

		secondValidPassPhrases = new ArrayList<>();

		for (String[] currentStringArray : validPassPharases) {

			List<String> tempList = new ArrayList<>();

			for (int i = 0; i < currentStringArray.length; i++) {

				char[] some = currentStringArray[i].toCharArray();
				Arrays.sort(some);
				tempList.add(new String(some));

			}
			if (tempList.stream().count() == tempList.stream().distinct().count()) {
				secondValidPassPhrases.add(currentStringArray);
			}
		}

		System.out.println("Day 4 Second puzzle answer is: " + secondValidPassPhrases.size());
	}

}

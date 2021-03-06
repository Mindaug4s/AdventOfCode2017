package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Utils {

	public static int[] getArrayFilledWithNumbers(String puzzleInput) {
		int[] numbers = new int[puzzleInput.length()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(puzzleInput.charAt(i)));

		}
		return numbers;
	}

	public static Object[][] fillArrayWithDataFromFile(String fileName, String spliterator) {

		String thisLine;

		BufferedReader myInput = null;

		try {
			myInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<Object[]> lines = new ArrayList<Object[]>();

		try {
			while ((thisLine = myInput.readLine()) != null) {
				lines.add(thisLine.split(spliterator));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// lines.remove(0);
		String[][] array = new String[lines.size()][0];

		try {
			myInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines.toArray(array);
	}

	public static String makeSeparatorLine(int[][] puzzlyArray) {

		String separatorLine = "\n";

		for (int i = 0; i < puzzlyArray.length; i++) {
			separatorLine += "--- ";
		}
		return separatorLine;

	}

	public static void initialize2DArrayWithZeroValues(int[][] puzzleArray) {
		
		for (int i = 0; i < puzzleArray.length; i++) {

			for (int k = 0; k < puzzleArray[i].length; k++) {

				puzzleArray[i][k] = 0;
			}

		}
		
		
	}
	
	
	public static int[] convertStringArrayToInt(String[][] stringArray) {

		int[] intArray = new int[stringArray.length];

		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i][0]);
		}

		return intArray;
	}


}

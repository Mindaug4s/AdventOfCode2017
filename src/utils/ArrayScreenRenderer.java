package utils;

public class ArrayScreenRenderer implements Renderer {

	private static String separatorLine;
	private int[][] puzzleArray;

	public ArrayScreenRenderer(int[][] puzzleArray) {

		this.puzzleArray = puzzleArray;

	}

	@Override
	public void rend() {

		separatorLine = Utils.makeSeparatorLine(puzzleArray);

		for (int i = 0; i < puzzleArray.length; i++) {

			System.out.println(separatorLine);

			for (int k = 0; k < puzzleArray.length; k++) {

				System.out.print(" " + puzzleArray[i][k] + " |");
			}

		}

		System.out.println(separatorLine);

	}

}

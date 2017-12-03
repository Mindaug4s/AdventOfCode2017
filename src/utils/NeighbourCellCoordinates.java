package utils;

import java.util.Arrays;
import java.util.List;

public class NeighbourCellCoordinates {
	
	
	private final static Coordinates westernCell = new Coordinates(0, -1);
	private final static Coordinates easternCell = new Coordinates(0, 1);
	private final static Coordinates northernCell = new Coordinates(-1, 0);
	private final static Coordinates southernCell = new Coordinates(1, 0);
	private final static Coordinates northWesternCell = new Coordinates(-1, -1);
	private final static Coordinates northEasternCell = new Coordinates(-1, 1);
	private final static Coordinates southEasternCell = new Coordinates(1, 1);
	private final static Coordinates southWesternCell = new Coordinates(1, -1);

	
	static public final List<Coordinates> listOfCoordinates = Arrays.asList(westernCell, easternCell, northernCell, southernCell,
			northWesternCell, northEasternCell, southEasternCell, southWesternCell);

}

package vegetableGarden.robot.services;

public class CardinalPoints {

	
	public static String toNoth(String dir) {
		String direction;
		switch (dir) {
		case "L":
			direction = "E ";
			break;
		case "S":
			direction = "D D ";
			break;
		case "O":
			direction = "D ";
			break;
		default:
			direction = "";
		}
		return direction;
	}
	
	public static String toSouth(String dir) {
		String direction;
		switch (dir) {
		case "L":
			direction = "D ";
			break;
		case "N":
			direction = "D D ";
			break;
		case "O":
			direction = "E ";
			break;
		default:
			direction = "";
		}
		return direction;
	}
	
	public static String toEast(String dir) {
		String direction;
		switch (dir) {
		case "N":
			direction = "D ";
			break;
		case "S":
			direction = "E ";
			break;
		case "O":
			direction = "D D ";
			break;
		default:
			direction = "";
		}
		return direction;
	}
	
	public static String toWest(String dir) {
		String direction;
		switch (dir) {
		case "L":
			direction = "D D ";
			break;
		case "S":
			direction = "D ";
			break;
		case "N":
			direction = "E ";
			break;
		default:
			direction = "";
		}
		return direction;
	}
}

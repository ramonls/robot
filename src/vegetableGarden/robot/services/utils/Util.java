package vegetableGarden.robot.services.utils;

public class Util {

	
	public static String Noth(String dir) {
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
	
	public static String South(String dir) {
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
	
	public static String East(String dir) {
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
	
	public static String West(String dir) {
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

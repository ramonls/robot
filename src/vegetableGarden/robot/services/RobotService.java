package vegetableGarden.robot.services;

import java.util.ArrayList;
import java.util.List;

import vegetableGarden.robot.services.utils.Util;

public class RobotService {

	List<String> directions = new ArrayList<>();
	String direction;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<String> getDirections() {
		return directions;
	}

	public String printDirection(String initialDirection) {
		String direction;

		switch (initialDirection) {
		case "N":
			direction = "/\\";
			break;
		case "S":
			direction = "\\/";
			break;
		case "L":
			direction = " >";
			break;
		case "O":
			direction = " <";
			break;
		default:
			direction = "Erro";
		}
		return direction;
	}

	public void irrigationSteps(int robotPositionRow, int robotPositionColumn, String dir, int irrigationPositionRow,
			int irrigationPositionColumn) {

		direction = dir;
		int move = 0;

		if (robotPositionRow < irrigationPositionRow) {
			move = Math.abs(robotPositionRow - irrigationPositionRow);
			directions.add(Util.toNoth(direction.toUpperCase()));
			for (int i = 0; i < move; i++) {
				directions.add("M ");
			}
			direction = "N";
		} else if (robotPositionRow > irrigationPositionRow) {
			move = Math.abs(robotPositionRow - irrigationPositionRow);
			directions.add(Util.toSouth(direction.toUpperCase()));
			for (int i = 0; i < move; i++) {
				directions.add("M ");
			}
			direction = "S";
		}

		if (robotPositionColumn < irrigationPositionColumn) {
			move = Math.abs(robotPositionColumn - irrigationPositionColumn);
			directions.add(Util.toEast(direction.toUpperCase()));
			for (int i = 0; i < move; i++) {
				directions.add("M ");
			}
			direction = "L";
		} else if (robotPositionColumn > irrigationPositionColumn) {
			move = Math.abs(robotPositionColumn - irrigationPositionColumn);
			directions.add(Util.toWest(direction.toUpperCase()));
			for (int i = 0; i < move; i++) {
				directions.add("M ");
			}
			direction = "O";
		}

		directions.add("I ");
	}
}

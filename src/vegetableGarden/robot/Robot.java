package vegetableGarden.robot;

import java.util.ArrayList;
import java.util.List;

import vegetableGarden.VegetableGarden;
import vegetableGarden.robot.services.RobotService;

public class Robot {
	
	RobotService rs = new RobotService();
	
	private Integer[] position = new Integer[2];
	private Integer[] initialPosition = new Integer[2];
	private Integer[] gardenVegetableSize = new Integer[2];
	
	private String direction;
	private String printInitialDirection;

	private List<String> pathTaken = new ArrayList<>();
	
	
	public Robot() {
	}
	
	public Robot(String initialDirection, VegetableGarden vegetableGarden) {
		setDirection(initialDirection.toUpperCase());
		this.gardenVegetableSize[0] = vegetableGarden.getVegetableGardenSizeRow();
		this.gardenVegetableSize[1] = vegetableGarden.getVegetableGardenSizeColumn();
	}

	public Integer getPositionRow() {
		return position[0];
	}
	public Integer getPositionColumn() {
		return position[1];
	}

	public void setPositionRow(Integer initialPositionRow) {
		if(initialPositionRow <= getGardenVegetableSizeRow()) {
			this.position[0] = initialPositionRow;
			initialPosition[0] = position[0];
		}	
	}
	
	public void setPositionColumn(Integer initialPositionColumn) {
		if(initialPositionColumn <= getGardenVegetableSizeColumn()) {
			this.position[1] = initialPositionColumn;
			initialPosition[1] = position[1];
		}
	}
	
	public Integer getInitialPositionRow() {
		return initialPosition[0];
	}
	public Integer getInitialPositionColumn() {
		return initialPosition[1];
	}

	public String getDirection() {
		return direction;
	}

	public String getPrintInitialDirection() {
		return printInitialDirection;
	}

	public void setDirection(String initialDirection) {
		if(!initialDirection.isEmpty() && initialDirection.matches("[NSLO]{1}")) {
			this.direction = initialDirection;
			printInitialDirection = direction;
		}
	}

	public Integer getGardenVegetableSizeRow() {
		return gardenVegetableSize[0];
	}
	
	public Integer getGardenVegetableSizeColumn() {
		return gardenVegetableSize[1];
	}

	public List<String> getPathTaken() {
		return pathTaken;
	}
	
	public void irrigation(int y, int x) {
		rs.irrigationSteps(getPositionRow(), getPositionColumn(), direction, y, x);
		pathTaken = rs.getDirections();
		direction = rs.getDirection();
		position[0] = y;
		position[1] = x;
	}
	
	@Override
	public String toString() {
		return rs.printDirection(getPrintInitialDirection());
	}
}

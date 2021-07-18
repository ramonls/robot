package application;

import vegetableGarden.Irrigation;
import vegetableGarden.VegetableGarden;
import vegetableGarden.robot.Robot;

public class UI {

	public static void printVegetableGarden(VegetableGarden vegetableGarden, Robot robot, Irrigation irrigation) {

		int row = vegetableGarden.getVegetableGardenSizeRow();
		int column = vegetableGarden.getVegetableGardenSizeColumn();
		
		for (int i = 1; i <= row; i++) {
			System.out.print("");
			for (int j = 0; j < column; j++) {
				if (j == 0) {
					if (row > 10) {
						System.out.print("     +------+");
					} else {
						System.out.print("     +------+");
					}
				} else {
					System.out.print("------+");
				}
			}

			System.out.println("");
			if (row - i >= 10) {
				System.out.print((row - i) + "   |");
			} else {
				System.out.print((row - i) + "    |");
			}

			for (int o = 0; o < column; o++) {

				System.out.print("  ");
				if (robot.getInitialPositionColumn().equals(o) && robot.getInitialPositionRow().equals(row - i)) {
					System.out.print(robot);
				} else if (irrigation.getIrrigationPosition(row-i, o) != null) {
					System.out.print("i"+irrigation.getIrrigationPosition(row-i, o));			
				}
				else {
					System.out.print("  ");
				}
				System.out.print("  |");
			}

			System.out.println("");

			if (i == row) {
				for (int j = 0; j < column; j++) {
					if (j == 0) {
						System.out.print("     +------+");
					} else {
						System.out.print("------+");
					}
				}
				System.out.println();
				for (int j = 0; j <= column; j++) {
					if (row > 10 && j == 0) {
						System.out.print("      ");
					} else if (j == 0) {
						System.out.print("      ");
					} else if (j >= 10) {
						System.out.print("   " + (j - 1) + "  ");
					} else {
						System.out.print("  " + (j - 1) + "    ");
					}

				}

			}
		}
		System.out.println();
		System.out.println();
		System.out.print("Caminho: ");
		for(String x : robot.getPathTaken()) {
			System.out.print(x);
		}
		System.out.println();
		System.out.print("Orientação final: "+robot.getDirection());
		
	}
}

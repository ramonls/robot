package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import vegetableGarden.Irrigation;
import vegetableGarden.VegetableGarden;
import vegetableGarden.robot.Robot;

// Ramon Lima
public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean stop = false;

		Integer x = 0;
		Integer y = 0;
		String direction;

		do {
			try {
				System.out.println();
				System.out.println("=== Hortaliças e Hortaliças ===");
				System.out.println();
				System.out.println("Digite o tamanho da sua horta:");
				System.out.print("Y: ");
				y = sc.nextInt();
				sc.nextLine();
				System.out.print("X: ");
				x = sc.nextInt();
				sc.nextLine();
				stop = false;
			} catch (InputMismatchException e) {
				System.out.println("Somente números!");
				sc.nextLine();
				stop = true;
			}
		} while (stop);

		System.out.println("Tamanho da horta Y:" + y + " X:" + x);
		VegetableGarden vegetableGarden = new VegetableGarden(y, x);
		System.out.println();

		do {
			stop = true;
			System.out.print("Orientação Inicial do Robô [N-S-L-O]: ");
			direction = sc.next().toUpperCase();
			if (!direction.isEmpty() && direction.matches("[NSLO]{1}")) {
				stop = false;
			} else {
				System.out.println("Use apenas as letras (N) (S) (L) (O)");
				System.out.println();
			}
		} while (stop);

		Robot robot = new Robot(direction, vegetableGarden);
		System.out.println();

		do {
			stop = true;
			try {
				System.out.println("Posição Inicial do Robô:");
				System.out.print("Y: ");
				y = sc.nextInt();
				sc.nextLine();
				System.out.print("X: ");
				x = sc.nextInt();
				sc.nextLine();

				if (y.intValue() < vegetableGarden.getVegetableGardenSizeRow() && y > 0
						&& x.intValue() < vegetableGarden.getVegetableGardenSizeColumn() && x > 0) {
					robot.setPositionRow(y);
					robot.setPositionColumn(x);
					stop = false;
				} else {
					System.out.println("Fora dos limites da horta!");
					System.out.println();
				}
			} catch (InputMismatchException e) {
				System.out.println("Somente números!");
				System.out.println();
				sc.nextLine();
			}
		} while (stop);

		System.out.println();
		Irrigation irrigation = new Irrigation();

		do {
			stop = true;
			try {
				System.out.println();
				System.out.print("Quantidade de canteiro para irrigação: ");
				int quantity = sc.nextInt();

				Integer[][] irrigationPosition = new Integer[quantity][2];

				System.out.println();
				System.out.println("Posição das horas para irrigação");

				for (int i = 0; i < quantity; i++) {

					System.out.println("Hora " + (i + 1) + " de " + (quantity));
					System.out.print("Y: ");
					int auxY = sc.nextInt();
					sc.nextLine();
					System.out.print("X: ");
					int auxX = sc.nextInt();
					sc.nextLine();

					if (auxY < vegetableGarden.getVegetableGardenSizeRow()
							&& auxX < vegetableGarden.getVegetableGardenSizeColumn()) {
						irrigationPosition[i][0] = auxY;
						irrigationPosition[i][1] = auxX;
						robot.irrigation(irrigationPosition[i][0], irrigationPosition[i][1]);
					} else {
						i -= 1;
						System.out.println("Fora dos limites da horta");
						System.out.println();
					}
				}
				irrigation.setIrrigationPosition(irrigationPosition);
				stop = false;

			} catch (InputMismatchException e) {
				System.out.println("Somente números!");
				System.out.println();
				sc.nextLine();
			}

		} while (stop);

		System.out.println();

		UI.printVegetableGarden(vegetableGarden, robot, irrigation);
		sc.close();
	}
}

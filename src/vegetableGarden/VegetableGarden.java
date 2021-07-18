package vegetableGarden;

public class VegetableGarden {
	
	private Integer[] vegetableGardenSize = new Integer[2];
	
	public VegetableGarden(int row, int column) {
		vegetableGardenSize[0] = row;
		vegetableGardenSize[1] = column;
	}

	public Integer getVegetableGardenSizeRow() {
		return vegetableGardenSize[0];
	}
	public Integer getVegetableGardenSizeColumn() {
		return vegetableGardenSize[1];
	}
}

package vegetableGarden;

public class Irrigation {

	private Integer[][] irrigationPosition = new Integer[2][2];
	
	public Irrigation() {
	}
	
	public Integer[][] getIrrigation() {
		return irrigationPosition;
	}
	
	public void setIrrigationPosition(Integer[][] position) {
		irrigationPosition = position;
	}
	
	public Integer getIrrigationPosition(int row, int column) {
		for(int i = 0; i < irrigationPosition.length; i++ ) {				
			if(irrigationPosition[i][0].equals(row) && irrigationPosition[i][1].equals(column)) {
				return i+1;
			}
		}
		return null;
	}
}

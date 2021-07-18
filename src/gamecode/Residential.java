package gamecode;

public class Residential extends gameBuilding {
	private int level;
	
	public Residential() {
		// TODO Auto-generated constructor stub
		super.setZoneType("Residential");
		level=1;
	}

	@Override
	public int calcTax() {
		// TODO Auto-generated method stub
		return 0;
	}

}

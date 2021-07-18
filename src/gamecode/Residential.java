package gamecode;

public class Residential extends gameBuilding {
	private int level;
	
	public Residential() {
		// TODO Auto-generated constructor stub
		super.setZoneType("Residential");
		setLevel(1);
	}

	@Override
	public int calcTax() {
		// TODO Auto-generated method stub
		return level*5;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}

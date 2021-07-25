package gamecode;

public class Road extends gameBuilding
{
	public Road() {
		// TODO Auto-generated constructor stub
		super.setZoneType("Road");
		
	}

	@Override
	public int calcTax() {
		// TODO Auto-generated method stub
		return -5;
	}

}

/**
 * 
 */
package gamecode;

/**
 * @author brent sheltz
 *
 */
public class Commercial extends gameBuilding {
	static final int costToBuild =100;
	private int level;
	/**
	 * 
	 */
	public Commercial() {
		// TODO Auto-generated constructor stub
		super.setZoneType("Commercial");
		level=1;
	}

	@Override
	public int calcTax() {
		// TODO Auto-generated method stub
		return (level*10);
	}

}

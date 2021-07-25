package gamecode;

public abstract class gameBuilding 
{
	String ZoneType;
	
	
	public abstract int calcTax();


	/**
	 * @return the zoneType
	 */
	public String getZoneType() {
		return ZoneType;
	}


	/**
	 * @param zoneType the zoneType to set
	 */
	public void setZoneType(String zoneType) {
		ZoneType = zoneType;
	}
}

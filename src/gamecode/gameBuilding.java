package gamecode;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class gameBuilding 
{
	String ZoneType;
	
	
	public abstract int calcTax();
	public abstract void drawBuilding(Graphics g,Rectangle pixelchunk);


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

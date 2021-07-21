package gamecode;

import java.awt.Graphics;
import java.awt.Rectangle;

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

	@Override
	public void drawBuilding(Graphics g, Rectangle pixelchunk) {
		// TODO Auto-generated method stub
		
	}

}

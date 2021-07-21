package gamecode;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Empty extends gameBuilding {
	public Empty()
	{
		super.setZoneType("Empty");
	}
	@Override
	public int calcTax() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void drawBuilding(Graphics g, Rectangle pixelchunk) {
		// TODO Auto-generated method stub
		return;
	}

}

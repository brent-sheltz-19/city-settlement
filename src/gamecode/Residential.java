package gamecode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

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

	@Override
	public void drawBuilding(Graphics g, Rectangle pixelchunk) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		pixelchunk.y+=10;
		g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height-10);
		g.fillPolygon(new int[] {pixelchunk.x,pixelchunk.x+10,pixelchunk.x+20}, new int[] {pixelchunk.y,pixelchunk.y-10,pixelchunk.y }, 3);
		g.setColor(Color.GRAY);
		g.fillRect(pixelchunk.x+7, pixelchunk.y+pixelchunk.height-15,	5 , 5);

	}

}

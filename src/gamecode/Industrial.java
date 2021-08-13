package gamecode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Industrial extends gameBuilding{

	public Industrial() {
		// TODO Auto-generated constructor stub
		super();
		super.ZoneType="Industrial";
	}

	@Override
	public int calcTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drawBuilding(Graphics g, Rectangle pixelchunk) {
		// TODO Auto-generated method stub
		g.setColor(Color.decode("0x0a4222"));
		g.fillRect(pixelchunk.x, pixelchunk.y+10, pixelchunk.width, pixelchunk.height-10);
		g.fillRect(pixelchunk.x+pixelchunk.width-10, pixelchunk.y, 10,pixelchunk.height-3);
		g.setColor(Color.gray);
		g.fillRect(pixelchunk.x+pixelchunk.width-10, pixelchunk.y,10, 3);
	
	}

}

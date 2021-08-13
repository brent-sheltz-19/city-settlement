/**
 * 
 */
package gamecode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

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

	@Override
	public void drawBuilding(Graphics g, Rectangle pixelchunk) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
		Color sign = new Color (Color.blue.getRed(),Color.BLUE.getGreen(),Color.BLUE.getBlue()-100);
		g.setColor(sign);
		g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, 10);
		g.setColor(Color.white);
		g.fillRect(pixelchunk.x+5, pixelchunk.y+pixelchunk.height-5, 10, 5);
		
	}

}

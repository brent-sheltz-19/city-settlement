 
/**
 * 
 */
package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import gamecode.gameBuilding;

/**
 * @author brent sheltz
 *
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener {
	public static Integer clickedx, clickedy = null;
	public static boolean clicked = false;
	public Integer curindexx, curindexy = null;
	public static int roadwidth = 5;
	public static int roadheight = 5;
	public Camera cam;
	public gameBuilding[][] map;
	private Dimension ScreenSize;
	private int offsetx = 0, offsety = 0;
	private int oldmousex = 0, oldmousey = 0;
	
	/**
	 * 
	 */
	public Panel() {
		// TODO Auto-generated constructor stub
		super();
		addMouseListener(this);
		//cam = new Camera(super.getWidth(),super.getHeight());
	}

	/**
	 * @param layout
	 */
	public Panel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
		addMouseListener(this);
	}

	/**
	 * @param isDoubleBuffered
	 */
	public Panel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
		addMouseListener(this);
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public Panel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.setColor(Color.GREEN);
//		g.drawRect(10, 10, 100, 100);
		this.setBackground(Color.decode("0x726500"));

		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				Rectangle pixelchunk = new Rectangle(new Point(convertIndex(x), convertIndex(y)),
						new Dimension(20, 20));
				if (map[y][x].getZoneType().equals("Road")) {
					g.setColor((Color.BLACK));
					g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
					g.setColor((Color.YELLOW));
					try {
						if (map[y + 1][x].getZoneType().equals("Road")) {
							// verticle bar
							g.fillRect(pixelchunk.x + (pixelchunk.width / 2)-5/2+offsetx, pixelchunk.y+pixelchunk.height/2+offsety, 5, pixelchunk.height/2);

						}
					} catch (Exception e) {

					}
					try {
						if (map[y - 1][x].getZoneType().equals("Road")) {
							// verticle bar
							g.fillRect(pixelchunk.x + (pixelchunk.width / 2)-5/2+offsetx, pixelchunk.y+offsety, 5, pixelchunk.height/2);

						}
					} catch (Exception e) {

					}
					try {
						if (map[y][x + 1].getZoneType().equals("Road")) {
							// horizontal bar
							g.fillRect(pixelchunk.x + pixelchunk.width / 2-5/2+offsetx, pixelchunk.height / 2 - 2+offsety,
									pixelchunk.width / 2+5/2, 5);

						}
					} catch (Exception e) {

					}
					try {
						if (map[y][x - 1].getZoneType().equals("Road")) {
							// horizontal bar
							g.fillRect(pixelchunk.x+offsety, pixelchunk.height / 2+offsety - 2,
									pixelchunk.width / 2+5/2, 5);

						}
					} catch (Exception e) {

					}
				}
				map[y][x].drawBuilding(g, pixelchunk);
			}
			// g.setColor((Color.yellow));
			// g.fillRect(pixelchunk.x, pixelchunk.height/2-2, pixelchunk.width, 5 );

			// g.setColor((Color.BLACK));
			// g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
			// g.setColor((Color.yellow));
			// g.fillRect(pixelchunk.x/2, pixelchunk.y, 5, pixelchunk.height );

		}

	}

	/**
	 * @return the map
	 */
	public gameBuilding[][] getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(gameBuilding[][] map) {
		this.map = map;
	}

	public int convertIndex(int index) {

		return index * 20;

	}

	public int convertPixel(int pixel) {

		return pixel / 20;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		clicked = true;
		clickedx = (convertPixel(e.getX()));
		clickedy = (convertPixel(e.getY()));
		System.out.println(clicked);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON2)
		{
			oldmousex = e.getX();
			oldmousey= e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse dragged");
		if(e.getButton()==MouseEvent.BUTTON2)
		{
			offsetx+=e.getX()-oldmousex;
			offsety+=e.getY()-oldmousey;
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		curindexx = e.getX();
		curindexy = e.getY();
	}

	public int getOffsetx() {
		return offsetx;
	}

	public void setOffsetx(int offsetx) {
		this.offsetx = offsetx;
	}

	public Dimension getScreenSize() {
		return ScreenSize;
	}

	public void setScreenSize(Dimension screenSize) {
		ScreenSize = screenSize;
	}

}


/**
 * 
 */
package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import gamecode.gameBuilding;

/**
 * @author brent sheltz
 *
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener {
	public static Point point;
	public static boolean clicked = false;
	public Integer curindexx, curindexy = null;
	public static int roadwidth = 5;
	public static int roadheight = 5;
	public Camera cam;
	public gameBuilding[][] map;
	private Dimension ScreenSize;
	private int offsetx, offsety;
	private Integer clickedButton;
	private KeyListener key;

	public static Point getPoint() {
		return point;
	}

	public static void setPoint(Point point) {
		Panel.point = point;
	}

	public static boolean isClicked() {
		return clicked;
	}

	public static void setClicked(boolean clicked) {
		Panel.clicked = clicked;
	}

	public Integer getCurindexx() {
		return curindexx;
	}

	public void setCurindexx(Integer curindexx) {
		this.curindexx = curindexx;
	}

	public Integer getCurindexy() {
		return curindexy;
	}

	public void setCurindexy(Integer curindexy) {
		this.curindexy = curindexy;
	}

	public static int getRoadwidth() {
		return roadwidth;
	}

	public static void setRoadwidth(int roadwidth) {
		Panel.roadwidth = roadwidth;
	}

	public static int getRoadheight() {
		return roadheight;
	}

	public static void setRoadheight(int roadheight) {
		Panel.roadheight = roadheight;
	}

	public Camera getCam() {
		return cam;
	}

	public void setCam(Camera cam) {
		this.cam = cam;
	}

	public int getOffsety() {
		return offsety;
	}

	public void setOffsety(int offsety) {
		this.offsety = offsety;
	}

	public Integer getClickedButton() {
		return clickedButton;
	}

	public void setClickedButton(Integer clickedButton) {
		this.clickedButton = clickedButton;
	}

	public KeyListener getKey() {
		return key;
	}

	public void setKey(KeyListener key) {
		this.key = key;
	}

	/**
	 * 
	 */
	public Panel() {
		super();
		Toolkit K = getToolkit();
		int width = K.getScreenSize().width;
		int height = K.getScreenSize().height;
		cam = new Camera(width, height);
		offsetx = cam.view.x;
		offsety = cam.view.y;
		addMouseListener(this);
		addMouseMotionListener(this);
		key = new keyInput(this);
		addKeyListener(key);

	}

	/**
	 * @param layout
	 */
	public Panel(LayoutManager layout) {
		super(layout);
		Toolkit K = getToolkit();
		int width = K.getScreenSize().width;
		int height = K.getScreenSize().height;
		cam = new Camera(width, height);
		offsetx = cam.view.x;
		offsety = cam.view.y;
		addMouseListener(this);
		addMouseMotionListener(this);
		key = new keyInput(this);
		addKeyListener(key);
	}

	/**
	 * @param isDoubleBuffered
	 */
	public Panel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		Toolkit K = getToolkit();
		int width = K.getScreenSize().width;
		int height = K.getScreenSize().height;
		cam = new Camera(width, height);
		offsetx = cam.view.x;
		offsety = cam.view.y;
		addMouseListener(this);
		addMouseMotionListener(this);
		key = new keyInput(this);
		addKeyListener(key);

	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public Panel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		Toolkit K = getToolkit();
		int width = K.getScreenSize().width;
		int height = K.getScreenSize().height;
		cam = new Camera(width, height);
		offsetx = cam.view.x;
		offsety = cam.view.y;
		addMouseListener(this);
		addMouseMotionListener(this);
		key = new keyInput(this);
		addKeyListener(key);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.decode("0xff00ff"));
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				// System.out.println(cam.view.toString());
				Rectangle pixelchunk = new Rectangle(
						new Point((convertIndex(x) - cam.view.x), (convertIndex(y) - cam.view.y)), new Dimension(20, 20));
				g.setColor(Color.decode("0x726500"));
				g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);

				// else if(map[y][x].getZoneType().equals("Utility"))
				// {
				// g.setColor(Color.darkGray);

				// }
				if (map[y][x].getZoneType().equals("Road")) {
					g.setColor((Color.BLACK));
					g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
					g.setColor((Color.YELLOW));
					try {
						if (map[y + 1][x].getZoneType().equals("Road")) {
							// verticle bar top bar
							g.fillRect(pixelchunk.x + (pixelchunk.width / 2) - 5 / 2,
									pixelchunk.y + pixelchunk.height / 2, 5, pixelchunk.height / 2);

						}
					} catch (Exception e) {

					}
					try {
						if (map[y - 1][x].getZoneType().equals("Road")) {
							// verticle bar bottom bar
							g.fillRect(pixelchunk.x + (pixelchunk.width / 2) - 5 / 2, pixelchunk.y, 5,
									pixelchunk.height / 2);

						}
					} catch (Exception e) {

					}
					try {
						if (map[y][x + 1].getZoneType().equals("Road")) {
							// horizontal bar right side
							g.fillRect(pixelchunk.x + pixelchunk.width / 2 - 5 / 2, (pixelchunk.height / 2 - 2)+pixelchunk.y,
									pixelchunk.width / 2 + 5 / 2, 5);

						}
					} catch (Exception e) {

					}
					try {
						if (map[y][x - 1].getZoneType().equals("Road")) {
							// horizontal bar left side
							g.fillRect(pixelchunk.x, (pixelchunk.height / 2 - 2)+pixelchunk.y, pixelchunk.width / 2 + 5 / 2, 5);

						}
					} catch (Exception e) {

					}
				}
				map[y][x].drawBuilding(g, pixelchunk);
				//System.out.println("cam view"+cam.view.x+"  "+cam.view.y);
				//System.out.println(pixelchunk.x+ " "+pixelchunk.y);
			}
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

	/**
	 * converts the given index for the game map to pixel
	 * 
	 * @param index
	 * @return
	 */
	public int convertIndex(int index) {

		return index * 20;

	}

	public int convertPixel(int pixel) {

		return pixel / 20;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		point = e.getPoint();
		clickedButton = e.getButton();
		System.out.println(point);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(e.getButton());
		clickedButton = null;

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
		// TODO Auto-generated method stu
		// System.out.print(MouseInfo.getNumberOfButtons());
		System.out.println(e.getButton());
		if (clickedButton == MouseEvent.BUTTON3) {
			System.out.print(e.getX() + " " + e.getY());
			if (e.getY() < point.y) {

				cam.move(0, 10);
				repaint();

			} else if (e.getY() > point.y) {
				cam.move(0, -10);
				repaint();
			}

			if (e.getX() < point.x) {

				cam.move(10, 0);
				repaint();

			} else if (e.getX() > point.x) {
				cam.move(-10, 0);
				repaint();
			}

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
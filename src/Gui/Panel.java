 
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
public class Panel extends JPanel implements MouseListener, MouseMotionListener{
	public static Integer clickedx,clickedy=null;
	public static boolean clicked =false;
	public  Integer curindexx,curindexy=null;
	
	public gameBuilding[][] map;
	private Dimension ScreenSize;
	private int offsetx=0, offsety=0;
	
	/**
	 * 
	 */
	public Panel() {
		// TODO Auto-generated constructor stub
		super();
		addMouseListener(this);
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
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
//		g.setColor(Color.GREEN);
//		g.drawRect(10, 10, 100, 100);
		this.setBackground(Color.decode("0x726500"));
		
		for(int y = 0 ; y<map.length;y++)
		{
			for(int x = 0 ; x <map[y].length;x++)
			{
				Rectangle pixelchunk = new Rectangle(new Point(convertIndex(x),convertIndex(y)),new Dimension(20,20));
				if(map[y][x].getZoneType().equals("Empty") )
				{
					continue;
				}
				else if(map[y][x].getZoneType().equals("Residential"))
				{
					g.setColor(Color.GREEN);
					pixelchunk.y+=10;
					g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height-10);
					g.fillPolygon(new int[] {pixelchunk.x,pixelchunk.x+10,pixelchunk.x+20}, new int[] {pixelchunk.y,pixelchunk.y-10,pixelchunk.y }, 3);
					g.setColor(Color.GRAY);
					g.fillRect(pixelchunk.x+7, pixelchunk.y+pixelchunk.height-15,	5 , 5);
				}
				else if(map[y][x].getZoneType().equals("Commercial"))
				{
					g.setColor(Color.blue);
					g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
					Color sign = new Color (Color.blue.getRed(),Color.BLUE.getGreen(),Color.BLUE.getBlue()-100);
					g.setColor(sign);
					g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, 10);
					g.setColor(Color.white);
					g.fillRect(pixelchunk.x+5, pixelchunk.y+pixelchunk.height-5, 10, 5);
					
				}
				else if(map[y][x].getZoneType().equals("Industrial"))
				{
					g.setColor(Color.decode("0x0a4222"));
					g.fillRect(pixelchunk.x, pixelchunk.y+10, pixelchunk.width, pixelchunk.height-10);
					g.fillRect(pixelchunk.x+pixelchunk.width-10, pixelchunk.y, 10,pixelchunk.height-3);
					g.setColor(Color.gray);
					g.fillRect(pixelchunk.x+pixelchunk.width-10, pixelchunk.y,10, 3);
					
				}
				else if(map[y][x].getZoneType().equals("Utility"))
				{
					g.setColor(Color.darkGray);
					
				}
				else if(map[y][x].getZoneType().equals("Road"))
				{
					g.setColor((Color.BLACK));
					g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
					
						if(y==0)
						{
							if(x==0)
							{
								g.setColor((Color.yellow));
								if(map[y][x+1].getZoneType().equals("Road")&&map[y+1][x].getZoneType().equals("Road"))
								{
									//horizontal bar
									g.fillRect(pixelchunk.x,pixelchunk.y+ pixelchunk.height/2, (pixelchunk.width/2), 6 );
									//verticle bar
									g.fillRect(pixelchunk.x+(pixelchunk.width/2), pixelchunk.y+(pixelchunk.height/2), 6, pixelchunk.height );
									
								}
								else if(map[y+1][x].getZoneType().equals("Road") )
								{
									//verticle bar
									g.fillRect(pixelchunk.x+(pixelchunk.width/2), pixelchunk.y, 5, pixelchunk.height );
								
								}
								else if(map[y][x+1].getZoneType().equals("Road"))
								{
									//horizontal
									g.fillRect(pixelchunk.x+pixelchunk.width/2, pixelchunk.height/2-2, pixelchunk.width/2, 5 );
											
								}
							}
							else if(x==map[y].length)
							{
								g.setColor((Color.yellow));
								if(map[y][x-1].getZoneType().equals("Road")&&map[y+1][x].getZoneType().equals("Road"))
								{
									//horizontal bar
									g.fillRect(pixelchunk.x,pixelchunk.y+ pixelchunk.height/2, (pixelchunk.width/2), 6 );
									//verticle bar
									g.fillRect(pixelchunk.x+(pixelchunk.width/2), pixelchunk.y+(pixelchunk.height/2), 6, pixelchunk.height );
									
								}
								else if(map[y+1][x].getZoneType().equals("Road") )
								{
									//verticle bar
									g.fillRect(pixelchunk.x+(pixelchunk.width/2), pixelchunk.y, 5, pixelchunk.height );
								
								}
								else if(map[y][x-1].getZoneType().equals("Road"))
								{
									//horizontal
									g.fillRect(pixelchunk.x+pixelchunk.width/2, pixelchunk.height/2-2, pixelchunk.width/2, 5 );
											
								}
							}
							else 
							{
								g.setColor((Color.yellow));
								if(map[y][x-1].getZoneType().equals("Road")&&map[y][x+1].getZoneType().equals("Road"))
								{
									//horizontal bar
									g.fillRect(pixelchunk.x,pixelchunk.y+ pixelchunk.height/2, (pixelchunk.width/2), 6 );
									//verticle bar
									g.fillRect(pixelchunk.x+(pixelchunk.width/2), pixelchunk.y+(pixelchunk.height/2), 6, pixelchunk.height );
									
								}
								else if(map[y+1][x].getZoneType().equals("Road") )
								{
									//verticle bar
									g.fillRect(pixelchunk.x+(pixelchunk.width/2), pixelchunk.y, 5, pixelchunk.height );
								
								}
								else if(map[y][x-1].getZoneType().equals("Road"))
								{
									//horizontal
									g.fillRect(pixelchunk.x+pixelchunk.width/2, pixelchunk.height/2-2, pixelchunk.width/2, 5 );
											
								}
							}
							
						}
						
					}
									//g.setColor((Color.yellow));
									//g.fillRect(pixelchunk.x, pixelchunk.height/2-2, pixelchunk.width, 5 );
								
					
						//g.setColor((Color.BLACK));
						//g.fillRect(pixelchunk.x, pixelchunk.y, pixelchunk.width, pixelchunk.height);
						//g.setColor((Color.yellow));
						//g.fillRect(pixelchunk.x/2, pixelchunk.y, 5, pixelchunk.height );
						
					}
				setOffsetx(getOffsetx() + 1);	
				
				}
					
						
						
				offsety++;				
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
	public int convertIndex(int index)
	{
		
		return index*20;
		
	}
	public int convertPixel(int pixel)
	{
		
		return pixel/20;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		clicked=true;
		clickedx=(convertPixel(e.getX()));
		clickedy=(convertPixel(e.getY()));
		System.out.println(clicked);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		curindexx=e.getX();
		curindexy=e.getY();
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


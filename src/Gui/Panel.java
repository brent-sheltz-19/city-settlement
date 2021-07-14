/**
 * 
 */
package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;

import javax.swing.JPanel;

import gamecode.gameBuilding;
	
/**
 * @author brent sheltz
 *
 */
public class Panel extends JPanel {
	public gameBuilding[][] map;
	/**
	 * 
	 */
	public Panel() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @param layout
	 */
	public Panel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public Panel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
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
		g.setColor(Color.GREEN);
		g.drawRect(10, 10, 100, 100);
//		for(int y = 0 ; y<map.length;y++)
//		{
//			for(int x = 0 ; x <map[y].length;x++)
//			{
//				if(map[y][x].getZoneType().equals("Residential"))
//				{
//					g.setColor(Color.GREEN);
//					
//				}
//				else if(map[y][x].getZoneType().equals("Commercial"))
//				{
//					g.setColor(Color.blue);
//					
//				}
//				else if(map[y][x].getZoneType().equals("Industrial"))
//				{
//					g.setColor(Color.YELLOW);
//					
//				}
//				else if(map[y][x].getZoneType().equals("Utility"))
//				{
//					g.setColor(Color.darkGray);
//					
//				}
//				else if(map[y][x]== null )
//				{
//					g.setColor(Color.decode("FF9200"));
//					
//				}
//				
//			}
//		}
	
	}
}

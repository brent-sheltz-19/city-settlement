/**
 * 
 */
package Gui;

import java.awt.Rectangle;

/**
 * @author brent sheltz
 *
 */
public class Camera {
	public Rectangle view;
	public int x,y;
	/**
	 * 
	 */
	public Camera(int width,int height) 
	{
		view= new Rectangle(0, 0, width, height);
		
		
		// TODO Auto-generated constructor stub
	
	
	}
	public void moveLeft()
	{
		view.x--;
	}
	public void moveLeft(int scroll)
	{
		view.x-=scroll;
	}
	public void moveRight()
	{
		view.x++;
	}
	public void moveRight(int scroll)
	{
		view.x+=scroll;
	
	}
	public void moveUp()
	{
		view.y--;
		
	}
	public void moveUp(int scroll)
	{
		view.y-=scroll;
	}
	public void moveDown()
	{
		view.y++;
	}
	public void moveDown(int scroll)
	{
		view.y+=scroll;
	
	}

}
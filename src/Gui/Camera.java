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
	/**
	 * 
	 */
	public Camera(int width,int height) 
	{
		view= new Rectangle(0, 0, width, height);
		
		
		// TODO Auto-generated constructor stub
	
	
	}
	public void move(int x, int y)
	{
		if(x<0)
		{
			moveLeft(x);
		}
		else if(x>0)
		{
			moveRight(x);
		}
		if(y<0)
		{
			moveUp(y);
		}
		else if(y>0)
		{
			moveDown(y);
		}
	}
	public void moveLeft()
	{
		view.x--;
	}
	public void moveLeft(int scroll)
	{
		view.x+=scroll;
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
		view.y+=scroll;
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
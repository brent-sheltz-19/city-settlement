/**
 * 
 */
package Gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Brent
 *
 */
public class keyInput extends KeyAdapter implements KeyListener {
	Panel p;
	public keyInput(Panel c)
	{
		p=c;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.toString());
		if(e.getKeyChar()=='r')
		{
			p.cam.view.x=0;
			p.cam.view.y=0;
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)
		{
			p.cam.move(-20,0);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)
		{
			p.cam.move(20,0);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
		{
			p.cam.move(0,-20);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_S)
		{
			p.cam.move(0,20);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.toString());
		if(e.getKeyChar()=='r')
		{
			p.cam.view.x=0;
			p.cam.view.y=0;
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)
		{
			p.cam.move(-20,0);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)
		{
			p.cam.move(20,0);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
		{
			p.cam.move(0,-20);
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_S)
		{
			p.cam.move(0,20);
			
		}
	}

}

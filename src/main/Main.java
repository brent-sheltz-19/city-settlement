package main;
/**
 * 
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;

import Gui.*;
import gamecode.*;
/**
 * @author brent sheltz
 *
 */
public class Main
{	
	Timer timer= new Timer();
	gameBuilding[][] map;
	public static int money=0;
	private Main()
	{
		
		
		timer.schedule(new TaxTimmer(map),0,10000);
		map= new gameBuilding[100][100];
		Random ranx = new Random();
		Random rany = new Random();
		Random ranBuild = new Random();
		
		for(int i = 0; i <100;i++)
		{
			int x =ranx.nextInt(100);
			int y =ranx.nextInt(100);
			int build = ranBuild.nextInt(3);
			if(build==1)
			{
			map[y][x]=new Residential();
			}
			else if(build==2)
			{
			map[y][x] = new Commercial(); 
			}	
			else if(build==3)
			{
				map[y][x]=new Industrial();
			}
		}
		Gui gui = new Gui(map);
		//gui.paintComponents(gui.getGraphics());
		while(gui.isActive())
		{
				
				if(gui.panel.clicked)
				{
					
					System.out.println(gui.panel.clickedx+" "+gui.panel.clickedy);
					//do some stuff
					
					gui.panel.clicked=false;
				}
				
				
			
		}
		close();
	}
	public int Tax(gameBuilding[][] map2)
	{
		for(gameBuilding[]a :map2)
		{
			
		}
		
		
		
		return 0;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Main main= new Main();

		// TODO Auto-generated method stub
	
		
	}
	public void close()
	{
		timer.cancel();
		return;
	}

}

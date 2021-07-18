package main;
/**
 * 
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;

import Gui.*;
import Gui.Panel;
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
	public static int population=0;
	private Main()
	{
		map= new gameBuilding[100][100];
		
		timer.schedule(new TaxTimmer(map),0,10000);
		
		Random ranx = new Random();
		Random rany = new Random();
		Random ranBuild = new Random();
		
		for(int i = 0; i <100;i++)
		{
			int x =ranx.nextInt(100);
			int y =rany.nextInt(100);
			int build = ranBuild.nextInt(3);
			if(build==0)
			{
			map[y][x]=new Residential();
			}
			else if(build==1)
			{
			map[y][x] = new Commercial(); 
			}	
			else if(build==2)
			{
				map[y][x]=new Industrial();
			}
		}
		Gui gui = new Gui(map);
		//gui.paintComponents(gui.getGraphics());
		for (gameBuilding[] y : map) {
			for (gameBuilding x : y)
			{
				if(x== null)
				{
					System.out.print("Empty"+", ");
						
				}
				else
				{
				System.out.print(x.getZoneType()+", ");
				}
			}
			System.out.println();
		}
	}
	public void addToMap(String type,int x,int y)
	{
		
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

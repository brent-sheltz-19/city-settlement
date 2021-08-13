package main;
/**
 * 
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.lang.*;
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
	Gui gui;
	KeyListener k;
	public static int money=0;
	public static int population=0;
	private Main()
	{
		map= new gameBuilding[100][100];
		for(int y =0;y<map.length;y++)
		{
			for(int x =0;x<map[y].length;x++)
			{
				map[y][x]=new Empty();
			}
				
		}
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
		//map[0][0]=new Road();
		//map[0][1]=new Road();
		for(int i= 0 ; i<map[0].length;i++)
		{
	
			map[5][i]=new Road();
			map[i][0]=new Road();
			
		}
		gui = new Gui(map);
		k=new keyInput(gui.panel);
		gui.panel.setKey(k);			
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
		
		Main main;
		main= new Main();
	}
	public void close()
	{
		timer.cancel();
		return;
	}
}

package Gui;
import gamecode.*;
import javax.swing.*;
import java.awt.color.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
public class Gui {

	public int width= 1080;
	public int height= 720;
	public JFrame frame;
	public Panel panel;
	public JButton[] buttonlist = new JButton[5];
	private static String[] buttonlistNames = {"Demolish","Residential"};
	public gameBuilding[][] map;
	public Gui()
	{
		frame = new JFrame(" game ");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Toolkit K = frame.getToolkit();
		width=K.getScreenSize().width;
		height=K.getScreenSize().height;
		
		frame.setPreferredSize(new Dimension(width, height));
		
		panel = new Panel();
		panel.setBackground(Color.black);
		panel.setPreferredSize(new Dimension(width, height-145));
		frame.add(panel,BorderLayout.CENTER);
		for(int i = 0 ; i < 2;i++)
		{
			buttonlist[i] = new JButton(buttonlistNames[i]);
			buttonlist[i].setPreferredSize(new Dimension(width/buttonlist.length,100));
			frame.add(buttonlist[i],BorderLayout.SOUTH);
		}
		frame.pack();
		frame.setVisible(true);
		panel.paint(panel.getGraphics());

	}
	
	public boolean isActive() {
		// TODO Auto-generated method stub
		return frame.isActive();
	}
	

}
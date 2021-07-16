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
	public Gui(gameBuilding[][] map)
	{
		this.map=map;
		
		frame = new JFrame(" game ");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Toolkit K = frame.getToolkit();
		width=K.getScreenSize().width;
		height=K.getScreenSize().height;
		
		frame.setPreferredSize(new Dimension(width, height));
		
		panel = new Panel();
		panel.setMap(map);
		panel.setBackground(Color.black);
		panel.setPreferredSize(new Dimension(width, height-100));
		frame.add(panel,BorderLayout.CENTER);
		for(int i = 0 ; i < buttonlistNames.length;i++)
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

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the panel
	 */
	public Panel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	/**
	 * @return the buttonlist
	 */
	public JButton[] getButtonlist() {
		return buttonlist;
	}

	/**
	 * @param buttonlist the buttonlist to set
	 */
	public void setButtonlist(JButton[] buttonlist) {
		this.buttonlist = buttonlist;
	}

	/**
	 * @return the buttonlistNames
	 */
	public static String[] getButtonlistNames() {
		return buttonlistNames;
	}

	/**
	 * @param buttonlistNames the buttonlistNames to set
	 */
	public static void setButtonlistNames(String[] buttonlistNames) {
		Gui.buttonlistNames = buttonlistNames;
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
	

}
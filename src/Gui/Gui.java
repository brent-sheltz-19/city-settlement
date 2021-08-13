package Gui;
import gamecode.*;
import javax.swing.*;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
public class Gui implements ActionListener{

	public int width= 1080;
	public int height= 720;
	public JFrame frame;
	public Panel panel;
	public JButton construction;
	constructionMenu constructionmenu;
	public gameBuilding[][] map;
	public Gui(gameBuilding[][] map)
	{
		this.map=map;
		
		frame = new JFrame(" game ");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Toolkit K = frame.getToolkit();
		width=K.getScreenSize().width;
		height=K.getScreenSize().height;
		frame.setPreferredSize(new Dimension(width, height));
		
		panel = new Panel();
		panel.setMap(map);
		panel.setBackground(Color.black);
		panel.setPreferredSize(new Dimension(width, height-100));
		frame.add(panel,BorderLayout.CENTER);
		
		construction = new JButton("construction");
		construction.setPreferredSize(new Dimension(width,100));
		construction.addActionListener(this);
		frame.add(construction,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		constructionmenu = new constructionMenu();
		constructionmenu.setVisible(false);
		
		panel.paint(panel.getGraphics());
	}
	private void switchToConstructionMenu()
	{
		panel.setVisible(false);
		constructionmenu.setVisible(true);
		
	}
	
	public boolean isActive() {
		// TODO Auto-generated method stub
		return frame.isEnabled();
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
	public static void Terminate(Gui guitoclose)
	{
		guitoclose=null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==construction)
		{
			switchToConstructionMenu();
		}
	}
	
}
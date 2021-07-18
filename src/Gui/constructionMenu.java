package Gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class constructionMenu extends JPanel

{
	public JButton[] buttonlist = new JButton[5];
	private static String[] buttonlistNames = {"Demolish","Residential","Comercial","Industrial","Utility"};
	public constructionMenu()
	{
		for(int i=0;i<buttonlist.length;i++)
		{
			buttonlist[i]=new JButton(buttonlistNames[i]);
			buttonlist[i].setVisible(true);
			this.add(buttonlist[i]);
		}
	}
	
}

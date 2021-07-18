package Gui;

import javax.swing.JButton;

public class constructionMenu
{
	public JButton[] buttonlist = new JButton[5];
	private static String[] buttonlistNames = {"Demolish","Residential","Comercial","Industrial","Utility"};
	public constructionMenu()
	{
		for(int i=0;i<buttonlist.length;i++)
		{
			buttonlist[i]=new JButton(buttonlistNames[i]);
		}
	}
	
}

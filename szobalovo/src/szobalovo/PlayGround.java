package szobalovo;



import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayGround extends JPanel{
	 /**
	 * 
	 */
	boolean isVisible = false;
	// frame to paint the things
	private static final long serialVersionUID = 1L;
	@Override
	    public void paint(Graphics g) {

	    }
	//constructor
	public PlayGround(boolean isVisible)
	{
		this.isVisible =isVisible;
	}
	
}

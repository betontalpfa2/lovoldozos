package szobalovo;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.RenderingHints;

import szobalovo.PlayGround;

public class PlayGround extends JPanel{
	 /**
	 * 
	 */
	private static int FrameWidth = 600;
	private static int FrameHeight = 700;
	boolean isVisible = false;
	// frame to paint the things
	private static final long serialVersionUID = 1L;
	// gui component of playground
	private JFrame pgframe = new JFrame();
    private JLayeredPane pglpane = new JLayeredPane();
    private JPanel marginPanel = new JPanel();
    // the PlayGroundPanel contains the  
    private PlayGroundPanel pgpanel = new PlayGroundPanel();

	public PlayGround(boolean isVisible)
	{
		
		
		this.isVisible =isVisible;
	}
	public void CreatePlayGroundFrame()
	{
		pgframe.setPreferredSize(new Dimension(FrameWidth, FrameHeight));
		pgframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pgframe.setResizable(false);
		pgframe.setLayout(new BorderLayout());
		pgframe.add(pglpane, BorderLayout.CENTER);
		pglpane.setBounds(0, 0, FrameWidth, FrameHeight);
		marginPanel.setBackground(Color.gray);
		marginPanel.setBounds(0, 0, FrameWidth, FrameHeight);
		marginPanel.setOpaque(true);
		pgpanel.setBounds(0, 0, FrameWidth, FrameHeight - 100);
		pgpanel.setOpaque(true);
		pglpane.add(marginPanel, new Integer(0), 0);
		pglpane.add(pgpanel, new Integer(1), 0);
		pgframe.pack();
        pgframe.setVisible(true);
	}
	
	// function to rotate the cannon
	public void LeftCannon()
	{
		
		pgpanel.CannonLeftRotate();
	}
	public void RightCannon()
	{
		pgpanel.CannonRightRotate();
	}
	
	
  
}

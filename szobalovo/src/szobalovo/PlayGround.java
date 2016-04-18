package szobalovo;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PlayGround extends JPanel{
	 /**
	 * 
	 */
	// frame to paint the things
	JFrame frame;
	private static final long serialVersionUID = 1L;
	@Override
	    public void paint(Graphics g) {

	    }
	//constructor
	public PlayGround(boolean isVisible)
	{
		 JFrame frame = new JFrame("Szobalovo");
        frame.add(this);
        frame.setSize(600, 700);
        JLabel UserName = new JLabel("ForExamle John");
        
        UserName.setSize(50, 30);
        UserName.setLocation(40, 40);
      //  int xk= UserName.getX();
        //JOptionPane.showMessageDialog(null,"" + xk);
        frame.add(UserName);
        frame.setVisible(isVisible);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//this.setVisible(isVisible);
	}

}

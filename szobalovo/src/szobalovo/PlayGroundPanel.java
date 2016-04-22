package szobalovo;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PlayGroundPanel extends JPanel {

	public static int CannonWidth  = 124; // in px
	public static int CannongHeight  = 160; // in px
	private static final long serialVersionUID = 1L;
	BufferedImage cannonimage, backgroundimage;
	// the koordinates of the cannon
	int cannonCenterXKoord = 0;
    int cannonCenterYKoord = 0;
    public int CannonAngle = 0;
    private boolean showBullet = false;
    private boolean panelshowing = true;
    private int bullXpos = 40, bullYPos = 200;
	public PlayGroundPanel()
	{
		//this.setBackground(Color.green);
		// set the cannon picture
		//set the backgrounf image
				try {
					cannonimage = ImageIO.read(getClass().getResource("/cannonl.png"));
					backgroundimage = ImageIO.read(getClass().getResource("/PlayGroundbackground.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JLabel lab = new JLabel("bull");
				//lab.setBounds(25, 27, 40, 40);
				this.add(lab);
				MyKeyListener myKeyList = new MyKeyListener(this);
				addKeyListener(myKeyList);
				setFocusable(true);
			
		
	}

	 @Override
	    public void paint(Graphics g) {
		// location of the cannon. At the bottom of the panel in the middle
	        cannonCenterXKoord = this.getWidth()/2 - (CannonWidth/2) ;
	        cannonCenterYKoord = this.getHeight()+10 - CannongHeight;
	        // if at least one koordinate is less then 0, the both koordinates are 0
	        if(cannonCenterXKoord<0 || cannonCenterYKoord<0)
	        {
	       	 cannonCenterXKoord = 0;
	       	 cannonCenterYKoord = 0;
	        }
		 super.paint(g);
		 // set the background
		g.drawImage(backgroundimage, 0, 0, null);

		//cannon
		Graphics2D g2d = (Graphics2D) g;
        
        // Rotation information
        double rotationRequired = Math.toRadians (CannonAngle);
        double locationX = CannonWidth / 2 ; // necessary to increase the area
        double locationY = CannongHeight / 2 ;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        // Drawing the rotated image at the required drawing locations
        g2d.drawImage(op.filter(cannonimage, null), cannonCenterXKoord, cannonCenterYKoord, null);
        if(showBullet)
        {
        	bullXpos=this.getWidth()/2;
	        Graphics2D bull = (Graphics2D) g;
	        bull.fillOval(bullXpos, bullYPos, 10, 10);
	       // panelshowing=false;
	        bullYPos = bullYPos-50;
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(bullYPos>51)
        {
        this.repaint();
        }
        }

	 }
	 
	 // functions which are responsible the rotate of the cannon
	 //rotate left 1 degree
	 public void CannonLeftRotate()
	 {
		 this.CannonAngle--;
		 this.repaint();
	 }
	 //rotate right 1 degree 
	 public void CannonRightRotate()
	 {
		 this.CannonAngle++;
		 this.repaint();
	 }
	
	 // function to shoot a bullet
	 public void ShootABullet()
	 {
		/*JLabel lab = new JLabel("bull");
		lab.setBounds(25, 27, 40, 40);
		
		this.add(lab);
		this.repaint();
		this.setComponentZOrder(lab, 0);
		this.repaint();
		System.out.println(this.getComponentZOrder(lab));*/
		 this.showBullet = true;
		 /*while(bullYPos>50)
		 {
			 panelshowing = true;
			 bullYPos = bullYPos-5;
			 this.repaint();
			 while(panelshowing)
			 {
				 try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 }
		 }*/
		 System.out.println(1);
		 this.repaint();
		 System.out.println(2);
	 }
	 
	  public class MyKeyListener implements KeyListener {
		  PlayGroundPanel GameClass = null;
			public MyKeyListener(PlayGroundPanel gameclass)
			{
				this.GameClass = gameclass;	
				
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//JOptionPane.showMessageDialog(null,KeyEvent.getKeyText(e.getKeyCode()));
				
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Left" && GameClass != null)
				{
					//GameClass.MessageBox("Left Button");
					GameClass.CannonLeftRotate();
				}
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Right" && GameClass != null)
				{
					//GameClass.MessageBox("Right Button");
					GameClass.CannonRightRotate();
					//JOptionPane.showMessageDialog(null,"Right");
				}
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Shift" && GameClass != null)
				{
					//GameClass.MessageBox("Right Button");
					GameClass.ShootABullet();
					//JOptionPane.showMessageDialog(null,"Right");
				}
				
				//exit
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Escape" && GameClass != null)
				{
					System.exit(0);

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			}
		}
	 
	 
}
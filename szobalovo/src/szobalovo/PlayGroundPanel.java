package szobalovo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.*;
/*
 * class to implement the moving objects of the game
 */
public class PlayGroundPanel extends JPanel {

	public static int CannonWidth  = 124; // in px
	public static int CannongHeight  = 160; // in px
	private static final long serialVersionUID = 1L;
	//images
	BufferedImage cannonimage, backgroundimage;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	// the coordinates of the cannon
	int cannonCenterXKoord = 0;
    int cannonCenterYKoord = 0;
    public int CannonAngle = 0;
    private boolean showBullet = false;
    private int bullXpos = 0, bullYPos = 0, bullDeld = 20;
    // if the bullet is reach the end of the playground necessary to inverse the direction of the X koord
    private int IsXkoordAngle = 0;
    // instance of the frame class
    PlayGround playG;
    // string to store the selected character
    private String currBullChar = "%";
    // size of the shooted character
    private int ShootedCharSize = 16;
    //deflection of the cannon per clickk
    private int cannonDeflection = 2;
	public PlayGroundPanel(PlayGround playG)
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
				this.playG = playG;
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
        // show the bullet
        if(showBullet)
        {
        	double XKoordAngl = Math.toRadians (IsXkoordAngle);
        	bullXpos = bullXpos + (int)(bullDeld*Math.sin(XKoordAngl));
        	if(bullXpos <5 || bullXpos >this.getWidth()-5)
        	{
        		IsXkoordAngle = IsXkoordAngle*-1;
        	}
        	//System.out.println(bullYPos + "  elotte   szog  " + rotationRequired);
        	bullYPos = bullYPos - (int)(bullDeld*Math.cos(rotationRequired));
        	//System.out.println(bullYPos + "  utana");
	        Graphics2D bull = (Graphics2D) g;
	        // shoot the selected character
	        bull.setFont(new Font( "SansSerif", Font.BOLD, ShootedCharSize));
	        bull.drawString(currBullChar, bullXpos, bullYPos);
	        //shoot an oval bullet
	        //bull.fillOval(bullXpos, bullYPos, 10, 10);
	       // panelshowing=false;
	       // bullYPos = bullYPos-50;
        try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /**Collision detection**/
        // necessary to check the y koordinates
        if(bullYPos<290 && bullYPos>270)
        {
        	int YposState = playG.checkSlammingBullet(4, bullXpos);
        
        	if(YposState>0)
        	{
        	//stop the bullet
        	showBullet = false;
        	if(YposState <2)
        	{
        		playG.changeEnteredChar(4, bullXpos);
        	}
        	this.repaint();
        	}
        	else
        	{
        		this.repaint();
        	}
        }
        else if(bullYPos<240 && bullYPos>220)
        {
        	
        	int YposState = playG.checkSlammingBullet(3, bullXpos);
        	if(YposState>0)
        	{
        	//stop the bullet
        	showBullet = false;
        	if(YposState <2)
        	{
        		playG.changeEnteredChar(3, bullXpos);
        	}
        	this.repaint();
        	}
        	else
        	{
        		this.repaint();
        	}
        }
        else if(bullYPos<190 && bullYPos>170)
        {
        	int YposState = playG.checkSlammingBullet(2, bullXpos);
        	if(YposState>0)
        	{
        	//stop the bullet
        	showBullet = false;
        	if(YposState<2)
        	{
        		playG.changeEnteredChar(2, bullXpos);
        	}
        	this.repaint();
        	}
        	else
        	{
        		this.repaint();
        	}
        }
        else  if(bullYPos<140 && bullYPos>120)
        {
        	int YposState = playG.checkSlammingBullet(1, bullXpos);
        	if(YposState>0)
        	{
        	//stop the bullet
        	showBullet = false;
        	if(YposState<2)
        	{
        		playG.changeEnteredChar(1, bullXpos);
        	}
        	this.repaint();
        	}
        	else
        	{
        		this.repaint();
        	}
        }
        // the first row
        else if(bullYPos<90 && bullYPos>70)
        {
        	int YposState = playG.checkSlammingBullet(0, bullXpos);
        	if(YposState>0)
        	{
        	//stop the bullet
        	showBullet = false;
        	if(YposState<2)
        	{
        		playG.changeEnteredChar(0, bullXpos);
        	}
        	this.repaint();
        	}
        	else
        	{
        		this.repaint();
        	}
        }
	    
        else if(bullYPos>50)
	        {
	        	this.repaint();
	        	//stop the bullet
	        }
	    else
	        {
	        	showBullet = false;
	        	this.repaint();
	        	
	        }
        
        
        }

	 }
	 
	 // functions which are responsible the rotate of the cannon
	 //rotate left 1 degree
	 public void CannonLeftRotate()
	 { if(CannonAngle> -(89-cannonDeflection))
	 {
		 this.CannonAngle =this.CannonAngle - cannonDeflection ;
		 this.repaint();
	 }
	 }
	 //rotate right 1 degree 
	 public void CannonRightRotate()
	 {
		 if(CannonAngle< 89-cannonDeflection)
		 {
		 this.CannonAngle=this.CannonAngle + cannonDeflection ;
		 this.repaint();
		 }
	 }
	
	 // function to shoot a bullet
	 public void ShootABullet()
	 {
		 if(!showBullet)
		 {
			 try
			 {
			 //Sound
			 
			 Sound.Shoot.play();
			 // get the currentlx selected character to shoot it

			 this.currBullChar= playG.getCurrentCharToShoot();
			 // the initial value of the bullet
			bullXpos=this.getWidth()/2 - 5; // need a little offset
	        bullYPos = this.getHeight() - CannongHeight/2 + 10;
	        IsXkoordAngle  = CannonAngle;
	        this.showBullet = true;
	        this.repaint();
			 }
			 catch(Exception e)
			 {
				 JOptionPane.showMessageDialog(null, e.getMessage());
			 }
		 }
	 }
	 public void EndGame()
	 {
		 try
		 {
			 playG.EndofGame();
		 }
		 catch(Exception e)
		 {
			 
		 }
	 }
	 /*
	  * Class in connection with the audio extensions
	  * 
	  */
	 public static class Sound extends java.lang.Object{
		 // sound of thw shoot
	 public static  AudioClip Shoot = Applet.newAudioClip(Sound.class.getResource("/bamf.wav"));
	 // sound of the about gui
	 public static  AudioClip Cancan = Applet.newAudioClip(Sound.class.getResource("/cancan.wav"));
	 //sound of the menus
	 public static  AudioClip Abc = Applet.newAudioClip(Sound.class.getResource("/abc.wav"));
	 // sound of the successful shooting
	 public static  AudioClip Yeah = Applet.newAudioClip(Sound.class.getResource("/yeah.wav"));
	 //sound of the bad shooting
	 public static  AudioClip Bad = Applet.newAudioClip(Sound.class.getResource("/bad.wav"));
	 //sound of the applause
	 public static  AudioClip Applause = Applet.newAudioClip(Sound.class.getResource("/applause.wav"));
	 //background sound of the game
	 public static  AudioClip Cricket = Applet.newAudioClip(Sound.class.getResource("/cricket.wav"));
	 public static void dumbnoises()
	 {
		 // no better idea to stop the sound
		  Shoot = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));
		  Cancan = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));
		  Abc = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));
		  Yeah = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));
		  Bad = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));;
		  Applause = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));
		  Cricket = Applet.newAudioClip(Sound.class.getResource("/silence.wav"));
	 }	 
	 public static void releasenoises()
	 {
		 //release the sounds
		  	 Shoot = Applet.newAudioClip(Sound.class.getResource("/bamf.wav"));
		     Cancan = Applet.newAudioClip(Sound.class.getResource("/cancan.wav"));
		     Abc = Applet.newAudioClip(Sound.class.getResource("/abc.wav"));
		     Yeah = Applet.newAudioClip(Sound.class.getResource("/yeah.wav"));
		     Bad = Applet.newAudioClip(Sound.class.getResource("/bad.wav"));
		     Applause = Applet.newAudioClip(Sound.class.getResource("/applause.wav"));
		     Cricket = Applet.newAudioClip(Sound.class.getResource("/cricket.wav"));
	 }
	 
	 }

	/*
	 * key listener class to catch the button press
	 */
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
				
				
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Left" && GameClass != null)
				{
					//left button
					GameClass.CannonLeftRotate();
				}
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Right" && GameClass != null)
				{
					//right button
					GameClass.CannonRightRotate();
					
				}
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Space" && GameClass != null)
				{
					//Space button
					GameClass.ShootABullet();
					
				}
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Up" && GameClass != null)
				{
					//up button the shift the characters
					 playG.refCharList();
					

				}
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Ctrl" && GameClass != null)
				{
				}
				//getWordsFromEngine
				//exit
				if(KeyEvent.getKeyText(e.getKeyCode()) == "Escape" && GameClass != null)
				{
					GameClass.EndGame();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			}
		}
	 
	 
}
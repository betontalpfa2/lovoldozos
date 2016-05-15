package szobalovo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;

import javax.swing.JFrame;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.sun.media.jfxmedia.MediaPlayer;

import javafx.scene.shape.Line;
import szobalovo.PlayGroundPanel.Sound;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.LinkedList;

public class MainMenuGUI {

//	static Engine engine;
	private JFrame frame;
	IClient mainclient;
	PlayerSettings playerSettings;
	boolean IsSound = false;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		engine = new Engine();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainMenuGUI(IClient mainClient, PlayerSettings PlaySett) {
		this.mainclient = mainClient;
		mainclient.SetGameLevel(1);
		this.playerSettings = PlaySett;
		initialize();
		Sound.Abc.loop();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 391, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// border which is help to show the buttons
		Border GreyBorder = LineBorder.createGrayLineBorder();
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/MainMenubackgroundV.png")).getImage();
		
		JLabel ExitLabelButton = new JLabel("");
		ExitLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			Border OldBorderExit = ExitLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				
				ExitLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ExitLabelButton.setBorder(OldBorderExit);
			}
		});
		
		JLabel AboutLabelButton = new JLabel("");
		AboutLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AboutMenu();
			}
			Border OldBorderAbout = AboutLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				AboutLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AboutLabelButton.setBorder(OldBorderAbout);
			}
		});
		
		JLabel HighScoreLabelButton = new JLabel("");
		HighScoreLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HighScoreMenu();
			}
			Border OldBorderHighScore = HighScoreLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				HighScoreLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				HighScoreLabelButton.setBorder(OldBorderHighScore);
			}
		});
		
		JLabel SettingsLabelButton = new JLabel("");
		SettingsLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SettingsMenu();
			}
			Border OldBorderSettings = SettingsLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				SettingsLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SettingsLabelButton.setBorder(OldBorderSettings);
			}
		});
		
		JLabel MultiLabelButton = new JLabel("");
		MultiLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MultiPlayerStart();
			}
			Border OldBorderMulti = MultiLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				MultiLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				MultiLabelButton.setBorder(OldBorderMulti);
			}
			
		});
		
		JLabel SingleLabelButton = new JLabel("");
		SingleLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SinglePlayerStart();
			}
			Border OldBorderSingle = SingleLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				SingleLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SingleLabelButton.setBorder(OldBorderSingle);
			}
		});
		
		JLabel SoundLabButt = new JLabel("");
		SoundLabButt.addMouseListener(new MouseAdapter() {
			Border OldBorderSingle = SoundLabButt.getBorder();
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundButtonClicked(SoundLabButt);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SoundLabButt.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SoundLabButt.setBorder(OldBorderSingle);
			}
		});
		SoundLabButt.setBounds(176, 318, 39, 37);
		frame.getContentPane().add(SoundLabButt);
		SingleLabelButton.setBounds(25, 27, 187, 35);
		frame.getContentPane().add(SingleLabelButton);
		MultiLabelButton.setBounds(166, 79, 195, 35);
		frame.getContentPane().add(MultiLabelButton);
		SettingsLabelButton.setBounds(62, 138, 153, 43);
		frame.getContentPane().add(SettingsLabelButton);
		HighScoreLabelButton.setBounds(161, 200, 195, 43);
		frame.getContentPane().add(HighScoreLabelButton);
		AboutLabelButton.setBounds(87, 264, 131, 43);
		frame.getContentPane().add(AboutLabelButton);
		ExitLabelButton.setBounds(306, 329, 59, 26);
		frame.getContentPane().add(ExitLabelButton);
		label.setBounds(0, 0, 385, 379);
		label.setIcon(new ImageIcon(img.getScaledInstance(385, 379, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(label);
	}
	
	
	// Interface functions
	
	public void SinglePlayerStart()
	{
		try
		{
			//JOptionPane.showMessageDialog(null,"SignlePlayermenu");
			//JOptionPane.showMessageDialog(null,mainclient.getSettings().language.toString());
			 
			
				try {
					mainclient.initNewGame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Sound.Abc.stop();
			PlayGround newPlay = new PlayGround(true, mainclient, playerSettings, this);
			newPlay.CreatePlayGroundFrame();

			
		}
		finally
		{
		}
	}
	public void MultiPlayerStart()
	{
		try
		{
			JOptionPane.showMessageDialog(null,"Multiplayer menu");
		}
		finally
		{
		}
	}
	public void SettingsMenu()
	{
		try
		{
			new SettingsGUI(mainclient, playerSettings, this);
			
		}
		finally
		{
		}
	}
	public void HighScoreMenu()
	{
		try
		{
			setMenuVisibility(false);
			ScoresGUI scores = new ScoresGUI( mainclient,  playerSettings,  this, null);
			scores.showframe();
		}
		finally
		{
		}
	}
	public void AboutMenu()
	{
		try
		{
			new AboutMenuGUI();
		}
		finally
		{
		}
	}
	
	private void SoundButtonClicked(JLabel parent)
	{
		//IsSound
		try
		{
			if(IsSound)
			{
				// necessary to remove the sound
				Image img = new ImageIcon(this.getClass().getResource("/Xpics.png")).getImage();
				parent.setIcon(new ImageIcon(img.getScaledInstance(39, 37, Image.SCALE_DEFAULT)));
				IsSound = !IsSound;
				Sound.Abc.stop();
				Sound.dumbnoises();
				
			}
			else
			{
				parent.setIcon(null);
				Sound.releasenoises();
				Sound.Abc.loop();
				IsSound = !IsSound;
			}
		
		}
		catch(Exception e)
		{
			//do nothing
		}
	
	}
	public void setMenuVisibility(boolean isVisible)
	{
		try
		{ 
			if(isVisible)
			{
				Sound.Abc.stop();
				Sound.Abc.loop();
			}
			else
			{
				Sound.Abc.stop();	
			}
			this.frame.setVisible(isVisible);
		}
		catch(Exception e)
		{
			
		}
	}


}

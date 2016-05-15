package szobalovo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import szobalovo.PlayGroundPanel.Sound;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoresGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoresGUI window = new ScoresGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	IClient mainClient;
	PlayerSettings PlayerSettings;
	MainMenuGUI mainmenu;
	PlayGround playGround;
	JLabel allremain, allgreat, allbad, lastremain, lastbad, lastgreat;
	/**
	 * Create the application.
	 */
	public ScoresGUI(IClient mainClient, PlayerSettings PlayerSettings, MainMenuGUI mainmenu, PlayGround playGround) {
		this.mainClient = mainClient;
		this.PlayerSettings = PlayerSettings;
		this.mainmenu = mainmenu;
		this.playGround = playGround;
		initialize();
		refreshscores();
	}
	public void showframe()
	{
		//sound
		Sound.Applause.play();
		this.frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 434, 261);
		Image img = new ImageIcon(this.getClass().getResource("/scores.png")).getImage();
		 
		 JLabel CloseButton = new JLabel("");
		 CloseButton.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		//execute the close task
		 		if(playGround != null)
		 		{
		 			playGround.hidePlayGround();
		 		}
		 		mainmenu.setMenuVisibility(true);
		 		frame.setVisible(false);
		 	}
		 	Border GreyBorder = LineBorder.createGrayLineBorder();
		 	Border OldBorder = CloseButton.getBorder();
		 	@Override
		 	public void mouseEntered(MouseEvent e) {
		 		CloseButton.setBorder(GreyBorder);
		 	}
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		CloseButton.setBorder(OldBorder);
		 	}
		 });
		 CloseButton.setBounds(343, 225, 81, 26);
		 frame.getContentPane().add(CloseButton);
		
		 allremain = new JLabel("0");
		allremain.setFont(new Font("Calibri", Font.PLAIN, 20));
		allremain.setBounds(275, 225, 50, 26);
		frame.getContentPane().add(allremain);
		
		 allbad = new JLabel("0");
		allbad.setFont(new Font("Calibri", Font.PLAIN, 20));
		allbad.setBounds(275, 195, 50, 26);
		frame.getContentPane().add(allbad);
		
		 allgreat = new JLabel("0");
		allgreat.setFont(new Font("Calibri", Font.PLAIN, 20));
		allgreat.setBounds(275, 165, 50, 26);
		frame.getContentPane().add(allgreat);
		
		 lastremain = new JLabel("0");
		lastremain.setFont(new Font("Calibri", Font.PLAIN, 20));
		lastremain.setBounds(275, 104, 50, 26);
		frame.getContentPane().add(lastremain);
		
		 lastbad = new JLabel("0");
		lastbad.setFont(new Font("Calibri", Font.PLAIN, 20));
		lastbad.setBounds(275, 74, 50, 26);
		frame.getContentPane().add(lastbad);
		
		 lastgreat = new JLabel("0");
		lastgreat.setFont(new Font("Calibri", Font.PLAIN, 20));
		lastgreat.setBounds(275, 44, 50, 26);
		frame.getContentPane().add(lastgreat);
		lblNewLabel.setIcon(new ImageIcon(img.getScaledInstance(434,261, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(lblNewLabel);
	}
	// function to refresh the value of the scores
	private void refreshscores()
	{
		try{
		allremain.setText("" +mainClient.getMissedScores());
		allgreat.setText("" +mainClient.getHittedScores());
		allbad.setText("" +mainClient.getBadScores());
		lastremain.setText("" +mainClient.getLastMissedScores());
		lastbad.setText("" +mainClient.getLastBadScores());
		lastgreat.setText("" +mainClient.getLastHittedScores());
		}
		catch(Exception e)
		{
			
		}
	}
}

package szobalovo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class SettingsGUI {

	private JFrame frame;
	private JTextField PlayerName;
	String[] PossibleLanguages = { "English", "Hungarian"};
	private JLabel AboutLabelButton;
	private JLabel SaveBackLabelButton;
	private JTextField LevelOfGame;
	private JTextField TimeOfPlay;
	private JLabel GameTimeDown;
	private JLabel GameTimeUp;
	private int MaxGameLevel = 5;
	private int MinGameLevel = 1;
	private int MaxGameTime = 5;
	private int MinGameTime = 1;

	/**
	 * Create the application.
	 */
	public SettingsGUI() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Border GreyBorder = LineBorder.createGrayLineBorder();
		frame.setBounds(100, 100, 405, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel BackgroundLabel = new JLabel("");
		BackgroundLabel.setBounds(0, 0, 389, 379);
		Image img = new ImageIcon(this.getClass().getResource("/SettingsGUIbackground.png")).getImage();
		
		AboutLabelButton = new JLabel("");
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
		
		SaveBackLabelButton = new JLabel("");
		SaveBackLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// call the function which is the responsible to save the user settings
				SaveUserSettings();
				frame.setVisible(false);
			}
			Border OldBorderSaveBack = AboutLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				SaveBackLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SaveBackLabelButton.setBorder(OldBorderSaveBack);
			}
		});
		
		JLabel GameLevelUp = new JLabel("");
		GameLevelUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int GameLevelnum = Integer.parseInt(LevelOfGame.getText());
				if(GameLevelnum<MaxGameLevel)
				{
					LevelOfGame.setText(Integer.toString(GameLevelnum+1));
				}
			}
			Border OldBorderGLUp = GameLevelUp.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				GameLevelUp.setBorder(GreyBorder);
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				GameLevelUp.setBorder(OldBorderGLUp);
			}
		});
		
		GameTimeDown = new JLabel("");
		GameTimeDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Gametimenum = Integer.parseInt(TimeOfPlay.getText());
				if(Gametimenum>MinGameTime)
				{
					TimeOfPlay.setText(Integer.toString(Gametimenum-1));
				}
			}
			Border OldBorderGTDown = GameTimeDown.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				GameTimeDown.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				GameTimeDown.setBorder(OldBorderGTDown);
			}
		});
		
		GameTimeUp = new JLabel("");
		GameTimeUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Gametimenum = Integer.parseInt(TimeOfPlay.getText());
				if(Gametimenum<MaxGameTime)
				{
					TimeOfPlay.setText(Integer.toString(Gametimenum+1));
				}
			}
			Border OldBorderGTUp = GameLevelUp.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				GameTimeUp.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				GameTimeUp.setBorder(OldBorderGTUp);
			}
		});
		GameTimeUp.setBounds(325, 140, 39, 25);
		frame.getContentPane().add(GameTimeUp);
		GameTimeDown.setBounds(278, 140, 39, 25);
		frame.getContentPane().add(GameTimeDown);
		GameLevelUp.setBounds(102, 94, 39, 25);
		frame.getContentPane().add(GameLevelUp);
		
		JLabel GameLevelDown = new JLabel("");
		GameLevelDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int GameLevelnum = Integer.parseInt(LevelOfGame.getText());
				if(GameLevelnum>MinGameLevel)
				{
					LevelOfGame.setText(Integer.toString(GameLevelnum-1));
				}
			}
			Border OldBorderGLDown = GameLevelDown.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				GameLevelDown.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				GameLevelDown.setBorder(OldBorderGLDown);
			}
		});
		GameLevelDown.setBounds(56, 94, 39, 25);
		frame.getContentPane().add(GameLevelDown);
		
		TimeOfPlay = new JTextField();
		TimeOfPlay.setHorizontalAlignment(SwingConstants.CENTER);
		TimeOfPlay.setText("5");
		TimeOfPlay.setEditable(false);
		TimeOfPlay.setBounds(172, 144, 37, 21);
		frame.getContentPane().add(TimeOfPlay);
		TimeOfPlay.setColumns(10);
		
		LevelOfGame = new JTextField();
		LevelOfGame.setHorizontalAlignment(SwingConstants.CENTER);
		LevelOfGame.setText("1");
		LevelOfGame.setEditable(false);
		LevelOfGame.setBounds(170, 96, 37, 21);
		frame.getContentPane().add(LevelOfGame);
		LevelOfGame.setColumns(10);
		SaveBackLabelButton.setBounds(241, 335, 128, 31);
		frame.getContentPane().add(SaveBackLabelButton);
		AboutLabelButton.setBounds(87, 264, 134, 42);
		frame.getContentPane().add(AboutLabelButton);
		
		
		//String[] PossibleLanguages = { "English", "Hungarian"};
		JComboBox SelectLanguage = new JComboBox(PossibleLanguages);
		SelectLanguage.setBounds(74, 195, 134, 20);
		frame.getContentPane().add(SelectLanguage);
		
		PlayerName = new JTextField();
		PlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerName.setText("For example John");
		PlayerName.setBounds(170, 54, 128, 18);
		frame.getContentPane().add(PlayerName);
		PlayerName.setColumns(10);
		BackgroundLabel.setIcon(new ImageIcon(img.getScaledInstance(389, 379, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(BackgroundLabel);
	}
	// functions to represent as inteface
	public void AboutMenu()
	{
		try
		{
			AboutMenuGUI aboutmenu = new AboutMenuGUI();
		}
		finally
		{
		}
	}
	//
	
	public void SaveUserSettings()
	{
		try
		{
			// save the deatils which was setted by the user
		}
		finally
		{
		}
	}
}

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
import javax.swing.SwingConstants;
import szobalovo.GameSettings.Languages;

public class SettingsGUI {

	private JFrame frame;
	private JTextField playerName;
	String[] possibleLanguages = { "English", "Hungarian"};
	private JLabel aboutLabelButton;
	private JLabel saveBackLabelButton;
	private JTextField LevelOfGame;
	private JTextField timeOfPlay;
	private JLabel gameTimeDown;
	private JLabel gameTimeUp;
	private int maxGameLevel = 5;
	private int minGameLevel = 1;
	private int maxGameTime = 5;
	private int minGameTime = 1;
	JComboBox<Languages> selectLanguage;

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
		GameSettings settings = MainMenuGUI.engine.getSettings();
		frame = new JFrame();
		Border GreyBorder = LineBorder.createGrayLineBorder();
		frame.setBounds(100, 100, 405, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel BackgroundLabel = new JLabel("");
		BackgroundLabel.setBounds(0, 0, 389, 379);
		Image img = new ImageIcon(this.getClass().getResource("/SettingsGUIbackground.png")).getImage();
		
		/**
		 * ---------------------------------------------------------------------
		 * Setup: Player name box:
		 */
		playerName = new JTextField();
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setText(settings.playerName);
		playerName.setBounds(170, 54, 128, 18);
		frame.getContentPane().add(playerName);
		playerName.setColumns(10);

		/**
		 * ---------------------------------------------------------------------
		 * Setup: game level buttons
		 */
		JLabel GameLevelUp = new JLabel("");
		GameLevelUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int GameLevelnum = Integer.parseInt(LevelOfGame.getText());
				if(GameLevelnum<maxGameLevel)
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
		
		JLabel GameLevelDown = new JLabel("");
		GameLevelDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int GameLevelnum = Integer.parseInt(LevelOfGame.getText());
				if(GameLevelnum>minGameLevel)
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

		LevelOfGame = new JTextField();
		LevelOfGame.setHorizontalAlignment(SwingConstants.CENTER);
		LevelOfGame.setText("1");
		LevelOfGame.setEditable(false);
		LevelOfGame.setBounds(170, 96, 37, 21);
		frame.getContentPane().add(LevelOfGame);
		LevelOfGame.setColumns(10);
		
		/**
		 * ---------------------------------------------------------------------
		 * Setup: Time of round button
		 */
		gameTimeDown = new JLabel("");
		gameTimeDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Gametimenum = Integer.parseInt(timeOfPlay.getText());
				if(Gametimenum>minGameTime)
				{
					timeOfPlay.setText(Integer.toString(Gametimenum-1));
				}
			}
			Border OldBorderGTDown = gameTimeDown.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				gameTimeDown.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gameTimeDown.setBorder(OldBorderGTDown);
			}
		});
		
		gameTimeUp = new JLabel("");
		gameTimeUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Gametimenum = Integer.parseInt(timeOfPlay.getText());
				if(Gametimenum<maxGameTime)
				{
					timeOfPlay.setText(Integer.toString(Gametimenum+1));
				}
			}
			Border OldBorderGTUp = GameLevelUp.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				gameTimeUp.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gameTimeUp.setBorder(OldBorderGTUp);
			}
		});
		gameTimeUp.setBounds(325, 140, 39, 25);
		frame.getContentPane().add(gameTimeUp);
		gameTimeDown.setBounds(278, 140, 39, 25);
		frame.getContentPane().add(gameTimeDown);
		GameLevelUp.setBounds(102, 94, 39, 25);
		frame.getContentPane().add(GameLevelUp);
		
		timeOfPlay = new JTextField();
		timeOfPlay.setHorizontalAlignment(SwingConstants.CENTER);
		timeOfPlay.setText("5");
		timeOfPlay.setEditable(false);
		timeOfPlay.setBounds(172, 144, 37, 21);
		frame.getContentPane().add(timeOfPlay);
		timeOfPlay.setColumns(10);
		
		/**
		 * ---------------------------------------------------------------------
		 * Setup: Languages choose
		 */
		selectLanguage = new JComboBox<Languages>(Languages.values());
		selectLanguage.setBounds(74, 195, 134, 20);
		selectLanguage.setSelectedItem(settings.language);
		frame.getContentPane().add(selectLanguage);

		/**
		 * ---------------------------------------------------------------------
		 * Setup: About button
		 */
		aboutLabelButton = new JLabel("");
		aboutLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AboutMenu();
			}
			Border OldBorderAbout = aboutLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				aboutLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutLabelButton.setBorder(OldBorderAbout);
			}
		});
		aboutLabelButton.setBounds(87, 264, 134, 42);
		frame.getContentPane().add(aboutLabelButton);
		
		/**
		 * ---------------------------------------------------------------------
		 * Setup: Save and return to main menu button
		 */
		saveBackLabelButton = new JLabel("");
		saveBackLabelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// call the function which is the responsible to save the user settings
				SaveUserSettings();
				frame.setVisible(false);
			}
			Border OldBorderSaveBack = aboutLabelButton.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				saveBackLabelButton.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				saveBackLabelButton.setBorder(OldBorderSaveBack);
			}
		});
		saveBackLabelButton.setBounds(241, 335, 128, 31);
		frame.getContentPane().add(saveBackLabelButton);
		BackgroundLabel.setIcon(new ImageIcon(img.getScaledInstance(389, 379, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(BackgroundLabel);
		
	}
	// functions to represent as inteface
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
	//
	
	public void SaveUserSettings()
	{
		try
		{
			GameSettings settings = MainMenuGUI.engine.getSettings();
			settings.playerName = playerName.getText();
			settings.language = (Languages)(selectLanguage.getSelectedItem());
			
		}
		finally
		{
		}
	}
}

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

public class SettingsGUI {

	private JFrame frame;
	private JTextField PlayerName;
	String[] PossibleLanguages = { "English", "Hungarian"};
	private JLabel AboutLabelButton;
	private JLabel SaveBackLabelButton;

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
		SaveBackLabelButton.setBounds(241, 335, 128, 31);
		frame.getContentPane().add(SaveBackLabelButton);
		AboutLabelButton.setBounds(87, 264, 134, 42);
		frame.getContentPane().add(AboutLabelButton);
		
		
		//String[] PossibleLanguages = { "English", "Hungarian"};
		JComboBox SelectLanguage = new JComboBox(PossibleLanguages);
		SelectLanguage.setBounds(74, 195, 134, 20);
		frame.getContentPane().add(SelectLanguage);
		
		PlayerName = new JTextField();
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

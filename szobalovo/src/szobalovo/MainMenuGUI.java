package szobalovo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javafx.scene.paint.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI window = new MainMenuGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuGUI() {
		initialize();
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
		Image img = new ImageIcon(this.getClass().getResource("/MainMenubackground.png")).getImage();
		
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
			JOptionPane.showMessageDialog(null,"SignlePlayermenu");
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
			SettingsGUI SeetingMenu = new SettingsGUI();
			
		}
		finally
		{
		}
	}
	public void HighScoreMenu()
	{
		try
		{
			JOptionPane.showMessageDialog(null,"HighScore menu");
		}
		finally
		{
		}
	}
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
}
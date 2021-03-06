package szobalovo;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import szobalovo.PlayGroundPanel.Sound;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Class to add information about the softver developer
 */
public class AboutMenuGUI {

	private JFrame frame;
	Border GreyBorder = LineBorder.createGrayLineBorder();


	/**
	 * Create the application.
	 */
	public AboutMenuGUI() {
		Sound.Abc.stop();
		Sound.Cancan.loop();
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel ExitAboutLabButt = new JLabel("");
		ExitAboutLabButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.Cancan.stop();
				Sound.Abc.loop();
				frame.setVisible(false);
			}
			Border defaultborder = ExitAboutLabButt.getBorder();
			@Override
			public void mouseEntered(MouseEvent e) {
				ExitAboutLabButt.setBorder(GreyBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ExitAboutLabButt.setBorder(defaultborder);
			}
		});
		ExitAboutLabButt.setBounds(338, 264, 63, 22);
		Image img = new ImageIcon(this.getClass().getResource("/ExitButton.png")).getImage();
		
		JLabel canlab = new JLabel("");
		canlab.setBounds(235, 52, 199, 182);
		// add gif to keep the use happy
		Image imgcan = new ImageIcon(this.getClass().getResource("/cancang.gif")).getImage();
		canlab.setIcon(new ImageIcon(imgcan.getScaledInstance(199, 182, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(canlab);
		ExitAboutLabButt.setIcon(new ImageIcon(img.getScaledInstance(63, 22, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(ExitAboutLabButt);
		
		JLabel lblAboutTheAuthors = new JLabel("<html><h3>The authors:</h3><h4>Racz Benedek Gyorgy(AQAEFR)</h4><h4>Oliver Bitay(R5R1I5)</h4><h4>Hencz Andras(IWQKZW)</h4><h3>Konzulens:</h3><h4>Gyorke Peter</h4><br></html>", SwingConstants.LEFT);
		lblAboutTheAuthors.setVerticalAlignment(SwingConstants.TOP);
		lblAboutTheAuthors.setBounds(25, 31, 323, 222);
		frame.getContentPane().add(lblAboutTheAuthors);
	}
}

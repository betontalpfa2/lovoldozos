package szobalovo;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import szobalovo.PlayGround;

public class PlayGround extends JPanel{
	IClient mainClient;
	private static int FrameWidth = 600;
	private static int FrameHeight = 700;
	boolean isVisible = false;
	// frame to paint the things
	private static final long serialVersionUID = 1L;
	// gui component of playground
	private JFrame pgframe = new JFrame();
    private JLayeredPane pglpane = new JLayeredPane();
    private JPanel marginPanel = new JPanel();
    private JPanel labPan_1 = new JPanel();
    JLabel wordLab_1= new JLabel("BNANA");
    // the PlayGroundPanel contains the  
    private PlayGroundPanel pgpanel = new PlayGroundPanel(this);
    //lis to contains the characters to shoot
    String[] charsToShoot = new String[6];
    //labels to show the chars
    JLabel nextChar_1 = new JLabel("_");
    JLabel nextChar_2 = new JLabel("_");
    JLabel nextChar_3 = new JLabel("_");
    JLabel nextChar_4 = new JLabel("_");
    JLabel nextChar_5 = new JLabel("_");
    JLabel currChar_6 = new JLabel("_");
    JPanel CharPanel = new JPanel();
    
    // integer to store the margin width
    private int wordMargin = 20;
    private int charWidth = 20;
    List<String> myWordList;
	List<JLabel> wordLabelList;
 // matrix to store the words
    // one item of the matrixPl. 312 meaning: the third character of the 12th word. the index of the first character is 1!
    // the maximum number of rows is 5 and one the maximum wors length is 9.
    int[][] wordmatrix = new int[5][30]; 
    
    
	public PlayGround(boolean isVisible, IClient mainClient, PlayerSettings playerSettings)
	{
		this.mainClient = mainClient;
		this.isVisible =isVisible;
	}
	public void CreatePlayGroundFrame()
	{
		pgframe.setPreferredSize(new Dimension(FrameWidth + 6, FrameHeight));
		pgframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pgframe.setResizable(false);
		pgframe.setLayout(new BorderLayout());
		pgframe.add(pglpane, BorderLayout.CENTER);
		pglpane.setBounds(0, 0, FrameWidth, FrameHeight);
		marginPanel.setBackground(Color.gray);
		marginPanel.setBounds(0, 0, FrameWidth, FrameHeight);
		marginPanel.setOpaque(true);
		pgpanel.setBounds(0, 0, FrameWidth, FrameHeight - 100);
		pgpanel.setOpaque(true);
		
		/*labPan_1.setBounds(50, 60, 50, 20);
		labPan_1.setOpaque(false);
		labPan_1.add(wordLab_1);*/
		pglpane.add(marginPanel, new Integer(0), 0);
		pglpane.add(pgpanel, new Integer(1), 0);
		//pglpane.add(labPan_1, new Integer(2), 0);

		pgframe.pack();
        pgframe.setVisible(true);
        this.DrawCharLabels();
        // characters
        this.refCharList();
        //words
        this.getWordsFromEngine();
        
	}
	//function to draw the nextchar labels
	private void DrawCharLabels()
	{
		 Color borderColor = new Color(102, 51, 1);
		 nextChar_1.setBorder(BorderFactory.createLineBorder(borderColor, 3));
		 nextChar_1.setHorizontalAlignment(SwingConstants.CENTER);
		 nextChar_1.setVerticalAlignment(SwingConstants.CENTER);
		 nextChar_1.setFont(new Font(nextChar_1.getFont().getName(), Font.PLAIN, (int)(nextChar_1.getFont().getSize()*1.5)));
		 
		 nextChar_2.setBorder(BorderFactory.createLineBorder(borderColor, 3));
		 nextChar_2.setHorizontalAlignment(SwingConstants.CENTER);
		 nextChar_2.setVerticalAlignment(SwingConstants.CENTER);
		 nextChar_2.setFont(new Font(nextChar_2.getFont().getName(), Font.PLAIN, (int)(nextChar_2.getFont().getSize()*1.5)));
		 
		 nextChar_3.setBorder(BorderFactory.createLineBorder(borderColor, 3));
		 nextChar_3.setHorizontalAlignment(SwingConstants.CENTER);
		 nextChar_3.setVerticalAlignment(SwingConstants.CENTER);
		 nextChar_3.setFont(new Font(nextChar_3.getFont().getName(), Font.PLAIN, (int)(nextChar_3.getFont().getSize()*1.5)));
		
		 nextChar_4.setBorder(BorderFactory.createLineBorder(borderColor, 3));
		 nextChar_4.setHorizontalAlignment(SwingConstants.CENTER);
		 nextChar_4.setVerticalAlignment(SwingConstants.CENTER);
		 nextChar_4.setFont(new Font(nextChar_4.getFont().getName(), Font.PLAIN, (int)(nextChar_4.getFont().getSize()*1.5)));
		 
		 nextChar_5.setBorder(BorderFactory.createLineBorder(borderColor, 3));
		 nextChar_5.setHorizontalAlignment(SwingConstants.CENTER);
		 nextChar_5.setVerticalAlignment(SwingConstants.CENTER);
		 nextChar_5.setFont(new Font(nextChar_5.getFont().getName(), Font.PLAIN, (int)(nextChar_5.getFont().getSize()*1.5)));
		 
		 currChar_6.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		 currChar_6.setHorizontalAlignment(SwingConstants.CENTER);
		 currChar_6.setVerticalAlignment(SwingConstants.CENTER);
		 currChar_6.setFont(new Font(currChar_6.getFont().getName(), Font.PLAIN, (int)(currChar_6.getFont().getSize()*1.5)));
		 
		 CharPanel.setBounds(0, FrameHeight - 100, FrameWidth, 71);
		 CharPanel.setBackground(Color.GRAY);
		 CharPanel.setOpaque(true);
		 CharPanel.setLayout(null);
		 //add nextChar_1
		 CharPanel.add(nextChar_1);
		 nextChar_1.setBounds(10, 20, 30,30);
		//add nextChar_2
		 CharPanel.add(nextChar_2);
		 nextChar_2.setBounds(50, 20, 30,30);
		//add nextChar_3
		 CharPanel.add(nextChar_3);
		 nextChar_3.setBounds(90, 20, 30,30);
		//add nextChar_4
		 CharPanel.add(nextChar_4);
		 nextChar_4.setBounds(130, 20, 30,30);
		//add nextChar_5
		 CharPanel.add(nextChar_5);
		 nextChar_5.setBounds(170, 20, 30,30);
		//add currChar_6
		 CharPanel.add(currChar_6);
		 currChar_6.setBounds(FrameWidth/2-15, 20, 30,30);
		 
		 pglpane.add(CharPanel, new Integer(3), 0);
	}

	// function to fulfill the charsToShoot list with random chars, or shift it and add a new random character 
	//to the end of the list. The function returns with false if the program throws an exception otherwise false
	public boolean refCharList()
	{
	try
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		 Random r = new Random();
		if(charsToShoot[0] == null)
		{
			// necessary to fulfill the whole list. The list has to contain  6 elements
			// the last element is always the current one
			for(int i =  0; i<6; i++)
			{
				charsToShoot[i] =Character.toString(alphabet.charAt(r.nextInt(alphabet.length())));
			}
		}
		else
		{
			//shift the caracters and add a new to the end of the list
			for(int i = 5; i> 0; i--)
			{
				charsToShoot[i] = charsToShoot[i-1];
			}
			// new character into the end of the array
			charsToShoot[0] = Character.toString(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		// appear the characters
		nextChar_1.setText(charsToShoot[0]);
		nextChar_2.setText(charsToShoot[1]);
		nextChar_3.setText(charsToShoot[2]);
		nextChar_4.setText(charsToShoot[3]);
		nextChar_5.setText(charsToShoot[4]);
		currChar_6.setText(charsToShoot[5]);
		
		return true;	
	}
	catch(Exception e){
		  return false;
		}
	}
	// function to get the words from the engine
	public void getWordsFromEngine()
	{
		// initialize the matrix which is represent the playground 
		for(int i =0 ; i<5; i++)
		{
			for(int j =0 ; j<28; j++)
			{
				wordmatrix[i][j] = 0; // set all element of the wordmatrix to 0
			}
		}
		drawmatrix();
		myWordList = mainClient.getCloudWords();
		wordLabelList = new ArrayList<JLabel>();
		//create labels based on the words from the motor
		for(int i = 0; i < myWordList.size(); i++)
		{
			// set the encoding the UTF-8 is not okay!!!!
			byte ptext[] = myWordList.get(i).getBytes();
			String currLabText= "";
			try {
				
			 currLabText = new String(ptext, "UTF-8"); 
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//JLabel currLab  = new JLabel(myWordList.get(i));
			JLabel currLab  = new JLabel(currLabText);
			currLab.setBorder(BorderFactory.createLineBorder(Color.black, 2));	
			currLab.setHorizontalAlignment(SwingConstants.CENTER);
			currLab.setVerticalAlignment(SwingConstants.CENTER);
			//currLab.Enc
			currLab.setFont(new Font(currLab.getFont().getName(), Font.PLAIN, (int)(currLab.getFont().getSize()*2.6)));
			wordLabelList.add(currLab);
			
		}
		labPan_1.setBounds(0, 50, FrameWidth, 300);
		labPan_1.setOpaque(false);
		labPan_1.setLayout(null);
		int wordXLoc =wordMargin, wordYLoc = 0; 
		int rowindex = 0;
		int columnindex = 1;// because the first is 
		for(int j = 0; j< wordLabelList.size(); j++)
		{
			JLabel currLab = wordLabelList.get(j);
			labPan_1.add(currLab);
			currLab.setBounds(wordXLoc, wordYLoc, currLab.getText().length()*charWidth, 40);
			// put the word to the wordmatrix
			for(int z=1; z<= currLab.getText().length(); z++)
			{
			wordmatrix[rowindex][columnindex] = (j+1)*10+z;
			columnindex++;//iterate of the columnindex
			}
			if(j != wordLabelList.size()-1)
			{
			wordXLoc += currLab.getText().length()*charWidth + charWidth; // + one separate character
			columnindex++;
			if(wordXLoc > FrameWidth - wordLabelList.get(j+1).getText().length()*charWidth-wordMargin)
			{
				wordXLoc = wordMargin;
				wordYLoc+= 50;
				columnindex=1;//return the begin of the row
				rowindex++;// one row below
			}
			}
			/*else if(j == wordLabelList.size()-1 && wordXLoc > FrameWidth-20)
			{
				wordXLoc = wordMargin;
				wordYLoc+= 60;
			 
			}*/
			
		}
		
		pglpane.add(labPan_1, new Integer(2), 0);
		System.out.println("");
		System.out.println("");
		drawmatrix();
		
	}
	//
	//function to detect the slamming bullet
	//row index parameter selects the actual row of matrix
	// it return true if the bullet hits a word otherwise false
	public boolean checkSlammingBullet(int rowindex, int Xkoord)
	{
	try
	{
		
		// calulate the column value Xkoord/20 lower whole num
		int calculatedColumIndex = (int)Math.floor(Xkoord/20);
		if(wordmatrix[rowindex][calculatedColumIndex]>0)
		{
		return true;
		}
		else
		{
			return false;
		}
	}
	catch(Exception e)
	{
		return false;
	}
	
	}
	
	//function to change the entered character 
	public void changeEnteredChar(int rowindex, int Xkoord)
	{
	try
	{
		
		// calulate the column value Xkoord/20 lower whole num
		int calculatedColumIndex = (int)Math.floor(Xkoord/20);
		int wordIndex = (int)Math.floor(wordmatrix[rowindex][calculatedColumIndex]/10)-1;
		int charIndex = wordmatrix[rowindex][calculatedColumIndex]%10;
		String currword = "";
		boolean ishitted = false;
		if(myWordList.size()>0)// if not empty the list
		{
			// get the word
			currword = myWordList.get(wordIndex);
			int _CharPos = currword.indexOf('_');
			if(_CharPos == charIndex)
			{
				currword = currword.replace('_',currChar_6.getText().toCharArray()[0]);
				ishitted = true;
			}
		}
		if(currword != "" && wordLabelList.size()>0 && ishitted)
		{
			//checkword
			
		 wordLabelList.get(wordIndex).setText(currword /*"talal"*/);
		 if(mainClient.checkword(currword))
		 {
			 wordLabelList.get(wordIndex).setBorder(BorderFactory.createLineBorder(Color.green, 2));	
		 }
		 else
		 {
			 wordLabelList.get(wordIndex).setBorder(BorderFactory.createLineBorder(Color.red, 2));
		 }
		 ishitted = false;
		}
		
		
	}
	catch(Exception e)
	{
		//do nothing
	}
	
	}
	
	//function to add the selected current character to shoot it:)
	public String getCurrentCharToShoot()
	{
		try
		{
			return this.currChar_6.getText();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	private void drawmatrix()
	{
		for(int i =0; i<5; i++)
		{
			String row = "";
			for(int j=0; j<28; j++)
			{
				row= row+ wordmatrix[i][j] + ";";
			}
			System.out.println(row);
		}
	}
	
  
}

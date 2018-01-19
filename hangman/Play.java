package hangman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Play extends JFrame implements ActionListener{
	JPanel alphabet, container, image, word, filler, right, bottom, nothing, text;
	String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	JButton space1, space2, space3, space4, space5, space6;
	JLabel chose;
	Game game;
	String currentWord;
	JButton[] spaces;
	JButton[] alph;

	drawHangman hangman;
	public Play(Game game) {
		this.game = game;
		this.hangman = new drawHangman();

		
		//currentWord = this.game.getCurrentWord();
		currentWord = this.game.getCurrentWord();
		Font font1 = new Font("SansSerif", Font.PLAIN, 20);
		this.setLayout(new GridLayout(2, 1));
		this.setPreferredSize(new Dimension(1200,800));
		
		container = new JPanel();
		container.setLayout(new FlowLayout());
		container.setPreferredSize(new Dimension(1100,800));
		this.add(container);
		
		/*image = new JPanel();
		image.setBackground(Color.white);
		image.setPreferredSize(new Dimension(350,600));*/
		
		container.add(this.hangman);
		
		right = new JPanel();
		right.setPreferredSize(new Dimension(750, 600));
		container.add(right);
		
		filler = new JPanel();
		filler.setLayout(new GridLayout(2,1));
		filler.setPreferredSize(new Dimension(750, 150));
		right.add(filler);
		nothing = new JPanel();
		filler.add(nothing);
		text = new JPanel();
		filler.add(text);
		chose = new JLabel("Guess a letter.");
		chose.setFont(font1);
		
		text.add(chose);
		
		
		word = new JPanel();
		word.setPreferredSize(new Dimension(750, 600));
		word.setLayout(new FlowLayout());
		
		spaces = new JButton[currentWord.length()];
		
		space1 = new JButton("-");
		space1.setPreferredSize(new Dimension(55, 55));
		space1.setBackground(Color.white);
		spaces[0] = space1;
		space1.setFont(font1);
		space1.setFocusPainted(false);
		word.add(space1);
		
		space2 = new JButton("-");
		space2.setPreferredSize(new Dimension(55, 55));
		space2.setBackground(Color.white);
		spaces[1] = space2;
		space2.setFont(font1);
		space2.setFocusPainted(false);
		word.add(space2);
		
		space3 = new JButton("-");
		space3.setPreferredSize(new Dimension(55, 55));
		space3.setBackground(Color.white);
		spaces[2] = space3;
		space3.setFont(font1);
		space3.setFocusPainted(false);
		word.add(space3);
		
		space4 = new JButton("-");
		space4.setPreferredSize(new Dimension(55, 55));
		space4.setBackground(Color.white);
		spaces[3] = space4;
		space4.setFont(font1);
		space4.setFocusPainted(false);
		word.add(space4);
		
		space5 = new JButton("-");
		space5.setPreferredSize(new Dimension(55, 55));
		space5.setBackground(Color.white);
		spaces[4] = space5;
		space5.setFont(font1);
		space5.setFocusPainted(false);
		word.add(space5);
		
		space6 = new JButton("-");
		space6.setPreferredSize(new Dimension(55, 55));
		space6.setBackground(Color.white);
		spaces[5] = space6;
		space6.setFont(font1);
		space6.setFocusPainted(false);
		word.add(space6);
		
		
		
		right.add(word);
		
		bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(1100, 200));
		
		alphabet = new JPanel();
		alphabet.setLayout(new GridLayout(2, 13));
	    alphabet.setPreferredSize(new Dimension(1100, 200));
		//alphabet.setSize(new Dimension(1100, 300));
		alph = new JButton[25];
		int i = 0;
		while (i < 25) {
			JButton letter = new JButton(letters[i]);
			letter.setFocusPainted(false);
			letter.setFont(font1);
			letter.setBackground(Color.WHITE);
			letter.addActionListener(this);
			alph[i]=letter;
			alphabet.add(letter);
			i++;
		}
		bottom.add(alphabet);
		this.add(bottom);
		
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean correctLetter = false;

		((JButton) e.getSource()).setEnabled(false);
		((JButton) e.getSource()).setBackground(Color.darkGray);
		for (int i = 0; i < currentWord.length(); i++) {
			if(e.getActionCommand().equals(String.valueOf(currentWord.charAt(i)))) {
				spaces[i].setText(e.getActionCommand());
				correctLetter = true;
				this.game.rightLetter();

			}
		}
		if (correctLetter == false) {
			this.game.wrongLetter();
			this.hangman.drawPart();
			System.out.println(this.game.getWrongMoves());
			if (this.game.checkTries()) {
				chose.setText("You Lost :( ");
				for (int j = 0; j < 25; j++) {
					alph[j].setBackground(Color.BLACK);
					alph[j].setEnabled(false);
				}
				//lost game
			}
		}else if (correctLetter == true) {
			System.out.println("yes");
			if (this.game.checkWin()) {
				chose.setText("You Won! :D");
				for (int j = 0; j < 25; j++) {
					alph[j].setBackground(Color.pink);
					alph[j].setEnabled(false);
				}
			}
		}
		
		
	}

}

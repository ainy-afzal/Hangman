package hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Game extends JFrame {
	private Welcome welcome;
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}
	
	String[] level1 = {"ONLINE", "PARKER"};
	String[] level2 = {"POLICE", "RANDOM"};
	String[] level3 = {"ZEBRAS", "YAWNED"};
	String word;
	int counter;
	int guessedCorrect;
	private int guessesRemaining = 6;

	public Game() {
		welcome = new Welcome(this);
		word = "NOTICE";
		counter = 0;
		guessedCorrect = 0;

	}
	public void set_level(int level) {
		int randomNum = 0 + (int)(Math.random() * 1); 
		if (level == 1) {
			word = level1[randomNum];
		}else if (level == 2) {
			word = level2[randomNum];
		}else if (level == 3) {
			word = level3[randomNum];
		}	
	}
	public String getCurrentWord() {
		return word;
	}
	public int getWrongMoves() {
		return counter;
	}
	public void wrongLetter() {
		counter++;
	}
	public void rightLetter() {
		guessedCorrect++;
	}
	public boolean checkTries() {
		if (counter == 10) {
			return true;
		}
		return false;
	}
	public boolean checkWin() {
		if ((counter < 10) && (guessedCorrect == word.length()) ) {
			return true;
		}
		return false;
	}
	


	
	

	

}

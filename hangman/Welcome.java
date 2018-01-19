package hangman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Welcome extends JFrame implements ActionListener{
	JButton easy, med, hard;
	Play play;
	Game game;
	String currentWord;
	
	public Welcome(Game game) {
		this.game = game;
		Font font1 = new Font("SansSerif", Font.BOLD, 80);
		this.setLayout(new GridLayout(3, 1));
		this.setPreferredSize(new Dimension(800,800));
		
		
		easy = new JButton("Easy");
		easy.setFont(font1);
		easy.setBackground(Color.white);
		easy.addActionListener(this);
		this.add(easy);
		
		med = new JButton("Medium");
		med.setFont(font1);
		med.setBackground(Color.white);
		med.addActionListener(this);
		this.add(med);
		
		hard = new JButton("Hard");
		hard.setFont(font1);
		hard.setBackground(Color.white);
		hard.addActionListener(this);
		this.add(hard);
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Easy")) {
			this.game.set_level(1);
		}else if (e.getActionCommand().equals("Medium")) {
			this.game.set_level(2);
			
		}else if (e.getActionCommand().equals("Hard")) {
			this.game.set_level(3);
			
		}
		this.dispose();
		
		new Play(this.game);
		//play.setVisible(true);
		
		
		
		
		
	}

}

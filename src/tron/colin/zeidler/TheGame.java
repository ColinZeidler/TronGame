package tron.colin.zeidler;

import javax.swing.JFrame;

public class TheGame extends JFrame{
	public TheGame(String string) {
		super(string);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setResizable(false);
	}

	public static void main(String[] args) {
		TheGame frame;
		
		frame = new TheGame("Tron Launcher");
		frame.setVisible(true);
		new Window(500, 500);

	}

}

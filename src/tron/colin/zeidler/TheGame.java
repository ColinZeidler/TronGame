package tron.colin.zeidler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TheGame extends JFrame implements ActionListener {
	static TheGame frame;

	public TheGame(String string) {
		super(string);
		System.out.println("This is Luke's");

		getContentPane().setLayout(null);

		JButton launch = new JButton("Launch Game");
		launch.setSize(120, 30);
		launch.setLocation(10, 10);
		launch.addActionListener(this);
		getContentPane().add(launch);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setResizable(false);

	}

	public static void main(String[] args) {

		frame = new TheGame("Tron Launcher");
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String act = action.getActionCommand();
		if (act == "Launch Game") {
			new Window(500, 500);
			frame.setVisible(false);
		}

	}

}

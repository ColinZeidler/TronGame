package tron.colin.zeidler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class TheGame extends JFrame implements ActionListener {
	
	
	
	static TheGame frame;
	int numPlayersChosen = 2;

	JButton launch;
	JRadioButton[] pButtons;

	public TheGame(String string) {
		super(string);

		getContentPane().setLayout(null);

		ButtonGroup playerNum = new ButtonGroup();
		pButtons = new JRadioButton[3];
		String[] pButtonLabels = { "2 Player", "3 PLayer", "4 Player" };

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				pButtons[i] = new JRadioButton(pButtonLabels[i], true);
			} else {
				pButtons[i] = new JRadioButton(pButtonLabels[i], false);
			}
			pButtons[i].setLocation(10, 10 + i * 20);
			pButtons[i].setSize(200, 20);
			getContentPane().add(pButtons[i]);
			playerNum.add(pButtons[i]);
			pButtons[i].addActionListener(this);
		}

		launch = new JButton("Launch Game");
		launch.setSize(120, 30);
		launch.setLocation(40, 80);
		launch.addActionListener(this);
		getContentPane().add(launch);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 150);
		setLocation(200, 200);
		setResizable(false);

	}

	public static void main(String[] args) {

		frame = new TheGame("Launcher");
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String act = action.getActionCommand();
		if (act == "Launch Game") {
			new Window(500, 500, numPlayersChosen);
			frame.setVisible(false);
		} else {
			// Find the number of the button that was clicked
			int buttonNumber = 0;
			for (buttonNumber = 0; buttonNumber < 3; buttonNumber++) {
				if (pButtons[buttonNumber] == action.getSource())
					break;
			}
			// set player number
			switch (buttonNumber) {
			case 0:
				numPlayersChosen = 2;
				break;
			case 1:
				numPlayersChosen = 3;
				break;
			case 2:
				numPlayersChosen = 4;
				break;
			}
		}

	}

}

package tron.colin.zeidler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TheGame extends JFrame implements ActionListener {
	static TheGame frame;
	int numPlayersChosen = 2;
	boolean keyToggle = false;

	JButton launch, rebind;
	JRadioButton[] pButtons;
	JTextField[][] bindings;
	
	JPanel keyPanel;

	public TheGame(String string) {
		super(string);

		getContentPane().setLayout(null);
		
		//radio buttons
		ButtonGroup playerNum = new ButtonGroup();
		pButtons = new JRadioButton[3];
		String[] pButtonLabels = { "2 Player", "3 PLayer", "4 Player" };

		for (int i = 0; i < 3; i++) { // creating player number selections
			if (i == 0) {
				pButtons[i] = new JRadioButton(pButtonLabels[i], true);
			} else {
				pButtons[i] = new JRadioButton(pButtonLabels[i], false);
			}
			pButtons[i].setLocation(10, 10 + i * 20);
			pButtons[i].setSize(150, 20);
			getContentPane().add(pButtons[i]);
			playerNum.add(pButtons[i]);
			pButtons[i].addActionListener(this);
		}
		
		//text fields for keybindings
		bindings = new JTextField[4][4];
		String[] bindingHeaders = {"1", "2", "3", "4"};
		String[] bindingLabels = {"Up", "Left", "Down", "Right"};
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
			}
		}
		
		// Button to launch the actual game
		launch = new JButton("Launch Game");
		launch.setSize(120, 30);
		launch.setLocation(40, 80);
		launch.addActionListener(this);
		getContentPane().add(launch);
		
		//Button to bring up key bindings
		rebind = new JButton("Edit Keys");
		rebind.setSize(120, 30);
		rebind.setLocation(40, 120);
		rebind.addActionListener(this);
		getContentPane().add(rebind);
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 190);
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
		} else if (act == "Edit Keys") {
			if(!keyToggle) {
				frame.setSize(400, 190);
				keyToggle = true;
			} else {
				frame.setSize(200, 190);
				keyToggle = false;
			}
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

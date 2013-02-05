package tron.colin.zeidler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TheGame extends JFrame implements ActionListener {
	static TheGame frame;
	int numPlayersChosen = 2;

	final String[][] controls = { { "W", "A", "S", "D" },
								{ "Up", "Left", "Down", "Right" }, 
								{ "U", "H", "J", "K" },
								{ "NumPad-8", "NumPad-4", "NumPad-5", "NumPad-6" } };

	JButton launch, rebindP1, rebindP2, rebindP3, rebindP4;
	JRadioButton[] pButtons;
	JTextField[][] bindings;
	JLabel[] bindingLabel, headerLabel;
	
	JPanel keyPanel, launcher;

	public TheGame(String string) {
		super(string);

		getContentPane().setLayout(null);
		keyPanel = new JPanel(null);
		keyPanel.setBorder(BorderFactory.createTitledBorder("Key bindings"));
		
		launcher = new JPanel(null);
		launcher.setBorder(BorderFactory.createTitledBorder("Launcher"));
		
		//radio buttons
		ButtonGroup playerNum = new ButtonGroup();
		pButtons = new JRadioButton[3];
		String[] pButtonLabels = { "2 Player", "3 Player", "4 Player" };

		for (int i = 0; i < 3; i++) { // creating player number selections
			if (i == 0) {
				pButtons[i] = new JRadioButton(pButtonLabels[i], true);
			} else {
				pButtons[i] = new JRadioButton(pButtonLabels[i], false);
			}
			pButtons[i].setLocation(10, 15 + i * 20);
			pButtons[i].setSize(80, 20);
			launcher.add(pButtons[i]);
			playerNum.add(pButtons[i]);
			pButtons[i].addActionListener(this);
		}
		
		//text fields for keybindings
		bindings = new JTextField[4][4];
		bindingLabel = new JLabel[4];
		headerLabel = new JLabel[4];
		String[] bindingHeaders = {"P1", "P2", "P3", "P4"};
		String[] bindingLabels = {"Up", "Left", "Down", "Right"};
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0 && i > 0) {
					bindingLabel[i-1] = new JLabel(bindingLabels[i-1]);
					bindingLabel[i-1].setLocation(10, 10 + i*20);
					bindingLabel[i-1].setSize(50, 20);
					keyPanel.add(bindingLabel[i-1]);
				} else if (j!= 0 && i == 0) {
					headerLabel[j-1] = new JLabel(bindingHeaders[j-1]);
					headerLabel[j-1].setLocation(10 + j*65, 10);
					headerLabel[j-1].setSize(65, 20);
					keyPanel.add(headerLabel[j-1]);
				} else if (j > 0 && i > 0){
					bindings[i-1][j-1] = new JTextField(controls[j-1][i-1]);
					bindings[i-1][j-1].setLocation(10 + j*65, 10 + i*20);
					bindings[i-1][j-1].setSize(65, 20);
					bindings[i-1][j-1].setEditable(false);
					keyPanel.add(bindings[i-1][j-1]);
				}
				
			}
		}
		
		// Button to launch the actual game
		launch = new JButton("Launch");
		launch.setSize(110, 30);
		launch.setLocation(10, 120);
		launch.addActionListener(this);
		launcher.add(launch);
		
		//Button to bring up key bindings
		rebindP1 = new JButton("P1");
		rebindP2 = new JButton("P2");
		rebindP3 = new JButton("P3");
		rebindP4 = new JButton("P4");
		//button positions
		rebindP1.setSize(65, 20);
		rebindP1.setLocation(75,110);
		rebindP1.addActionListener(this);
		rebindP2.setSize(65, 20);
		rebindP2.setLocation(140, 110);
		rebindP2.addActionListener(this);
		rebindP3.setSize(65, 20);
		rebindP3.setLocation(205, 110);
		rebindP3.addActionListener(this);
		rebindP4.setSize(65, 20);
		rebindP4.setLocation(270, 110);
		rebindP4.addActionListener(this);
		//add buttons to panel
		keyPanel.add(rebindP1);
		keyPanel.add(rebindP2);
		keyPanel.add(rebindP3);
		keyPanel.add(rebindP4);
		
		//Panels
		keyPanel.setSize(350, 160);
		keyPanel.setLocation(140, 5);
		getContentPane().add(keyPanel);
		launcher.setSize(130, 160);
		launcher.setLocation(5, 5);
		getContentPane().add(launcher);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);
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
		if (act == "Launch") {
			new Window(500, 500, numPlayersChosen);
			frame.setVisible(false);
		} else if (act == "P1") { //need a window that will return an array of keys that get pressed.
			//do nothing
		} else if (act == "P2") {
			//do nothing
		} else if (act == "P3") {
			//do nothing
		} else if (act == "P4") {
			//do nothing
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

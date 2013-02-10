package tron.colin.zeidler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {
	String[][] controls = { { "W", "A", "S", "D" },
								{ "Up", "Left", "Down", "Right" }, 
								{ "U", "H", "J", "K" },
								{ "NumPad-8", "NumPad-4", "NumPad-5", "NumPad-6" } };

	
	JPanel paper = new JPanel();
	Timer time = new Timer(30, this);
	Window window;
	// create grid
	Grid grid;
	// create player
	Player[] players;

	Window(int x, int y, int numPlayersChosen, String[][] controls) {
		setUp(x, y, numPlayersChosen, controls);
	}

	void setUp(int x, int y, int numP, String[][] controls2) {
		controls = controls2;
		setBounds(100, 100, x, y);
		paper.setBounds(0, 0, x, y);
		paper.setBackground(Color.WHITE);
		add(paper);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				pressedKey(e);

			}
		});
		// create grid
		grid = new Grid(x, y);
		// create players
		players = new Player[numP];

		switch (numP) {
		case 4:
			players[3] = new Player(450, 450);
			players[3].colour = Color.ORANGE;
		case 3:
			players[2] = new Player(50, 450);
			players[2].colour = Color.red;
		case 2:
			players[0] = new Player(50, 50);
			players[0].colour = Color.BLUE;

			players[1] = new Player(450, 50);
			players[1].colour = Color.green;
			break;
		}

		time.start();
	}

	public void pressedKey(KeyEvent e) {
		String key = e.getKeyText(e.getKeyCode());
		// System.out.println(key); //debug to get key names

		// Player controls/key detection
		for (int i = 0; i < players.length; i++) {
			if (key.equals(controls[i][1])) {
				players[i].xSpeed = -5;
				players[i].ySpeed = 0;
				players[i].moved = true;
			} else if (key.equals(controls[i][3])) {
				players[i].xSpeed = 5;
				players[i].ySpeed = 0;
				players[i].moved = true;
			} else if (key.equals(controls[i][0])) {
				players[i].ySpeed = -5;
				players[i].xSpeed = 0;
				players[i].moved = true;
			} else if (key.equals(controls[i][2])) {
				players[i].ySpeed = 5;
				players[i].xSpeed = 0;
				players[i].moved = true;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		draw();

	}

	private void draw() {
		Graphics c = paper.getGraphics();

		for (int i = 0; i < players.length; i++) // loops over the array of
													// players
		{
			// marking the position of the player for all 4 grid spots
			grid.grid[players[i].x / 5][players[i].y / 5] = 1;
			grid.grid[players[i].x / 5 + 1][players[i].y / 5] = 1;
			grid.grid[players[i].x / 5][players[i].y / 5 + 1] = 1;
			grid.grid[players[i].x / 5 + 1][players[i].y / 5 + 1] = 1;
			
			players[i].draw(c); // draws the player at its current location
			
			// if players go out of bounds TEST players[i]
			if (players[i].x / 5 + 1> grid.grid.length - 1 
					|| players[i].x / 5 < 0
					|| players[i].y / 5 + 1> grid.grid[i].length - 1
					|| players[i].y / 5 < 0) {
				players[i].x -= players[i].xSpeed;
				players[i].y -= players[i].ySpeed;
				players[i].dead = true;
			}

			grid.collisionCheck(players[i]); // checks if the player has
												// collided with a trail
		}

		// System.out.println("P1 dead:" + players[0].dead);
		// System.out.println("P2 dead:" + players[1].dead);
		// System.out.println("P3 dead:" + players[2].dead);
		// System.out.println("P4 dead:" + players[3].dead);

	}

}

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

public class Window extends JFrame implements ActionListener {
	JPanel paper = new JPanel();
	Timer time = new Timer(30, this);
	Window window;
	// create grid
	Grid grid;
	// create player
	Player p1;
	Player p2;
	Player p3;
	Player p4;

	Window(int x, int y) {
		setUp(x, y);
	}

	void setUp(int x, int y) {
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
		// create player
		p1 = new Player(50, 50);
		p1.colour = Color.BLUE;

		p2 = new Player(450, 50);
		p2.colour = Color.green;

		p3 = new Player(50, 450);
		p3.colour = Color.red;

		p4 = new Player(450, 450);
		p4.colour = Color.ORANGE;

		time.start();
	}

	public void pressedKey(KeyEvent e) {
		String key = e.getKeyText(e.getKeyCode());
		if (key.equals("A")) {
			p1.xSpeed = -5;
			p1.ySpeed = 0;
		} else if (key.equals("D")) {
			p1.xSpeed = 5;
			p1.ySpeed = 0;
		} else if (key.equals("W")) {
			p1.ySpeed = -5;
			p1.xSpeed = 0;
		} else if (key.equals("S")) {
			p1.ySpeed = 5;
			p1.xSpeed = 0;
		}
		if (key == "Left") {
			p2.xSpeed = -5;
			p2.ySpeed = 0;
		} else if (key == "Right") {
			p2.xSpeed = 5;
			p2.ySpeed = 0;
		} else if (key == "Up") {
			p2.ySpeed = -5;
			p2.xSpeed = 0;
		} else if (key == "Down") {
			p2.ySpeed = 5;
			p2.xSpeed = 0;
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		draw();

	}

	private void draw() {
		Graphics c = paper.getGraphics();
		grid.grid[p1.x / 5][p1.y / 5] = 1;
		grid.grid[p2.x / 5][p2.y / 5] = 2;
		grid.grid[p3.x / 5][p3.y / 5] = 3;
		grid.grid[p4.x / 5][p4.y / 5] = 4;
		p1.draw(c);
		p2.draw(c);
		p3.draw(c);
		p4.draw(c);

	}

}

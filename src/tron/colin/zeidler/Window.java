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
	//create grid
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
		//create grid
		grid = new Grid(x, y);
		//create player
		p1 = new Player(50, 50);
		p1.colour = Color.BLUE;
		
		p2 = new Player(450, 50);
		p2.colour = Color.green;
		
		p3 = new Player (50, 450);
		p3.colour = Color.red;
		
		p4 = new Player(450, 450);
		p4.colour = Color.ORANGE;

		time.start();
	}

	public void pressedKey(KeyEvent e) {
		char key = e.getKeyChar();
		if (key == 'a') {
			p1.xSpeed = -5;
			p1.ySpeed = 0;
		} else if (key == 'd') {
			p1.xSpeed = 5;
			p1.ySpeed = 0;
		} else if (key == 'w') {
			p1.ySpeed = -5;
			p1.xSpeed = 0;
		} else if (key == 's') {
			p1.ySpeed = 5;
			p1.xSpeed = 0;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		draw();

	}

	private void draw() {
		Graphics c = paper.getGraphics();
		c.setColor(Color.WHITE);
		c.fillRect(0, 0,500, 500);
		grid.grid[p1.x/5][p1.y/5] = 1;
		grid.draw(c);
		p1.draw(c);

	}

}

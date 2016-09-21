import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class gameSnake extends JFrame {
	public gameSnake() {
		setTitle("Game Snake");
		setBounds(150,150, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}

	public static void main(String[] args) {
		new gameSnake();
	}

}

class Snake {
	private int length;
	ArrayList<Point> snakeDots = new ArrayList<Point>();
	int direction = 1;

	public Snake(int length) {
		this.length = length;
	}

}

class Point {
	int x;
	int y;
	Color color = Color.BLUE;

}

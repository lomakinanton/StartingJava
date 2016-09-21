import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.JFrame;

public class gameSnake extends JFrame {
	public gameSnake() {
		setTitle("Game Snake");
		setBounds(150,150, 300, 300);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Canvas cpanel = new Canvas();
		
		cpanel.setBackground(Color.WHITE);

		Graphics g = getGraphics();
		g.drawLine(10, 10, 100, 100);
		g.setColor(Color.BLACK);
		
		cpanel.paint(g);
		
		
		
		setLayout(new BorderLayout());
		add(cpanel, BorderLayout.CENTER);
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new gameSnake();
	}
	
	
	public void paint(Graphics g) {
		g.drawLine(5, 5, 5, 5);		
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

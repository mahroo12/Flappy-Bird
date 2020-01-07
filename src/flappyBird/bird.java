package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class bird extends JPanel implements KeyListener, ActionListener{

	private boolean play = false;
	private int slider1 = 200;
	private Timer timer; // timer class for how fast the ball should move
	private int delay = 15; // speed of the bird
	private int birdposx = 120; // x position of the ball
	private int birdposy = 350; // y position of the ball

//	private int birdxdir = -1; // horizontal direction of the ball
//	private int birdydir = -2; // vertical direction of the ball

	
	ArrayList<Rectangle> column;
	

	private static final long serialVersionUID = 1L;
	
	
	/*
	 * this causes the action listener to work idk how tho
	 */
	public bird() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);// it needs an action listener which is this
		timer.start();
		

	}
	
	/*
	 * this causes all the elements to be drawn on the panel
	 * the dispose although causes the whole thing to appear
	 */

	public void paint(Graphics g)
	{
		//the background
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 800, 600);
		
		//the grass
		g.setColor(Color.green);
		g.fillRect(0, 500, 800, 100);
	
		
		//the bird
		g.setColor(Color.yellow);
		g.fillOval(birdposx, birdposy, 20, 20);
		
		
		//the columns
		g.setColor(Color.green.darker());
//		g.fillRect(200, 0, 50, 100);
//		g.fillRect(200, 410, 50, 90);
//		
//		g.fillRect(200+50+10, 0, 50, 200);
//		g.fillRect(200+50+10, 410-25, 50, 100+15);

		//Random rand = new Random();
		int j = 100;
		for(int i = 200; i <800; i= i+70)
		{
			//int j = 100;
			g.fillRect(i, 0, 50, j);
			j= j +10;

		}
		
		int h = 15;
		for(int i = 200; i <800; i= i+70)
		{
			//int j = 100;
			g.fillRect(i, 410-h, 50, 100+h);
			h= h +10;

		}
		
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
//		ticks++;
//		if (ticks%2 == 0 && ymotion<15)
//		{
//			ymotion +=2;
//		}
		
		
		if(play)
		{
			
			
			//used to intersect with the slider
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(slider1, 550, 100, 8)))
			{
				System.out.println("Game Over!");
			}
		}
	birdposy += 1;
	birdposx +=1;
		repaint();// whatever is inside the paint gets repainted once but with the timer.start() gets printed infinitely 
		
	}
	
	/*
	 * dead code
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {}

	/*
	 * dead code
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	
	/*
	 * when we press the up key calls the up method
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moveUp();
		}

	}

	/*
	 * causes the bird to move up 
	 */
	private void moveUp() {
		play = true;
		birdposy -= 30;
		
	}



}

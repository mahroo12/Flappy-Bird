package flappyBird;

import java.awt.Color;
import java.awt.Font;
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
	private int score = 0;
	private int slider1 = 200;
	private Timer timer; // timer class for how fast the ball should move
	private int delay = 30; // speed of the bird
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
		
		
		//the top columns
		g.setColor(Color.green.darker());

	
		g.fillRect(310, 0, 50, 200);
		g.fillRect(380, 0, 50, 300);
		g.fillRect(450, 0, 50, 250);
		g.fillRect(520, 0, 50, 200);
		g.fillRect(590, 0, 50, 260);
		g.fillRect(660, 0, 50, 300);
		g.fillRect(730, 0, 50, 320);
		
		
		// bottom columns
		g.fillRect(310, 410-15, 50, 110);
		g.fillRect(380, 350, 50, 150);
		g.fillRect(450, 325, 50, 180);
		g.fillRect(520, 325, 50, 180);
		g.fillRect(520, 315, 50, 180);
		g.fillRect(590, 315, 40, 190);
		g.fillRect(660, 350, 40, 155);
		g.fillRect(730, 360, 50, 140);


		//Random rand = new Random();
//		int j = 100;
//		for(int i = 200; i <800; i= i+70)
//		{
//			//int j = 100;
//			g.fillRect(i, 0, 50, j);
//			j= j +10;
//
//		}
		
		
//		int h = 15;
//		for(int i = 200; i <800; i= i+70)
//		{
//			//int j = 100;
//			g.fillRect(i, 410-h, 50, 100+h);
//			h= h +10;
//
//		}
		
		//scores
//		g.setColor(Color.white);
//		g.setFont(new Font("serif", Font.BOLD, 25));
//		g.drawString(""+score, 590, 30);
		if (birdposx> 310 && birdposx < 380)
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("10", 590, 30);
			
		}
		else if (birdposx>= 380 && birdposx < 450) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("20", 590, 30);
		}
		
		else if (birdposx>= 450 && birdposx < 520) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("30", 590, 30);
		}
		
		else if (birdposx>= 520 && birdposx < 590) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("40", 590, 30);
		}
		
		else if (birdposx>= 590 && birdposx < 660) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("50", 590, 30);
		}

		else if (birdposx>= 660 && birdposx < 730) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("60", 590, 30);
		}
		else if (birdposx>= 730 && birdposx < 780) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("70", 590, 30);
		}

		else if (birdposx>=780) 
		{
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You win", 590, 30);
		}




		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();

		
		
		if(play)
		{
			
				birdposy += 1;
				birdposx +=1;
			//used to intersect with the slider
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(310, 0, 50, 200)))
			{
				play = false;
			}

			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(380, 0, 50, 300)))
			{
				play = false;
			}
			
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(310, 0, 50, 200)))
			{
				play = false;
			}
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(450, 0, 50, 250)))
			{
				play = false;
			}
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(520, 0, 50, 200)))
			{
				play = false;
			}
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(660, 0, 50, 300)))
			{
				play = false;
			}
			if(new Rectangle(birdposx, birdposy, 20, 20).intersects(new Rectangle(730, 0, 50, 320)))
			{
				play = false;
			}
		}

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

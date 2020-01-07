package flappyBird;

import javax.swing.JFrame;



public class main {


public static void main(String[] args) {
		
	
		/**
		 * setting the properties of the window
		 */
		JFrame obj = new JFrame();
		bird b = new bird();
		obj.setSize(800, 600);
		//obj.setBounds(10, 10,800, 600);// setting the background
		obj.setTitle("Flappy Bird"); // naming the game
		obj.setResizable(false);// want to keep the window fixed
		obj.setVisible(true);//want to make the window visible
		obj.add(b);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//there should be a cross to close
}
}

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;


public class DisplayNews extends Applet implements Runnable{
	int x = 0 ;
	public void init(){
		Thread th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g){	
		g.drawString("Hello Java World, Mostafa is coming!!!!!!!", x , getHeight()/2 );	
	}
	
	public void run(){
	try{
		while (true){
			if( x < getWidth())
				x++;
			else
				x = 0;
		repaint();
		Thread.sleep(8);
		}

	}	
	catch(InterruptedException e){
		 e.printStackTrace();	
		}
	}

}



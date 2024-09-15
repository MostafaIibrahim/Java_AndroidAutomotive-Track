import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date; 

public class TimeApplet extends Applet implements Runnable{
	
	public void init(){
		Thread th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g){
		
		Date date = new Date();
		g.drawString( date.toString() , getWidth()/2 , getHeight()/2 );
		
	}
	
	public void run(){
		while(true){
			try{
			repaint();
			Thread.sleep(1000);
			}catch(InterruptedException e){
			  e.printStackTrace();	
			}
		}
		
	}
}

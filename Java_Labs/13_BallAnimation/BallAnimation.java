import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment; 
import java.awt.Color; 

public class BallAnimation extends Applet implements Runnable{
	int x = 0 , y = getHeight()/2;
	//boolean xFlagDir = true , yFlagDir = true;
	int xFlag = 5 , yFlag = 5; 
	public void init(){
		Thread th = new Thread(this);
		th.start();
	}
	public void paint (Graphics g){
	
		g.setColor(Color.RED);
		g.fillOval( x , y , 30 ,30 );
	}
	public void run(){
		while(true){
		try{
/*
			if( xFlagDir == true && x < getWidth())
				x++;
			else 
				xFlagDir = false ;
			if( xFlagDir == false && x > 0)
				x--;
			else
				xFlagDir = true ;
				
			if( yFlagDir == true && y < getHeight())
				y += 2;
			else 
				yFlagDir = false ;
			if( yFlagDir == false && y > 0)
				y -= 2;
			else
				yFlagDir = true ;
*/
			x += xFlag;
			y += yFlag;
			if( x <= 0 || x >= getWidth() )
				xFlag = -xFlag ;
			if( y <= 0 || y >= getHeight() )
				yFlag = -yFlag ;
					
			repaint();
			Thread.sleep(15);
			}
		catch(InterruptedException e){
		 e.printStackTrace();	
		}	
		
	}	
}


}

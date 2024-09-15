import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class MovingTextkey extends Applet{
	private int x , y ;
	
	public void init(){
		x = getWidth()/2 ;  
		y = getHeight()/2 ;
		
		KeyAdapter adapt = new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				//if( x < getWidth() && x > 0 && )
				switch(e.getKeyCode()){
					case KeyEvent.VK_UP: y -= 2; break;
					case KeyEvent.VK_DOWN: y += 2; break;
					case KeyEvent.VK_RIGHT: x += 2; break;
					case KeyEvent.VK_LEFT: x -= 2; break;
				}
				repaint();
			}
		};
		
		this.addKeyListener(adapt);
	}
	
	public void paint(Graphics g){
		
		g.drawString("Moving Mostafa", x , y );	
	}


}

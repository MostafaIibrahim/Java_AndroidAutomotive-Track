import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;


public class DragBallApplet extends Applet{
	private int x , y;
	
	public void init(){
		x = getWidth()/2;
		y = getHeight()/2;
		MouseAdapter adapter = new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				x = e.getX();
				y = e.getY();
				repaint();
			}	
		};
		this.addMouseMotionListener(adapter);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval( x , y , 60 , 60 );
	}
}

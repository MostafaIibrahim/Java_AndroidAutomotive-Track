import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;

public class LineApplet extends Applet{
	private int x1 , y1 , x2 , y2;
	
	public void init(){
		x1 = x2 = y1 = y2 = 0;
		MouseAdapter adapter = new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				repaint();
			}
			
		};
		this.addMouseListener(adapter);
		this.addMouseMotionListener(adapter);
		
		 
	}
	public void paint(Graphics g){
		g.drawLine(x1,y1,x2,y2);
	}
	
	

}

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;

public class MultipleLineApplet extends Applet{
	int tempX1 , tempX2 , tempY1 , tempY2;
	ArrayList<Line> arrOfLines = new ArrayList<Line>();		
	private int capOfLines = 0 ;
	boolean dragFlag = false;
	
	
	class Line{
		private int x1 , x2 , y1 , y2 ;
		Line(){ x1 = x2 = y1 = y2 = 0; }
		void setX1(int a){x1 = a;}
		void setX2(int a){x2 = a;}
		void setY1(int a){y1 = a;}
		void setY2(int a){y2 = a;}
		
		int getX1(){ return x1; }
		int getX2(){ return x2; }
		int getY1(){ return y1; }
		int getY2(){ return y2; }
		
		void draw(Graphics g){
			g.drawLine(x1,y1,x2,y2);
		}
	}
	
	
	public void init(){
		tempX1 = tempX2 = tempY1 = tempY2 = 0;
		MouseAdapter adapter = new MouseAdapter(){
		
			public void mousePressed(MouseEvent e){
				tempX1 = e.getX();
				tempY1 = e.getY();
			}
			public void mouseDragged(MouseEvent e){
				tempX2 = e.getX();
				tempY2 = e.getY();
				dragFlag = true;
				repaint();					
			}
			public void mouseReleased(MouseEvent e){
				if(dragFlag == true){
					dragFlag = false;
					arrOfLines.add(new Line()); //append on the array
					
					(arrOfLines.get(capOfLines)).setX1(tempX1);
					(arrOfLines.get(capOfLines)).setY1(tempY1);
					(arrOfLines.get(capOfLines)).setX2(tempX2);
					(arrOfLines.get(capOfLines)).setY2(tempY2);
					capOfLines++; // In Drag it will keep listening
					repaint();
				}
				
				//Here I should draw after checking the flag
			}	
		
		};
		this.addMouseListener(adapter); // Register First line as a source to Listner
		this.addMouseMotionListener(adapter);
		 
	}
	public void paint(Graphics g){
		
		if(dragFlag){
			g.drawLine(tempX1,tempY1,tempX2,tempY2);
		}
		
		for(Line line : arrOfLines){ // different paint for every obj
			line.draw(g);
		}
		
	}
}

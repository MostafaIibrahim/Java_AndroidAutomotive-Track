import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;

// The real Problem is with paint method and how will it works with thread --> This what I cannot understand
// I have a problem with the concept of drawing while dragging

public class MultipleLineApplet extends Applet{
	int tempX1 , tempX2 , tempY1 , tempY2;
	Line[] arrOfLines = new Line[3];
	boolean dragFlag = false;
	byte maxOfLines = 0 ;
	
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
				if(maxOfLines < 3){ // It will keep incrementing until it reaches 3, Then it won't repaint or assign it to obj var
					dragFlag = true;
					repaint();					
				}
			}
			public void mouseReleased(MouseEvent e){
				if(dragFlag == true){
					dragFlag = false;
					arrOfLines[maxOfLines] = new Line();
					arrOfLines[maxOfLines].setX1(tempX1);
					arrOfLines[maxOfLines].setY1(tempY1);
					arrOfLines[maxOfLines].setX2(tempX2);
					arrOfLines[maxOfLines].setY2(tempY2);
					maxOfLines++; // In Drag it will keep listening
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
		
		for(int i = 0 ; i < maxOfLines ; i++){ // different paint for every obj
			arrOfLines[i].draw(g);
		}
		
	}
}

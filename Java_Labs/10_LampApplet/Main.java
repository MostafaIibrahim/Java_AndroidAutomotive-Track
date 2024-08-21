import java.awt.Graphics;
import java.applet.Applet;
import java.awt.GraphicsEnvironment; 
import java.awt.Color; 

public class Main extends Applet{

	public void paint (Graphics g){
		int ovelHeight = 33 ;
		int ovelWeidth = 165;
		int x_orgin = 150 ;
		int y_orgin = 150;
		
		g.drawLine(x_orgin,y_orgin,x_orgin-25,y_orgin+145); // left line
		
		g.drawLine(x_orgin+ovelWeidth ,y_orgin , x_orgin+ovelWeidth+25 ,y_orgin+145); // right line

		g.drawRect(x_orgin,380 + 30,ovelWeidth,15);
		g.drawLine(x_orgin+58 ,380 + 30 , x_orgin+75 ,315 + 15); //left
		g.drawLine(x_orgin+105 ,380 + 30 , x_orgin+85 ,315 + 15); // right
		
		g.drawArc(x_orgin-25,y_orgin+110, ovelWeidth+50 ,70 ,-180,180);

		g.setColor(Color.YELLOW);
		
		g.fillOval(x_orgin,y_orgin-20,ovelWeidth,ovelHeight); // Upper ovel
		g.fillOval(x_orgin -8 ,215-20,35,70); // left ovel
		
		g.fillOval(x_orgin - 10 + 55 ,175,80,120); // middle ovel
		
		g.fillOval(x_orgin + 138 ,215-20,35,70); // right ovel
	}

}




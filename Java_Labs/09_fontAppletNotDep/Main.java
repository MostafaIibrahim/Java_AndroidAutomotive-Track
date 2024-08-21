import java.awt.GraphicsEnvironment; 
import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Font; 

public class Main extends Applet{

	public void paint (Graphics g){
	int i ;
	GraphicsEnvironment t = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] s = t.getAvailableFontFamilyNames();
	for( i = 0 ; i < s.length ; i++){
			Font font = new Font(s[i], Font.BOLD ,15);
			g.setFont(font);
			g.drawString(s[i],100,100+25*i);
		}
	}

}




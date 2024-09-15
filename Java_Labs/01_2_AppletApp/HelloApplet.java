import java.applet.Applet;
import java.awt.Graphics;
public class HelloApplet extends Applet{

	public void paint (Graphics g){
	String msg = "Hello from AAD student: Mostafa ";
	g.drawString(msg,300,500);
	}

}

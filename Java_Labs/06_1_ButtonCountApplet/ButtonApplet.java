import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonApplet extends Applet{

	private int count;
	Button incButton;
	Button decButton;
	
	public void init(){
		count = 0 ;
		incButton = new Button("+");
		decButton = new Button("-");
		add(incButton);
		add(decButton);
		//Create Listner for inc 
		incButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count++;
			repaint();
		}
		});
		
		
		decButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			count--;
			repaint();
		}
		});
		
		
		//Create Listner for dec
	}
	public void paint(Graphics g){
		g.drawString(" "+count, getWidth()/2 , getHeight()/2 );

	}
}

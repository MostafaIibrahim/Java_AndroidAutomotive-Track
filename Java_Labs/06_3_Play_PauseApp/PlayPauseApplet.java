import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color; 
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPauseApplet extends Applet implements Runnable{
	int x = getWidth()/2 , y = getHeight()/2;
	boolean xFlagDir = true , yFlagDir = true;
	private Button startButton;
	private Button pauseButton;
	private boolean firstTimeFlag = true;

	public void init(){
		Thread th = new Thread(this);
		startButton = new Button("Start");
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(firstTimeFlag == true){
					firstTimeFlag = false;
					th.start();
				}else{
						th.resume();
					
				}
			}
		});
		pauseButton = new Button("Pause");
		pauseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					th.suspend();
			}
		});
		add(startButton);
		add(pauseButton);
	}
	public void paint (Graphics g){
	
		g.setColor(Color.RED);
		g.fillOval( x , y , 30 ,30 );
	}
	public void run(){
		while(true){
				try{

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
			repaint();
			Thread.sleep(15);
			}
		catch(InterruptedException e){
		 e.printStackTrace();	
		}
		
	}	
}


}


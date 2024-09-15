import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color; 
import java.awt.Button;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;

public class PaintApplet extends Applet{
    UiComponantes uiApplet;
    static ButtonState currentState ;
    static boolean isSolidBoxActives;
    static Color currentColor;
    boolean isDragFlag;
    int tempX1 , tempX2 , tempY1 , tempY2;
    Pencil currentPencil = null;
    Eraser currentEraser = null;
    ArrayList<Shape> shapeContainer = new ArrayList<>();
    public void init(){
        tempX1 = tempX2 = tempY1 = tempY2 = 0;
        currentState = ButtonState.NONE_BUTTON;
        isSolidBoxActives = false;
        isDragFlag = false;
        currentColor = Color.BLACK;
        uiApplet = new UiComponantes();
        uiApplet.registerClearButton(); //no Functionality
        uiApplet.registerUndoButton(); //no Functionality
        uiApplet.registerLineButton();
        uiApplet.registerRectButton();
        uiApplet.registerOvalButton();
        uiApplet.registerPencilButton();
        uiApplet.registerEraserButton();
        uiApplet.registerSolidBox();
        uiApplet.registerDottedBox(); //no Functionality
        uiApplet.registerBlackButton();
        uiApplet.registerRedButton();
        uiApplet.registerGreenButton();
        uiApplet.registerBlueButton();


        MouseAdapter adapter = new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            	tempX1 = e.getX();
				tempY1 = e.getY();
                if(currentState == ButtonState.PENCIL_BUTTON){
                    currentPencil = new Pencil();
                    currentPencil.addPoint(tempX1,tempY1);
                    shapeContainer.add(currentPencil);
                    repaint();                    
                }else if(currentState == ButtonState.ERASER_BUTTON){
                    currentEraser = new Eraser();
                    currentEraser.addPoint(tempX1,tempY1);
                    shapeContainer.add(currentEraser);
                }
            }
            public void mouseDragged(MouseEvent e){
    			tempX2 = e.getX();
			    tempY2 = e.getY();
                if (currentState == ButtonState.PENCIL_BUTTON && currentPencil != null) {
                    currentPencil.addPoint(tempX2, tempY2);
                }
                else if(currentState == ButtonState.ERASER_BUTTON && currentEraser != null){
                    currentEraser.addPoint(tempX2,tempY2);
                }
                else if(currentState != ButtonState.NONE_BUTTON){
				    isDragFlag = true;
                }
			    repaint();		                

            }
            public void mouseReleased(MouseEvent e){
                if(isDragFlag == true){
                    isDragFlag = false;
                    currentEraser = null;
                    currentPencil= null;
                    Shape shapeObj = null;
                    switch (currentState){
                        case RECTANGLE_BUTTON:
                            shapeObj = new Rectangle();
                            break;
                        case LINE_BUTTON:
                            shapeObj = new Line();
                            break;
                        case OVAL_BUTTON:
                            shapeObj = new Oval();
                            break;
                        case ERASER_BUTTON:
                            shapeObj = new Eraser();
                            break;
                        // Add more cases for other shapes
                    }
                    if(shapeObj != null){
                        shapeObj.setX1(tempX1);
                        shapeObj.setY1(tempY1);
                        shapeObj.setX2(tempX2);
                        shapeObj.setY2(tempY2);
                        shapeContainer.add(shapeObj); 
                    }
                    repaint();
                }
            }
        };
    	this.addMouseListener(adapter); // Register First line as a source to Listner
		this.addMouseMotionListener(adapter);
    }
    public void paint(Graphics g){
        // Drag Logic is not generic
        if(isDragFlag){
            switch (currentState) {
                case RECTANGLE_BUTTON:
                    new Rectangle().tempDraw(g, tempX1, tempY1, tempX2, tempY2);
                    break;
                case LINE_BUTTON:
                    new Line().tempDraw(g, tempX1, tempY1, tempX2, tempY2);
                    break;
                case OVAL_BUTTON:
                    new Oval().tempDraw(g, tempX1, tempY1, tempX2, tempY2);
                    break;
                case ERASER_BUTTON:
                case PENCIL_BUTTON:
                    (shapeContainer.get(shapeContainer.size() - 1)).draw(g);
                    break;
                        
            }
        }
        for(Shape obj : shapeContainer){ // different paint for every obj
			obj.draw(g);
		}
    }

    public enum ButtonState{
        NONE_BUTTON,
        RECTANGLE_BUTTON,
        LINE_BUTTON,
        OVAL_BUTTON,
        ERASER_BUTTON,
        PENCIL_BUTTON
    }

    class UiComponantes{
        Button clearButton;
        Button undoButton;
        Button lineButton;
        Button rectButton;
        Button ovalButton;
        Button pencilButton;
        Button eraserButton;
        Button blackButton;
        Button redButton;
        Button greenButton;
        Button blueButton;
        Checkbox solidBox;
        Checkbox dottedBox;
        Shape shapeObj;
        UiComponantes(){
            clearButton = new Button("Clear");
            undoButton = new Button("Undo");
            rectButton = new Button("Rectangle");
            lineButton = new Button("Line");
            ovalButton = new Button("Oval");
            pencilButton = new Button("Pencil");
            eraserButton = new Button("Eraser");
            solidBox = new Checkbox("Solid");
            dottedBox = new Checkbox("Dotted");
            blackButton = new Button("Black");
            redButton = new Button("Red");
            greenButton = new Button("Green");
            blueButton = new Button("Blue");
            isSolidBoxActives = false;
            add(clearButton);
            add(undoButton);
            add(lineButton);
            add(rectButton);
            add(ovalButton);
            add(pencilButton);
            add(eraserButton);
            add(solidBox);
            add(dottedBox);
            add(blackButton);
            add(redButton);
            add(greenButton);
            add(blueButton);
            blackButton.setBackground(Color.BLACK);
            redButton.setBackground(Color.RED);
            greenButton.setBackground(Color.GREEN);
            blueButton.setBackground(Color.BLUE);
        }
        public void registerClearButton(){
        	clearButton.addActionListener( e -> { shapeContainer.clear();repaint(); });
        }
        public void registerUndoButton(){
        	undoButton.addActionListener ( e -> { shapeContainer.remove(shapeContainer.size() - 1);repaint();});
        }
        public void registerRectButton(){	
		rectButton.addActionListener( e -> { currentState = ButtonState.RECTANGLE_BUTTON; });
	}
        public void registerLineButton(){	
		lineButton.addActionListener( e -> { currentState = ButtonState.LINE_BUTTON; });
	}
        public void registerOvalButton(){
        	ovalButton.addActionListener( e -> { currentState = ButtonState.OVAL_BUTTON; });
        }
        public void registerPencilButton(){
        	pencilButton.addActionListener( e -> { currentState = ButtonState.PENCIL_BUTTON; });
        }
        public void registerEraserButton(){
        	eraserButton.addActionListener( e  -> { currentState = ButtonState.ERASER_BUTTON; });
        }
        public void registerSolidBox(){
		solidBox.addItemListener(e -> { isSolidBoxActives = !isSolidBoxActives; });
	}
        public void registerDottedBox(){
		dottedBox.addItemListener( e -> {/*dotted bottom handling */});
	}    
        public void registerBlackButton(){
		blackButton.addActionListener( e -> { currentColor = Color.BLACK; });
	}
        public void registerRedButton(){
        	redButton.addActionListener( e -> { currentColor = Color.RED;});
        }
        public void registerGreenButton(){
        	greenButton.addActionListener( e -> { currentColor = Color.GREEN; });
        }

        public void registerBlueButton(){
		blueButton.addActionListener( e -> { currentColor = Color.BLUE; });
	}
    }
    abstract class Shape {
        Color objColor;
        boolean objSolidState;
        int x1 , y1 , x2 , y2 ;
        Shape(){
            objColor = currentColor;
            objSolidState = isSolidBoxActives;
            x1 = x2 = y1 = y2 = 0;
        }
        abstract void draw(Graphics g);
        abstract void tempDraw(Graphics g , int x , int y , int x2 , int y2);
        void setX1(int x){ x1 = x; }
        void setY1(int y){ y1 = y; }
        void setX2(int x){ x2 = x; }
        void setY2(int y){ y2 = y; }
        int getX1(){ return x1; }
        int getY1(){ return y1; }
        int getX2(){ return x2; }
        int getY2(){ return y2; }
    }
    class Rectangle extends Shape{
        private int getWidth(){ return Math.abs(super.getX2() - super.getX1());}
        private int getHeight(){ return Math.abs(super.getY2() - super.getY1());}
        private int getMinXDimensions(){ return Math.min(super.getX1() , super.getX2());}
        private int getMinYDimensions(){ return Math.min(super.getY1() , super.getY2());}
        void draw(Graphics g){
            g.setColor(objColor);
            if(objSolidState){
                g.fillRect( getMinXDimensions() , getMinYDimensions() , getWidth() , getHeight() );
            }
            else{
                g.drawRect( getMinXDimensions() , getMinYDimensions() , getWidth()  , getHeight() );
            }
        }
        void tempDraw(Graphics g , int x , int y , int x2 , int y2){
            int width = Math.abs(x2 - x);
            int height = Math.abs(y2 - y);
            int x1 = Math.min(x , x2);
            int y1 = Math.min(y , y2);
            g.setColor(currentColor);
            if(isSolidBoxActives){
                g.fillRect( x1 , y1 , width , height );
            }
            else{
                g.drawRect( x1 , y1  , width  , height );
            } 
        }
    }    
    class Line extends Shape{
        void draw(Graphics g){
            g.setColor(objColor);
            g.drawLine(super.getX1(),super.getY1(),super.getX2(),super.getY2());
        }
        void tempDraw(Graphics g , int x , int y , int x2 , int y2){
            g.setColor(currentColor);
            g.drawLine(x,y,x2,y2);
        }    
    }
    class Oval extends Shape{
        private int getWidth(){ return Math.abs(super.getX2() - super.getX1());}
        private int getHeight(){ return Math.abs(super.getY2() - super.getY1());}
        private int getMinXDimensions(){ return Math.min(super.getX1() , super.getX2());}
        private int getMinYDimensions(){ return Math.min(super.getY1() , super.getY2());}
        void draw(Graphics g){
            g.setColor(objColor);
            if(objSolidState){
                g.fillOval(getMinXDimensions(),getMinYDimensions(),getWidth(),getHeight());
            }
            else{
                g.drawOval(getMinXDimensions(),getMinYDimensions(),getWidth(),getHeight() );
            }             
        }
        void tempDraw(Graphics g , int x , int y , int x2 , int y2){
            int width = Math.abs(x2 - x);
            int height = Math.abs(y2 - y);
            int x1 = Math.min(x , x2);
            int y1 = Math.min(y , y2);
            g.setColor(currentColor);
            if(isSolidBoxActives){
                g.fillOval( x1 , y1 , width , height );
            }
            else{
                g.drawOval( x1 , y1  , width  , height );
            } 
        }    
    }
    /*class Eraser extends Shape{
        private int getMinXDimensions(){ return Math.min(super.getX1() , super.getX2());}
        private int getMinYDimensions(){ return Math.min(super.getY1() , super.getY2());}
        void draw(Graphics g){
            g.setColor(Color.WHITE);
            g.fillOval(getMinXDimensions(),getMinYDimensions(),20,20);
        }
        void tempDraw(Graphics g , int x , int y , int x2 , int y2){
            int x1 = Math.min(x , x2);
            int y1 = Math.min(y , y2);
            g.setColor(Color.WHITE);
            g.fillOval(x1,y1,20,20);
        }
    }*/
   
    class Eraser extends Shape{
        ArrayList<Point> points;
        Eraser(){
            points = new ArrayList<>();
        }

        void addPoint(int x, int y) {
            points.add(new Point(x, y));
        }

        void draw(Graphics g) {
            g.setColor(Color.WHITE);
            for (Point point : points) {
            g.fillOval(point.x, point.y, 15, 15); 
            }
        }
        void tempDraw(Graphics g , int x , int y , int x2 , int y2){
        }        
    }
    class Pencil extends Shape{
        ArrayList<Point> points;
        Pencil() {
            points = new ArrayList<>();
        }

        void addPoint(int x, int y) {
            points.add(new Point(x, y));
        }

        void draw(Graphics g) {
            g.setColor(objColor);
            for (Point point : points) {
            g.fillOval(point.x, point.y, 10, 10); 
            }
        }
        void tempDraw(Graphics g , int x , int y , int x2 , int y2){
        }        
    }
}

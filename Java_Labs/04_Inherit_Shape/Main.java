

abstract class Shape{
	private double dim1;
	public Shape(double d1){
		dim1 = d1;
	}
	abstract public double clcArea();
	public void setDim1(double d1){
		dim1 = d1;
	}
	public double getDim1(){
		return dim1;
	}
}

class Circle extends Shape{
	public Circle(double r){
		super(r);
	}
	public void setDim1(double d1){
		super.setDim1(d1);
	}
	public double getDim1(){
		return super.getDim1();
	}
	public double clcArea(){
		return 3.14 * super.getDim1();
	}
}

class Rectangle extends Shape{
        private double dim2;
	public Rectangle(double h, double w){
                super(w);
		dim2 = h ;
        }
        public void setDim1(double d1){
                super.setDim1(d1);
        }
	public void setDim2(double d2){
		dim2 = d2;
	}
        public double getDim1(){
                return super.getDim1();
        }
	public double getDim2(){
		return dim2;
	}
        public double clcArea(){
                return dim2 * super.getDim1();
        }
}

class Triangle extends Shape{
        private double dim2;
        public Triangle(double h, double w){
                super(w);
                dim2 = h ;
        }
        public void setDim1(double d1){
                super.setDim1(d1);
        }
        public void setDim2(double d2){
                dim2 = d2;
        }
        public double getDim1(){
                return super.getDim1();
        }
        public double getDim2(){
                return dim2;
        }
        public double clcArea(){
                return 0.5 * dim2 * super.getDim1();
        }
}

public class Main{
	
	public static void main(String[] args){
		Triangle t = new Triangle(10,20);
		Circle c = new Circle(20);
		Rectangle r = new Rectangle(40,50);
		
		double rest= t.clcArea();
		System.out.println(rest);
		
		double resc = c.clcArea();
		System.out.println(resc);

		double resr = r.clcArea();
		System.out.println(resr);
	}

}

	


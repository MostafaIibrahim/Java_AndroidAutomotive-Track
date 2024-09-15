


public class Main{

	public  static void main(String[] args){
	
		Complex c1 = new Complex(10,20);
		Complex c2 = new Complex(40,50);

		c1.addComplex(c2);

		System.out.print("1)-->C1= ");
		Complex.printComplex(c1);

		c1.subComplex(c2);
	        System.out.print("2)-->C1= ");
		Complex.printComplex(c1);

		System.out.print("1)-->C2= ");
		c2.subComplex(c1);
                Complex.printComplex(c2);

		//Calling by Static 
                System.out.print("1)C1= ");
                Complex.printComplex(c1);
                System.out.print("1)C2= ");
                Complex.printComplex(c2);
		Complex c3= Complex.sumComplex(c1,c2);
		Complex.printComplex(c3);

                System.out.print("2)C1= ");
                Complex.printComplex(c1);
                System.out.print("2)C2= ");
                Complex.printComplex(c2);
		c3 =Complex.subComplex(c1,c2);
                Complex.printComplex(c3);


	}
}


class Complex{
	
	private int real;
	private int img;
	public Complex(int real , int img){
	       this.real = real;
       	       this.img = img;
	}

	public void setImg(int img_a){
		img = img_a;
	}
	public void setReal(int real_a){
		real = real_a;
	}
	public void addComplex(Complex c){
		real = real + c.real;
		img = img + c.img;
	}
	public void subComplex(Complex c){
		img  = img - c.img;
		real = real - c.real;
	}

	// Using Static to be able to be called in different way
	 public static Complex sumComplex(Complex c1,Complex c2){
               	Complex tmp = new Complex(0,0);
		tmp.real = c1.real + c2.real;
                tmp.img = c1.img + c2.img;
		return tmp;
        }
        public static Complex subComplex(Complex c1,Complex c2){
                Complex tmp = new Complex(0,0);
	       	tmp.img  = c1.img - c2.img;
                tmp.real = c1.real - c2.real;
		return tmp;
        }

        public static void printComplex(Complex c){
                String str;
                if(c.img > 0){
                        str=c.real + "+" + c.img + "i";
                }
                else
                        str=c.real + "" + c.img + "i";

                System.out.println(str);
        }


}	

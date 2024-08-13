class Parent{

	private int no1 , no2;
	public Parent(){}
	public Parent(int n1,int n2){
		no1 = n1 ;
		no2 = n2;
	}
	public void setNo1(int n1){
		no1 = n1;
	}
	public void setNo2(int n2){
		no2 = n2;
	}
	public int getNo1(){
		return no1;
	}
	public int getNo2(){
		return no2;
	}
	public int sum(){
		return no1 + no2;
	}
}

class Child extends Parent{
	private int no3;
	public Child(int n1 , int n2 , int n3){
		super(n1,n2);
		no3 = n3;
	}
	public void setNo1(int n1){
		super.setNo1(n1);
	}
        public void setNo2(int n2){
                super.setNo2(n2);
        }
        public void setNo3(int n3){
                no3 = n3;
        }
	public int getNo1(){
		return super.getNo1();
	}
        public int getNo2(){
                return super.getNo2();
        }
        public int getNo3(){
                return no3;
        }
	public int sum(){
		return no3 + super.sum();
	}
}

public class Main{
	public static void  main(String[] args){
		Child p = new Child(10,20,30);
		int res = p.sum();
		System.out.println(res);
		p.setNo1(13);
		res = p.sum();
                System.out.println(res);
	}
}




public class Main{

	public static void main(String[] args){
		 if ( args.length != 3){
			System.out.println("Error:Enter 2 Operands");
		
		}
		else{
		int op1 = Integer.parseInt(args[0]);
		int op2 = Integer.parseInt(args[2]);
		String operator = args[1];
		switch (operator) {
			case "+": System.out.println(op1 + op2);break;
			case "-": System.out.println(op1 - op2);break;
			case "x": System.out.println(op1 * op2);break;
			case "/": System.out.println((float)op1 / op2);break;
			default : System.out.println(" Enter Right operator ");break;
			}
		}			
				
	}
}

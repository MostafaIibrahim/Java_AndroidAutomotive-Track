	
	
	public class Main{
	public static void main(String[] args){
		String st = args[0];
		String[] result = st.split("[.]");
		
		for(String i : result){
			System.out.println(i);
		}
	}
}

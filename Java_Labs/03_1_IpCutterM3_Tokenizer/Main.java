import java.util.StringTokenizer ;


public class Main{
	public static void main(String[] args){
		String input = args[0];
		StringTokenizer st = new StringTokenizer(input,".");
		while(st.hasMoreTokens()){
         		System.out.println(st.nextToken());
     		}
	}
}

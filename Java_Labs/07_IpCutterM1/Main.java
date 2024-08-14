public class Main{
	public static void main(String[] args){
		String ip = args[0];
		int index = 0 ;
		int begin = 0 ;
		while(true){
			index = ip.indexOf('.',index + 1);
			if(index == -1){
				index = ip.lastIndexOf('.');
				System.out.println(ip.substring(index+1));
				break;
				}	
			System.out.println(ip.substring(begin , index));
			begin = index + 1;
		}
	}
}

void FirstMethod(String ip){


}

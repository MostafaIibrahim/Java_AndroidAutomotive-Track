

public class Main{
	public static void main(String[] args){
	int n = 4 ;
		for(int i = 0 ; i < n ; i++){                                          
			for(int j = 0 ; j < (3*n-1) ; j++){	                         				
				if( j <= n){                      
					if( j <= i )
						System.out.print("*");
					else
						System.out.print(" ");
				}
				else if(j > n){
					if( i + j == 2 * n ){
						int q = j ; 
						while( q < 2*n+1 ){ 
							System.out.print("* ");
							q++;
							}
					}
					else{
						System.out.print(" ");
					}
				
				}
			}
				System.out.print('\n');
		}	
	}
}

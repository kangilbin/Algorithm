import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{

   	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A =  Integer.parseInt(br.readLine()); //최초 값
		int arr[][] = new int[A][A];
		for(int i=0; i<A; i++){
		    int B =  Integer.parseInt(br.readLine()); 
		    for(int j=0; j<i+1; j++){
		    	arr[i][j] = B;
		      if(j > 0 && i > 0) {
		    	  arr[i][j] = arr[i][j-1] - arr[i-1][j-1];
		      }
		   }
		}
		
		for(int[] C : arr){
		    for(int D: C){
		    	if(D == 0) {
		    		System.out.print(" ");
		    	}else {
		    		System.out.print(D + " ");
		    	}
		    }
		    System.out.println();
		}
	}
}

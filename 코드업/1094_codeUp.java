import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{

   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N =  Integer.parseInt(br.readLine()); 
		 int arr[] = new int[N];
		 
		 StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		 for(int i=0; i<N; i++) {
			 int num =  Integer.parseInt(st.nextToken()); 
			 arr[i] = num;
		 }
		 
		 for(int i=N-1; 0<=i; i--) {
			 System.out.print(arr[i]+" ");
		 }
   	}
}

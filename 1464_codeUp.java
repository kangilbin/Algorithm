import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
	        int N =  Integer.parseInt(st.nextToken()); //int 형으로 입력
	        int M =  Integer.parseInt(st.nextToken()); 
	        
	        int arr[][] = new int[N][M];
	        int num = N*M; //1열 값 
	        int hang = N*M;
	        for(int i=0; i < N; i++){
	            for(int j=0; j<M; j++){
	                arr[i][j] = num;
	                System.out.print(arr[i][j]+" ");
	                num--;
	            }
	            hang -= M;
	            System.out.println("");
	        }
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
   	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine()); //int 형으로 입력
        int arr[][] = new int[N][N];
        int cnt = 1;
        int num = 1;
        for(int i=0; i < N; i++){
            cnt = num;
            for(int j=0; j<N; j++){
                arr[i][j] = cnt;
                System.out.print(arr[i][j]+" ");
                cnt += N;
            }
            num++;
            System.out.println("");
        }
   	}
}

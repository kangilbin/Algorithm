import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N =  Integer.parseInt(st.nextToken()); //가로
		int M =  Integer.parseInt(st.nextToken()); //세로
		int num =  Integer.parseInt(br.readLine());  // 막대의 개수
		int arr[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = 0;
			}
		}
		
		for(int i=0; i<num; i++) {
			StringTokenizer bar = new StringTokenizer(br.readLine(), " ");
			int A =  Integer.parseInt(bar.nextToken());
			int B =  Integer.parseInt(bar.nextToken());
			int C =  Integer.parseInt(bar.nextToken());
			int D =  Integer.parseInt(bar.nextToken());
			
			if(B == 0) {
				for(int j=0; j<A; j++) {
					arr[C-1][D-1+j] = 1;
				}
			} else if(B == 1) {
				for(int j=0; j<A; j++) {
					arr[C-1+j][D-1] = 1;
				}
			}
		}
		
		for(int[] result : arr) {
			for(int resultF : result) {
				System.out.print(resultF + " ");
			}
			System.out.println("");
		}
	}
}

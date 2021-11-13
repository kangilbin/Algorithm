import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[9][9]; // 문제를 받는 input 배열
		
		for(int i=0; i<9; i++) {
			StringTokenizer input = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<9; j++) {
				arr[i][j] =  Integer.parseInt(input.nextToken()); 
			}
		}
		StringTokenizer str = new StringTokenizer(br.readLine(), " "); 
		int r =  Integer.parseInt(str.nextToken()) -1; 	//지정 행
		int c =  Integer.parseInt(str.nextToken()) -1; 	//지정 열
		
		int sum = 0;  // 주위 값을 저장하는 변수
		if(r==0) {
			if(c==0) {
				sum = arr[r][c+1] + arr[r+1][c] + arr[r+1][c+1];
			}else if(c==8) {
				sum = arr[r][c-1] + arr[r+1][c-1] + arr[r+1][c];
			}else {
				sum = arr[r][c-1] + arr[r+1][c-1] + arr[r+1][c] + arr[r+1][c+1] + arr[r][c+1];
			}
		}else if(r==8) {
			if(c==0) {
				sum = arr[r-1][c] + arr[r-1][c+1] + arr[r][c+1];
			}else if(c==8) {
				sum = arr[r][c-1] + arr[r-1][c-1] + arr[r-1][c];
			} else {
				sum = arr[r][c-1] + arr[r-1][c-1] + arr[r-1][c] + arr[r-1][c+1] + arr[r][c+1];
			}
		} else {
			if(c==0) {
				sum = arr[r-1][c] + arr[r-1][c+1] + arr[r][c+1] + arr[r+1][c+1] + arr[r+1][c];
			}else if(c==8) {
				sum = arr[r-1][c] + arr[r-1][c-1] + arr[r][c-1] + arr[r+1][c-1] + arr[r+1][c];
			} else {
				sum = arr[r+1][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r-1][c+1] + arr[r-1][c]+arr[r-1][c-1]+arr[r][c-1]+arr[r+1][c-1];
			}
		}
		
		if(arr[r][c] == 1) {
			System.out.println("-1");
		}else {
			System.out.println(sum);
		}
	}
}

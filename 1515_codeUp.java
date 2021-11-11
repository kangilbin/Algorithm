import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{

   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[25][25]; // 문제를 받는 input 배열
		int arrAnswer[][] = new int[25][25]; // 변경된 값을 가지고 있는 배열
		
		for(int i=0; i<25; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<25; j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken()); 
			}
		}
		int sum = 0;  // 주위 값을 저장하는 변수
		for(int i=0; i<25; i++) {
			for(int j=0; j<25; j++) {
				if(i==0) {
					if(j==0) {
						sum = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
					}else if(j==24) {
						sum = arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j];
					}else {
						sum = arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1];
					}
				}else if(i==24) {
					if(j==0) {
						sum = arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1];
					}else if(j==24) {
						sum = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j];
					} else {
						sum = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1];
					}
				} else {
					if(j==0) {
						sum = arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j];
					}else if(j==24) {
						sum = arr[i-1][j] + arr[i-1][j-1] + arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j];
					} else {
						sum = arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i-1][j+1] + arr[i-1][j]+arr[i-1][j-1]+arr[i][j-1]+arr[i+1][j-1];
					}
				}
				if(arr[i][j] == 0){
					if(sum==3){
						arrAnswer[i][j] = 1;
					}
				} else {
					if(sum>=4 || sum <=1) {
						arrAnswer[i][j] = 0;
					} else if(sum==2 || sum==3){
						arrAnswer[i][j] = 1;
					}
				}
			}
		}
		
		
		for(int i=0; i<25; i++) {
			for(int j=0; j<25; j++) {
				arr[i][j] =arrAnswer[i][j];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}

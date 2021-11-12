import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");  //배열의 행열 입력
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		StringTokenizer conditions = new StringTokenizer(br.readLine(), " ");  //조건 입력
		int x = Integer.parseInt(conditions.nextToken());
		int y = Integer.parseInt(conditions.nextToken());
		int z = Integer.parseInt(conditions.nextToken());
		
		int arr[][] = new int[172][172]; // 문제를 받는 input 배열
		int arrAnswer[][] = new int[172][172]; // 변경된 값을 가지고 있는 배열
		
		for(int i=0; i<a; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<b; j++) {
				arr[i][j] =  Integer.parseInt(str.nextToken()); 
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int re=0; re<k; re++) {
			int sum = 0;  // 주위 값을 저장하는 변수
			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) {
					if(i==0) {
						if(j==0) {
							sum = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
						}else if(j==(b-1)) {
							sum = arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j];
						}else {
							sum = arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1];
						}
					}else if(i==(a-1)) {
						if(j==0) {
							sum = arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1];
						}else if(j==(b-1)) {
							sum = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j];
						} else {
							sum = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1];
						}
					} else {
						if(j==0) {
							sum = arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j];
						}else if(j==(b-1)) {
							sum = arr[i-1][j] + arr[i-1][j-1] + arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j];
						} else {
							sum = arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i-1][j+1] + arr[i-1][j]+arr[i-1][j-1]+arr[i][j-1]+arr[i+1][j-1];
						}
					}
					if(arr[i][j] == 0){
						if(sum==x){
							arrAnswer[i][j] = 1;
						}
					} else {
				    	if(sum<y || sum>=z) {			//죽이는 조건	
							arrAnswer[i][j] = 0;
						} else if(sum>=y || sum<z){		//살리는 조건
							arrAnswer[i][j] = 1;
						}
					}
				}
			}
			
			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) {
					arr[i][j] =arrAnswer[i][j];
				}
			}
		}
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}

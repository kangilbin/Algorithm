import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[10][10];
		
		for(int i=0; i<10; i++) {	//기본 셋팅
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<10; i++) {	      //물풍선 터진 값 변경
			for(int j=0; j<10; j++) {
				if(!(arr[i][j]==-1 ||arr[i][j]==0)) {	//물풍선 일 때 
					
					for(int r=1; r<=arr[i][j]; r++) {
						if(i-r<0) break;
						if(arr[i-r][j]==-1) {
							break;
						} else if(arr[i-r][j]==0){
							arr[i-r][j] = -2;
						}
					}
					
					for(int r=1; r<=arr[i][j]; r++) {
						if(i+r>9) break;
						if(arr[i+r][j]==-1) {
							break;
						} else if(arr[i+r][j]==0){
							arr[i+r][j] = -2;
						}
					}
					
					for(int c=1; c<=arr[i][j]; c++) {
						if(j-c<0) break;
						if(arr[i][j-c]==-1) {
							break;
						} else if(arr[i][j-c]==0) {
							arr[i][j-c] = -2;
						}
					}
					
					for(int c=1; c<=arr[i][j]; c++) {
					    if(j+c>9) break;
						if(arr[i][j+c]==-1) {
							break;
						} else if(arr[i][j+c]==0) {
							arr[i][j+c] = -2;
						}
					}
					arr[i][j] = -2;
				} 
			}
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		int player = Integer.parseInt(br.readLine());	// 플레이어 수
		for(int i=0; i<player; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;	// 플레이어 위치 행
			int c = Integer.parseInt(st.nextToken()) - 1;	// 플레이어 위치 열
			if(!(arr[r][c] == -1 ||arr[r][c] ==-2)) {
				arr[r][c] = i+1;
				map.put(i+1, "survive");
			} else {
				map.put(i+1, "dead");
			}
		}
		
		for(int[] reseult : arr) {
			for(int answer : reseult) {
				System.out.print(answer + " ");
			}
			System.out.println("");
		}
		
		System.out.println("Character Information");
		for(int i=1; i<=player; i++) {
			System.out.println("player " + i+" " +map.get(i));
		}
		
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int load[][] = new int[10][10];
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<10; j++) {
				load[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int A = 1;
		boolean isTrue = true;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(isTrue){
					if(0<i && i<9) {
						if(A<=j) {
						    if(load[i][j] == 2) {
						        load[i][j] = 9;
								isTrue =false;
								break;
							}
							if(load[i][j]==0) {
								load[i][j] = 9;
							}
							if(load[i][j+1] == 1) {
								if(load[i+1][j] == 2) {
									load[i+1][j] = 9;
									isTrue =false;
									break;
								}
							    if(load[i+1][j] != 1) {
									load[i+1][j] = 9;
								}
								A = j;
								break;
							} else if(load[i][j+1] == 2) {
								load[i][j+1] = 9;
								isTrue =false;
								break;
							}
						}
					}
				}
			}
		}
		
		for(int[] result : load) {
			for(int resultF : result) {
				System.out.print(resultF + " ");
			}
			System.out.println("");
		}
	}
}

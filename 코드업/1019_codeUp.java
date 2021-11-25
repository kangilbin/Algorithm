import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{

   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("[.]");
		String result = "";
		if(arr[0].length() < 5) {
			for(int i=arr[0].length(); i<4; i++) {
				arr[0] = "0"+arr[0];
			}
			result = arr[0];
		}
		
		for(int i=1; i<3; i++) {
			if(Integer.parseInt(arr[i]) < 10) {
				arr[i] = "0" + Integer.parseInt(arr[i]);
			} 
			result += "."+arr[i];
	    }
		System.out.println(result);
	}
}

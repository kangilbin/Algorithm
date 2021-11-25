import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{

   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double N =  Double.parseDouble(br.readLine());
		
		System.out.printf("%d\n", (int) N);
		System.out.print(Double.toString(N).substring(Double.toString(N).indexOf(".")+1));
            

	}
}

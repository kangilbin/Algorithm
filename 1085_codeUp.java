import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long h =  Integer.parseInt(st.nextToken()); 
		long b =  Integer.parseInt(st.nextToken()); 
		long c =  Integer.parseInt(st.nextToken()); 
		long s =  Integer.parseInt(st.nextToken()); 
		double num = h*b*c*s;
		double result = num/8/1024/1024; 
		System.out.println(Math.round(result*10)/10.0 + " MB");
   	}
}

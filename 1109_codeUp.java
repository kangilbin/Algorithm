import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		int age = Integer.parseInt(br.readLine());
		String part = br.readLine();
		double key = Double.parseDouble(br.readLine());
		
		System.out.print(name+"\n"+age+"\n"+part+"\n"+key);
   	}
   	
}

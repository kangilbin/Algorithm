import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Student student[] = new Student[num];
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			student[i] = new Student(i+1, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(student);
		
		for(int i=0;i<num;i++)
			System.out.println(student[i]);
	     
   	}
}

class Student implements Comparable<Student>{
	int num; 
	int math; 
	int info; 
	public Student(int num, int math, int info){
		this.num = num;
		this.math = math;
		this.info = info;
	}
	public String toString(){ 
		return num+" "+math+" "+info;
	}
	public int compareTo(Student anotherStudent) {
		if(math > anotherStudent.math) {
			return -1;
		} else if(math < anotherStudent.math) {
			return 1;
		}
		return Integer.compare(anotherStudent.info, info);
	}
}

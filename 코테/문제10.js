import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        String star = "";
        for (int i=0; i<a; i++) {
            star += "*";
            System.out.println(star);
        }
    }
}
package ps.recursive;

import java.util.Scanner;

public class Factorial {
    public int DFS(int num) {
        if(num == 0) return 1;
        else {
            return num * DFS(num-1);
        }
    }
    public static void main(String[] args) {
        Factorial O = new Factorial();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(O.DFS(num));
    }
}

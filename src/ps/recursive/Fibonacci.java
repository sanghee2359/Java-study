package ps.recursive;

import java.util.Scanner;

// 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
public class Fibonacci {

    public int DFS(int num) {
        if(num == 1) return 1;
        else if(num == 2) return 1;
        else {
            return DFS(num-1)+DFS(num-2);
//            arr[num] = arr[num-1]+arr[num-2];
        }

    }
    public static void main(String[] args) {
        Fibonacci O = new Fibonacci();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(O.DFS(num));
    }
}

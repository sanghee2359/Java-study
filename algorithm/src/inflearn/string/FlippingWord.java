package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlippingWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            char[] c = arr[i].toCharArray();
            int lt = 0, rt = arr[i].length() - 1;
            while(lt < rt){
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt ++;
                rt --;
            }
            String flippingWord = String.valueOf(c);
            System.out.println(flippingWord);
        }
    }
}

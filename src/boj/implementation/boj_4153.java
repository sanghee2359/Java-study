package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4153 {
    public int findMax(String[] strings) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < strings.length; i++) {
            int tmp = Integer.parseInt(strings[i]);
            if(max < tmp) {
                max = tmp;
                idx = i;
            }
            //  max 값의 인덱스가 나옴
        }
        return idx;
    }
    public String isPythagoras(String[] strings, int maxIdx){
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            if(i == maxIdx) continue;
            int tmp = Integer.parseInt(strings[i]);
            sum += (int) Math.pow(tmp, 2);
        }
        int longest = Integer.parseInt(strings[maxIdx]);
        if(Math.pow(longest, 2) == sum) return "right";
        else return "wrong";
    }
    public static void main(String[] args) throws IOException {
        boj_4153 T = new boj_4153();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String str = "";
        while(!(str = br.readLine()).equals("0 0 0")){
            String[] strings = str.split(" ");
            System.out.println(T.isPythagoras(strings, T.findMax(strings)));
        }


    }
}

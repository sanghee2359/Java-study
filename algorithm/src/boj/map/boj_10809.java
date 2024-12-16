package boj.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// 첫째 줄에 단어 S가 주어진다.
// 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
//
//각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치,
// ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
//  어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다.
public class boj_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String str = br.readLine();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char i = 97; i < 123; i++) {
            map.put(i, -1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == -1) map.put(str.charAt(i), i);
        }
        for (char key : map.keySet()) {
            System.out.print(map.get(key)+" ");
        }
    }
}

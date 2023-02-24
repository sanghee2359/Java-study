package inflearn.string;
// 특정 문자가 문자열에 몇 개 존재하는지 알아내는 프로그램

import java.util.Scanner;

public class FindLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        String word = sc.nextLine().toLowerCase();;
        String letter = sc.nextLine().toLowerCase();;
        int answer = 0;

        // equals() 메소드 비교
        for (int i = 0; i < word.length(); i++) {
            String cur = String.valueOf(word.charAt(i));
            if(cur.equals(letter)) answer++;
        }
        System.out.println(answer);
    }
}

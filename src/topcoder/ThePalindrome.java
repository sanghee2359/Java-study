package topcoder;

import java.util.ArrayList;
import java.util.List;

public class ThePalindrome {
    // a b c c c c ?
    public void find(String s){
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
         } // input
        charList.add('?');
        // 탐색
        for (int i = 0; i < charList.size()/2; i++) {
            if(charList.get(i) != charList.get(charList.size() -1 - i)){
                charList.add('?');
            }
            // 조건 : 첫 번째 n번째가 같은가?
            // 아님 => 첫번 째는 건너뛰고 다음 단어를 점검
            // 조건 : 두 번째와 n-1번째가 같은가?
            // 아님 => 아닐 경우 charList에 또 다시 ?를 추가
        }
        for (int i = 0; i < charList.size(); i++) {
            System.out.println(i + " : " +charList.get(i));
        }
    }

    public static void main(String[] args) {
        ThePalindrome T = new ThePalindrome();
        T.find("abcccc");
    }

}

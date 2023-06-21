package ps.string;
// 알파벳 대문자로 이루어진 문자열을 입력받아
// 같은 문자가 연속으로 반복되는 경우 반복되는
//문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램
import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression T = new StringCompression();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }

    private String solution(String s) {
        String answer = "";
        s= s+" ";
        int sum = 1;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) sum++;
            else if(s.charAt(i) != s.charAt(i+1)){
                answer+=s.charAt(i);
                if(sum>1){
                    answer+=String.valueOf(sum);
                    sum = 1;
                }
            }
        }

        return answer;
    }
}

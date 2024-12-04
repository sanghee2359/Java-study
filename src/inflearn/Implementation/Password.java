package inflearn.Implementation;
import java.util.*;
// 1. 상하좌우 & 대각선에 위치한 키패드로 이동하는 시간 1초
// 2. 그렇지 않은 경우 2초 소요
// 3. 현재 키패드의 숫자에 패스워드를 입력했을 때 걸리는 시간을 출력
public class Password {
    public int[][] composeKeypad(int[] keypad) {
        int[][] answer = new int[3][3];
        int d1 = 0, d2 = 0;
        for(int i = 0; i < keypad.length; i++ ){
            answer[d2][d1] = keypad[i];
            d1 = (d1+1) % 3;
            if(d1 == 0) d2++;
        }
        return answer;
    }
    public int[] findFirst(int[][] keypad, String password) {
        String first = password.substring(0, 1);
        int num = Integer.parseInt(first);
        System.out.println(first+" "+num);
        int i = 0, idx = 0;
        for (i = 0; i < keypad.length; i++) {
            idx = Collections.singletonList(keypad[i]).indexOf(num);
            if(idx != -1) break;
        }
        return new int[]{i, idx};
    }
    public int solution(int[] keypad, String password){
        int answer = 0;
        // 1. 키패드 구성에 맞게 2차원 배열로 옮겨야할까?
        int[][] square = composeKeypad(keypad);
        // 2. dx, dy를 대각선까지 포함시켜 반복문으로 방문하며 값을 확인해야할까?
        // 3. 키의 위치마다 근접한 키의 조건이 다른데 어떻게 처리할까
        int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

        // 첫번째 위치 값
        int[] first = findFirst(square, password);
        int x = first[0];
        int y = first[1];

        for (int i = 0; i < password.length(); i++) {
            // 가장자리의 키일 경우, 1초 내에 도착가능한 키가 3개
            // 사면 중 한가운데 키일 경우, 5개의 키가 가능
            // 한가운데의 키인 경우, 모두 1초 내에 도착 가능
        }
        return answer;
    }

    public static void main(String[] args){
        Password T = new Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}

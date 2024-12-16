package pg;

import java.util.*;

public class PG_17684 {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int mapIdx = 1;
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(char i = 'A'; i<='Z'; i++){
            map.put(i+"", mapIdx++);
        }
        int size = msg.length();
        for (int i = 0; i < size; i++) {
            int a = 1;
            // 현재 위치(i) + 글자개수(a)가 msg의 길이보다 작고, 사전에 저장되어 있는 문자인지 확인
            while(i+a <= size && map.containsKey(msg.substring(i,i+a))){
                a++;
            }
            // 현재 위치(i) + 글자개수 (a)가 msg의 길이를 벗어나면
            // msg의 남은 문자의 인덱스를 저장한 후 종료
            if(i+a>size) {
                answer.add(map.get(msg.substring(i)));
                break;
            }
            // 사전에 존재하는 문자의 인덱스를 구하는 과정
            // 21라인에서 a++를 했으니 -1을 하고 검색한다.
            answer.add(map.get(msg.substring(i,i+a-1)));
            map.put(msg.substring(i, i+a), mapIdx++);

            // 이후 시작점부터 i가 돌게끔, 이후 시작점은 i+a-1인데, for문에서 ++을 해주니, 1을 뺸것
            if(a>1) i+=a-2; // i= i+a-2
        }

        return answer;
    }

    public static void main(String[] args) {
        PG_17684 T = new PG_17684();
        String msg = "KAKAO";
        System.out.println(T.solution(msg));
    }
}

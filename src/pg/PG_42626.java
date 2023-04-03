package pg;

import java.util.*;

// Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
// 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
public class PG_42626 {
    public static List<Integer> combineList;

    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < scoville.length; i++) {
            list.add(scoville[i]); // 오름차순 정렬
        }
        while(list.size() > 1) {
            Collections.sort(list);
            List<Integer> combineList = combineScoville(list);// 결합
            int check = 0;
            for (int i = 0; i < combineList.size(); i++) {
                if(combineList.get(i)<K) check++;
            }
            answer++;
            list = combineList;
            if(check == 0) break;
        }
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if(list.size() == 1 && list.get(0) < K) answer = -1;

        return answer;
    }
    public List<Integer> combineScoville(List<Integer> list){
        int combineScov = 0;
        combineScov = list.get(0) + (list.get(1) * 2); // 섞기

        combineList = new ArrayList<>();
        combineList.add(combineScov);

        for (int i = 2; i < list.size(); i++) {
            combineList.add(list.get(i));
        }
        return combineList;
    }

    public static void main(String[] args) {
        PG_42626 T = new PG_42626();
        int K = 7;
        int[] scoville = {1,2,3,9,10,12};
        System.out.println(T.solution(scoville, K));
    }
}

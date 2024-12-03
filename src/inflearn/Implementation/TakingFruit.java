package inflearn.Implementation;
import java.util.*;
// a는 사과만, b 배만, c는 귤이 담겨있고 학생은 3중 하나 가져간다
// 허나 조건으로 이 셋 바구니 중 가장 적게 과일이 담긴 바구니를 가져가야 한다.
// 한 번 다른 사람과 하나의 과일 바구니 안의 과일 한 개를 교환가능
// 최대한 현재의 최소값을 높이는 방법이 이득이 생기는 것이다.
// 서로 이득인 경우 -> 나의 최소 개수 과일을 상대가 가져가려 하면 안되겠지

public class TakingFruit {

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length; // 학생 수
        int[] min_volume = new int[n];
        int[] min_value = new int[n];
        // 즉, 나의 최소과일은 상대는 넉넉해야하고,
        // 또한 상대의 최소과일을 내가 넉넉히 ㄱ갖고 있는 과일이어야하겠다.
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int j = 0; j < 3; j++) {
                if (fruit[i][j] < min) {
                    min = fruit[i][j]; // 사과, 배, 귤 증 최소 개수의 과일의 인덱스를 저장
                    idx = j;
                }
            }
            min_volume[i] = idx;
        }
        System.out.println(Arrays.toString(min_volume));
        for(int i=0; i < n; i++ ){
            if(min_value[i] > 0) continue;
            for (int j = i+1; j < n; j++) {
                int d1 = min_volume[i];
                int d2 = min_volume[j];
                if(d1 != d2  // 서로의 최소 개수의 과일이 서로 다르고
                        && min_value[i] == 0    // 교환한 적 없는 학생끼리만 교환
                        && min_value[j] == 0) {
                    min_value[i] = fruit[i][d1] + 1; // 상대의 과일을 하나
                    min_value[j] = fruit[j][d2] + 1;
                    System.out.println(i+"학생의 최소 개수 교환 후 : "+min_value[i]);
                    System.out.println(j+"학생의 최소 개수 교환 후 : "+min_value[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(min_value[i] == 0) {
                int d = min_volume[i];
                min_value[i] = fruit[i][d];
                System.out.println("교환 못한 학생의 최소과일 개수 : "+min_value[i]);
            }
        }
        answer = Arrays.stream(min_value).sum();


        return answer;
    }

    public static void main(String[] args){
        TakingFruit T = new TakingFruit();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
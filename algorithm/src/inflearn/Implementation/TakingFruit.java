package inflearn.Implementation;
import java.util.*;

// 서로 교환했을 때 이득이 나는 조건 (세분화)
// 1. 각 학생의 최솟값은 유일(최소개수의 과일이 여러 개이면 안됨)
// 2. 서로 교환하려고 하는 두 학생의 과일이 서로 달라야 함
// 3. 교환했을 때 +1 증가된 과일의 최소개수가 이전처럼 과일 중 최솟값임이 유지되어야 함

// 리팩토링 :
public class TakingFruit {
    public int getMin(int[] fruit) { // 최소값
        int min = 100;
        for(int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }
    public Boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int x : fruit) {
            if(x == min) cnt++;
        }
        return cnt == 1;
    }
    public int getMinIdx(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < 3; i++) {
            if (fruit[i] == min) return i;
        }
        return 0;
    }

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length; // 학생 수
        int[] ch = new int[n];

        for(int i=0; i < n; i++ ){
            if(ch[i] == 1) continue;
            if(!isMinUnique(fruit[i])) continue;
            for (int j = i+1; j < n; j++) {
                if(ch[j] == 1) continue;
                if(!isMinUnique(fruit[j])) continue;
                int d1 = getMinIdx(fruit[i]);
                int d2 = getMinIdx(fruit[j]);
                if(d1 != d2 && fruit[i][d2] > 0 && fruit[j][d1] > 0){
                    if(fruit[i][d1] + 1 <= fruit[i][d2] - 1
                            && fruit[j][d2] + 1 <= fruit[j][d1] - 1) {
                        fruit[i][d1] ++;
                        fruit[j][d2] ++;
                        fruit[i][d2] --;
                        fruit[j][d1] --;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int[] x : fruit) {
            answer += getMin(x);
        }
        System.out.println(Arrays.toString(ch));


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
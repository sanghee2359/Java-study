// 한 행씩 땅따먹기로 내려오는데, 같은 열이 반복되면 안되는 조건
public class PG {
    int solution(int[][] land) {
        int answer = 0;
        for (int i = 1; i < land.length; i++) { // 행
            for (int j = 0; j < 4; j++) { // 열
                land[i][j] += maxValue(land[i-1], j);
                answer = Math.max(answer, land[i][j]);
            }
        }
        return answer;
    }
    int maxValue(int[] prevRow, int prevIdx){
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            if(i != prevIdx) {
                tmp = Math.max(tmp, prevRow[i]);
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        PG pg = new PG();
        System.out.println(pg.solution(land));
    }
}

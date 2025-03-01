package inflearn.sorting;

import java.util.ArrayList;

public class MeetingPlace {
    public int solution(int[][] board){
        int answer=0, n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a,b)-> a-b);
        int x = row.get(row.size()/2);
        int y = col.get(col.size()/2);
        for(int p: row) answer+= Math.abs(x - p);
        for(int p: col) answer+= Math.abs(y - p);
        // 각 적정한 장소의 좌표를 구함

        return answer;
    }

    public static void main(String[] args){
        MeetingPlace T = new MeetingPlace();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}

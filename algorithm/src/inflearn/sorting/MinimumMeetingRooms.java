package inflearn.sorting;

import java.util.Arrays;

public class MinimumMeetingRooms {
    public int solution(int[][] meetings){
        int answer = 0, n = meetings.length;
        int[][] list = new int[n*2][2];
        int idx = 0;
        for (int i = 0; i < list.length; i+=2) {
            list[i][0] = meetings[idx][0];
            list[i][1] = 1;
            list[i+1][0] = meetings[idx][1];
            list[i+1][1] = 2;
            idx++;
        }
        // 만약 시작하는 시간 == 끝나는 시간이라면, 끝나는 시간이 먼저 수행되도록 정렬
        Arrays.sort(list, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0, max = 0;
        for(int[] m : list) {
            if(m[1] == 1) count++;
            else if(m[1] == 2) count--;
            max = Math.max(count, max);
        }
        return max ;
    }

    public static void main(String[] args){
        MinimumMeetingRooms T = new MinimumMeetingRooms();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(+T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}

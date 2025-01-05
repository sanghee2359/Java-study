package inflearn.data_structure;

import java.util.*;

public class MostUsedConferenceRoom {
    public int solution(int n, int[][] meetings) {
        int max = 0, idx = 0;
        int answer = 0, num = meetings.length, endTime = 0, roomNum = 0;
        int[] result = new int[n];
        TreeSet<Integer> rooms = new TreeSet<>();
        LinkedList<int[]> meetingSort = new LinkedList<>();
        // 일찍 끝나는 회의가 가장 먼저 오면서, 시간이 같다면 더 작은 번호를 가진 회의실부터 우선 정렬
        PriorityQueue<int[]> usingRoom = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            rooms.add(i); // 회의실 방 번호 오름차순 정렬
        }
        for (int i = 0; i < num; i++) {
            meetingSort.add(new int[]{meetings[i][0], meetings[i][1]}); // 도착 시간, 회의 시간
        }
        meetingSort.sort((a, b) -> a[0] - b[0]); // 도착 시간을 기준으로 정렬


        while (!meetingSort.isEmpty() || !usingRoom.isEmpty()) {
            // 비어있는 회의실이 있고, 진행해야할 회의가 남았을 경우
            if (!rooms.isEmpty() && !meetingSort.isEmpty()) {
                roomNum = rooms.pollFirst();
                int[] now = meetingSort.pollFirst();
                endTime = now[1]; // 끝나는 시간
                usingRoom.add(new int[]{endTime, roomNum});
            }else if(rooms.isEmpty() && !usingRoom.isEmpty()){
                // rooms에 남은 회의실이 없는 경우
                // 회의실을 쓰는 시간은 (끝난시간 - 도착시간) 즉, 차액만큼 쓴다
                usingRoom.peek()[0]; // 가장먼저 끝나는 회의가 끝날때롤 점프
                roomNum = usingRoom.peek()[1]; // roomNum 갱신
                int[] now = meetingSort.pollFirst(); // 다음 회의 진행할 것
                int time = now[1] - now[0];
                endTime = endTime + time;
                usingRoom.add(new int[] {endTime, roomNum});
            }
            // 도착하는 시간보다 현재 방 사용이 끝나는 시간이 더 작거나 같다면?
            // room에 사용했던 번호 추가,
            // result에 room number +1 업데이트
            while (!meetingSort.isEmpty()
                    && usingRoom.peek()[0] <= meetingSort.peek()[0]) {
                int[] endMeeting = usingRoom.poll();
                int endRoomNum = endMeeting[1];
                rooms.add(endRoomNum); // 사용한 방번호를 추가
                result[endRoomNum]++;
            }

        }
        for (int i = 0; i < n; i++) {
            if(max < result[i]){
                max = result[i];
                idx = i;
            }
        }
        return answer = idx;
    }

    public static void main(String[] args){
        MostUsedConferenceRoom T = new MostUsedConferenceRoom();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}

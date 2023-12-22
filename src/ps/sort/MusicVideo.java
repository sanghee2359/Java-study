package ps.sort;

import java.util.*;
// live video 만들어 판매한다.
// DVD에는 총 N개의 곡이 들어가는데, 녹화할 때 라이브에서의 순서와 동일하다
// 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다.
// 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.

public class MusicVideo {
    private int MinimumVolume(int m, int[] arr) {
        int answer = 0;

        int lt = Arrays.stream(arr).max().getAsInt(); // 해당 배열 중 가장 큰 숫자
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt+rt) / 2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid-1;
            } else lt = mid+1;
        }
        return answer;
    }
    // dvd 용량이 주어질 때 dvd가 총몇장 필요한지 출력하는 메소드
    public int count(int[] arr, int capacity) {
        // cnt = dvd 장 수
        int cnt = 1, sum = 0; // 현재까지 저장된 dvd 용량
        for (int x : arr) {
            if(sum+x > capacity) {
                cnt++;
                sum = x; // 초기화
            }else sum+= x;
        }
        return cnt;
    }
    public static void main(String[] args) {
        MusicVideo O = new MusicVideo();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(); // 저장할 곡의 개수
        int m = in.nextInt(); // 사용되는 DVD 개수
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(O.MinimumVolume(m, arr));
    }

}

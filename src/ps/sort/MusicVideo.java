package ps.sort;

import java.util.Arrays;
import java.util.Scanner;
// live video 만들어 판매한다.
// DVD에는 총 N개의 곡이 들어가는데, 녹화할 때 라이브에서의 순서와 동일하다
// 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다.
// 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.

public class MusicVideo {
    private int MinimumVolume(int n, int m, int[] arr) {
        int answer = 0;
        // 정렬 먼저
        Arrays.sort(arr);
        int volume = 0;
        for (int i = 0; i < n; i++) { // m은 dvd 개수
            volume+=arr[i];
        }

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if(tmp == volume/m) {
                answer = tmp;
                tmp = 0;
            }else if(tmp > volume/m){
                i = i-1;
                tmp = 0;
            }
            tmp += arr[i];
        }
        return answer= tmp;
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
        System.out.println(O.MinimumVolume(num, m, arr));
    }

}

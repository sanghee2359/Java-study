package ps.sort;

// N개의 마구간이 수직선상에 있습니다.
// 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
// 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
//
// C마리, N개의 마구간에 배치 시,
// 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성
import java.util.Arrays;
import java.util.Scanner;
public class DecidingStable {
    public int solution(int c, int n, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1, rt = arr[n-1];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(deployable(arr, mid) >= c){
                answer = mid;
                lt = mid+1;
            }else rt = mid-1;
        }

        return answer;
    }
    // count 작성하는 것이 중요
    public int deployable(int[] arr, int mid) {
        int count = 1, ep = arr[0]; // ep = 바로 전에 배치한 마구간의 좌표

        for (int i = 1; i < arr.length; i++) { // 0번 인덱스는 배치했으므로 1번부터 점검
            if(arr[i] - ep >= mid) { // 주어진 거리보다 크거나 같으면 배치.
                count++;
                ep = arr[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        DecidingStable O = new DecidingStable();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 마구간 수
        int c = sc.nextInt(); // 말의 개수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(O.solution(c, n, arr));

    }
}

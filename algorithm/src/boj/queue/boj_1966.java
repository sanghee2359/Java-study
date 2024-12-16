package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
// 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가
// 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
public class boj_1966 {
    static LinkedList<int[]> queue;
    public static int findDocument(int M) {
        int count = 0;

        while(!queue.isEmpty()) {
            int[] front = queue.poll();
            boolean isMax = true;
//            System.out.println(front[0]+" "+front[1]);
            for (int i = 0; i < queue.size(); i++) {
                // 큐 안에 중요도가 더 큰 값이 있는 경우
                if(front[1] < queue.get(i)[1]) {
                    // 현재 poll한 값을 뒤로 보낸 후
                    queue.offer(front);
                    // i 이전의 원소들을 뒤로 넣는다
                    for (int j = 0; j < i; j++) {
                        queue.offer(queue.poll());
                    }

                    isMax = false;
                    break;
                }
            }
            if(isMax == false) {
                continue;
            }
            count++;
            if(front[0] == M) {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // test case
        // 첫 번째 줄 문서의 개수/ queue에서 몇 번째 위치인지
        // 두 번째 줄 N개 문서의 중요도가 차례대로 주어진다.
        while (T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // queue의 N번째에 위치

            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

//            String[] string = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            sb.append(findDocument(M)).append('\n');
        }
        System.out.println(sb);
    }
}

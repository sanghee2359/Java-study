package study;
// 징검다리가 있는 개울을 만나서 건너편으로 건너려고 합니다.
// "라이언" 선생님은 "니니즈 친구들"이
// 무사히 징검다리를 건널 수 있도록 다음과 같이 규칙을 만들었습니다.
//디딤돌에는 모두 숫자가 적혀 있으며 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.
// 디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며
// 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.


public class SteppingStone {
    public static void main(String[] args) {
        SteppingStone T = new SteppingStone();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(T.solution(stones, k));
    }
    public int solution(int[] stones, int k) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int x : stones) {
            if (x > high)
                high = x;
        } // stones 배열 중 max값

        // 이분탐색
        while(low <= high) {
            int mid = (low + high) /2;
            if(bs(stones, mid, k)) high = mid -1;
            else low = mid +1;
        }
        return low; // 징검다리를 건널 수 있는 친구 수
    }

    // stones배열 순회하며 mid값을 빼주고, 결과가 0 이하일 경우 count++
    // count값과 k를 비교하면서 boolean
    private boolean bs(int[] stones, int mid, int k) {
        int count = 0; // 징검다리의 숫자가 k만큼 있는지 확인
        for (int i = 0; i < stones.length; i++) {
            if(stones[i] - mid <= 0) count++;
            else count = 0;
            if(count >= k) return true;
        }
        return false;
    }
}

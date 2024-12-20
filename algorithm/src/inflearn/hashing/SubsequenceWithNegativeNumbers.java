package inflearn.hashing;

public class SubsequenceWithNegativeNumbers {
    // 연속부분수열의 합이 특정숫자 이 되는 경우가 몇 번있는지 구하는 프로그램
    // 제한사항 nums의 길이는 200,000 넘지 않는다.
    // -100,000,000 <= M <= 100,000,000
    // 수열의 원소값은 각 -1000 ~ 1000의 정수
    // 즉, 시간복잡도를 신경써야겠다 -> 무작정 for문 반복은 안됨
    public int solution(int[] nums, int m){
        // 흠..... 해시맵이 필요하나?
        // 얼마나 반복해야 다음 i로 넘어갈지 규칙을 정해줘야겠다.
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, j = i;
            while(sum <= m && j < nums.length) {
                sum += nums[j++];
                if (sum == m) {
                    count++;
                    // 길이가 다르고 합은 m과 동일한 연속 부분수열이 있을 수 있는데,
                    // 어떻게 구현해야 할까?
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        SubsequenceWithNegativeNumbers T = new SubsequenceWithNegativeNumbers();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}

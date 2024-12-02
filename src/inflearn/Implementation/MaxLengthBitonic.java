package inflearn.Implementation;

public class MaxLengthBitonic {
    // 최대 길이 바이토닉 수열 -> 연속부분수열 중 가장 긴 바이토닉 수열 찾기
    public int solution(int[] nums){
        int answer = 0; // 길이
        int len = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 3원자씩 비교
            // 1.값이 클 경우
            if(nums[i] < nums[i+1]) {
                len++;
                continue;
            }
            // 3원소 연속으로 값이 계속 작아질 경우
            else if(nums[i] > nums[i+1] && nums[i+1] > nums[i+2]) {
                // 다시 작아지기만 해야 바이너리 수열이며, 숫자가 커진다면 종료
                // 바이너리 수열의 개수 추가
                while(nums[i] > nums[i+1] && nums.length - 1 != i+1) {
                    i++;
                    len++;
                }// 맨 마지막 원소. 이걸 잡지 못하고 있는게 원인이다
            }
            // 2.작아지고 커질 경우
            else if(nums[i] > nums[i+1] && nums[i+1] < nums[i+2]) {
                len = 1;
                continue;

            } // 3.중복값
            else if(nums[i] == nums[i+1]) len =1;



            if(max < len) max = len;
        }
        answer = max;
        return answer;
    }

    public static void main(String[] args){
        MaxLengthBitonic T = new MaxLengthBitonic();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
